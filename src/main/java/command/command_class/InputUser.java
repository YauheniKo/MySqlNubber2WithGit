package command.command_class;

import bean.User;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class InputUser implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        User user = null;
String res;

        try {

            String login = mas[1];
            String passw = mas[2];

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf<User> serviceInterf = serviceFactory.getServiceRole();

            user = serviceInterf.search(login, passw);

            if (user != null) {

                return user.toString();
            }
            else res="Ошибка";


        } catch (
                ServiceException e) {
            throw new CommandException(e);
        }

        return res;


    }
}
