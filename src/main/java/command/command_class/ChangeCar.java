package command.command_class;

import bean.Car;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class ChangeCar implements Command {

    @Override
    public String execute(String request) throws CommandException {
        String[] mas = request.split(", ");
        String isRes = null;
        boolean requ;
        try {
            if (mas[1] != null & mas[2] != null & mas[3] != null) {
                String id_str = mas[1];
                String model = mas[2];
                String type = mas[3];
                int id = Integer.parseInt(id_str);


                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ServiceInterf<Car> serviceInterf = serviceFactory.getServiceCar();

                Car car = new Car(id, model, type);
                requ = serviceInterf.change(car);

                isRes = "Параметры авто изменены";

                return isRes;
            }

        } catch (ServiceException | ArrayIndexOutOfBoundsException e) {
            isRes = "Ошибка";
        }
        return isRes;

    }
}
