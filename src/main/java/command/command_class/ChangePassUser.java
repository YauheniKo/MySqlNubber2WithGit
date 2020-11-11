package command.command_class;

import bean.User;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class ChangePassUser implements Command {

    @Override
    public String execute(String request) throws CommandException {

        String[] mas = request.split(", ");
        String isRes = null;
        boolean requ;
        try {
            if (mas[1] != null | mas[2] != null) {
                String login = mas[1];
                String password = mas[2];


                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ServiceInterf<User> serviceInterf = serviceFactory.getServiceRole();
                User user =new User(login,password);
                        requ = serviceInterf.change(user);

                isRes = "Параметры пользователя изменены";

                return isRes;
            }
            else
                return  "Ошибка";



        } catch (ServiceException | ArrayIndexOutOfBoundsException e) {
            isRes = "Ошибка";
        }
        return isRes;

    }
}
