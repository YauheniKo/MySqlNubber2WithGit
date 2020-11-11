package command.command_class;

import bean.User;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class DeleteUser implements Command {
    @Override
    public String execute(String request) throws CommandException {

        String[] mas = request.split(", ");
        boolean isRes = false;
        String res;
        try {

            String login = mas[1];




            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf serviceInterf = serviceFactory.getServiceRole();

            User user = new User(login);
            isRes = serviceInterf.delete(user);
            if (isRes = true) {
                res = "Пользователь удален";
            } else res = "Ошибка";

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return res;


    }
}
