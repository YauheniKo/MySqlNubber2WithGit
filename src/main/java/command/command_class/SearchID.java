package command.command_class;

import bean.Car;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.util.List;

public class SearchID implements Command {
    @Override
    public  String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        Car car=null;
        boolean isRes=false;

        try {
            String id_str = mas[1];

            int id = Integer.parseInt(id_str);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf<Car> serviceInterf = serviceFactory.getServiceCar();

            car = serviceInterf.search(id);
            if(car!=null){
                return car.toString();
            }


        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return "Ошибка";
    }
}
