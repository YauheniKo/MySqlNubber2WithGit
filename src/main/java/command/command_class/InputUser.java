package command.command_class;

import bean.Car;
import bean.Role;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class InputUser implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        Role role = null;
String res;

        try {
            //String id_str = mas[1];
            String login = mas[1];
            String passw = mas[2];
            //int id = Integer.parseInt(id_str);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf<Role> serviceInterf = serviceFactory.getServiceRole();

            role = serviceInterf.search(login, passw);

            if (role != null) {

                return role.toString();
            }
            else res="Ошибка";


        } catch (
                ServiceException e) {
            throw new CommandException(e);
        }

        return res;


    }
}
