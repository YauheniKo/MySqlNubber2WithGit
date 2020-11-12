package somePackage;

import bean.Car;
import bean.User;
import command.command_exception.CommandException;
import controller.Controller;
import dao.dao_class.CarDAO;
import dao.dao_class.UserDAO;
import dao.dao_exception.DAOException;
import service.service_class.CarService;
import service.service_class.ServiceFactory;
import service.service_exception.ServiceException;

import java.sql.SQLException;
/*
    commands.put("CREATE", new Create());++
        commands.put("DELETE", new Delete());++
        commands.put("GET_ALL", new GetAll());++
        commands.put("SEARCH_ID", new SearchID());++
        commands.put("SEARCH_TWO_PARAM", new SearchTwoParam());++
        commands.put("CHANGER_CAR", new ChangeCar());

        commands.put("REGISTRATION", new RegistrationUser());
        commands.put("INPUT", new InputUser());
        commands.put("GET_ALL_USER", new GetAllUser());
        commands.put("DELETE_USER", new DeleteUser());
        commands.put("SEARCH_USER_ID", new SearchIDUser());
        commands.put("ALL_USER", new GetAllUser());

        commands.put("CHANGER_USER_PASS", new ChangePassUser());
 */


public class MainDAO {


    public static void main(String[] args) throws DAOException, ServiceException, SQLException, CommandException {
        Car car=new Car(3,"renault", "fura");
        User user=new User("harry","qwerty",2);
        Controller controller=new Controller();

        //++System.out.println(controller.doAction("SEARCH_ID, 3"));
        //++System.out.println(controller.doAction("DELETE, 2, renault, fura"));
        //++System.out.println(controller.doAction("CREATE, opel, sedan"));
        //++System.out.println(controller.doAction("SEARCH_TWO_PARAM, opel, sedan"));
        //++System.out.println(controller.doAction("CHANGER_CAR, 3, ford, sedan"));
        //System.out.println(controller.doAction("GET_ALL_USER"));
        System.out.println();

        String s=controller.doAction("GET_ALL");
        System.out.println(s.toString());

    }
}
