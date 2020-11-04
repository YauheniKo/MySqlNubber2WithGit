package command.command_class;

import bean.Car;
import bean.Role;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.util.List;

    public class GetAllUser implements Command {
        @Override
        public String execute(String request) throws CommandException {
            String[] mas = request.split(", ");
            List<Role> list;

            String res = null;
            try {
                //String id_str = mas[1];
                //String model = mas[2];
                //String type = mas[3];
                //int id = Integer.parseInt(id_str);


                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ServiceInterf<Role> serviceInterf = serviceFactory.getServiceRole();

                list = serviceInterf.getAll();
                res = list.toString();
                if (list != null) {

                    return res;
                }


            } catch (ServiceException e) {
                throw new CommandException(e);
            }

            return "Ошибка";

        }
    }
