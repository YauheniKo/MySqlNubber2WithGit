package command.command_class;

import bean.User;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class SearchIDUser  implements Command {
    @Override
    public  String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        User user =null;
        boolean isRes=false;

        try {
            String id_str = mas[1];

            int id = Integer.parseInt(id_str);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf<User> serviceInterf = serviceFactory.getServiceRole();

            user = serviceInterf.search(id);
            if(user !=null){
                return user.toString();
            }


        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return "Ошибка";
    }


}
