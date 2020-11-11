package command.command_class;

import bean.User;
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
                String rol = mas[3];
                int roles=Integer.parseInt(rol);

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ServiceInterf serviceInterf = serviceFactory.getServiceRole();

                User user = new User(login, password,roles);
                isRes=serviceInterf.create(user);

                    return "Пользователь добавлен";


            }


        } catch (ServiceException |ArrayIndexOutOfBoundsException e) {
            throw new CommandException(e);
        }
        return "Ошибка";
    }
}
