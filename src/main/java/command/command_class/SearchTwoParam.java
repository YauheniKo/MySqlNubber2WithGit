package command.command_class;

import bean.Car;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.util.List;

public class SearchTwoParam implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        Car car=null;
        String res;


        try {
            //String id_str = mas[1];
            String model = mas[1];
            String type = mas[2];
            //int id = Integer.parseInt(id_str);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf<Car> serviceInterf = serviceFactory.getServiceCar();

            car = serviceInterf.search(model, type);

            if (car !=null) {

                return car.toString();
            }
            else res="Ошибка";

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return res;

    }
}
