package somePackage;

import command.command_exception.CommandException;
import controller.Controller;
import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;

import java.sql.SQLException;


public class MainDAO {


    public static void main(String[] args) throws DAOException, ServiceException, SQLException, CommandException {

        Controller controller=new Controller();
        System.out.println(controller.doAction("CREATE, 5, mazda, universal"));




    }
}
