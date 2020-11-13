package somePackage;

import bean.Car;
import bean.User;
import command.command_class.GetAll;
import command.command_exception.CommandException;
import controller.Controller;
import dao.dao_class.UserDAO;
import dao.dao_exception.DAOException;
import service.service_class.UserService;
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
        //Car car=new Car(3,"renault", "fura");
        User user=new User("nort","qwerty",2);
        Controller controller=new Controller();

        UserService userService=new UserService();
        //System.out.println(userDAO.search(1));
        //System.out.println(userDAO.getAll());
        //System.out.println(controller.doAction("CREATE, opel, sedan"));
        //System.out.println(controller.doAction("SEARCH_USER_ID, 3"));
        //System.out.println(userDAO.search(3));

        System.out.println(controller.doAction("REGISTRATION, bonya, dfghj, 2"));

        // System.out.println(controller.doAction("GET_ALL_USER"));
        //System.out.println(controller.doAction("GET_ALL"));




    }
}
