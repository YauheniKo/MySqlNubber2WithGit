package command.command_class;

import bean.Car;
import bean.Role;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class RegistrationUser implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        boolean isRes ;
        String res=null;
        try {
            if(mas[1]!=null&&mas[2]!=null&&mas[3]!=null){


                String login = mas[1];
                String password = mas[2];
                String roles = mas[3];

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ServiceInterf serviceInterf = serviceFactory.getServiceRole();

                Role role = new Role(login, password,roles);
                isRes=serviceInterf.create(role);

                    return "Пользователь добавлен";


            }


        } catch (ServiceException |ArrayIndexOutOfBoundsException e) {
            throw new CommandException(e);
        }
        return "Ошибка";
    }
}
