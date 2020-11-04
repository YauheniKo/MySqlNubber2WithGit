package command.command_class;

import bean.Car;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

public class Delete implements Command {
    @Override
    public String execute(String request) throws CommandException {

        String[] mas = request.split(", ");
        boolean isRes = false;
        String res;
        try {
            String id_str = mas[1];
            String model = mas[2];
            String type = mas[3];
            int id = Integer.parseInt(id_str);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ServiceInterf serviceInterf = serviceFactory.getServiceCar();

            Car car = new Car(id, model, type);
            isRes = serviceInterf.delete(car);
            if(isRes=true){
                res="Авто удалено";
            }
            else res="Ошибка";

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return res;






    }
}
