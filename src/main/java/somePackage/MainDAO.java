package somePackage;

import bean.Role;
import command.command_class.ChangeCar;
import command.command_exception.CommandException;
import command.command_inerf.Command;
import controller.Controller;
import dao.dao_class.CarDAO;
import dao.dao_class.RoleDAO;
import dao.dao_exception.DAOException;
import service.service_class.CarService;
import service.service_class.RoleService;
import service.service_exception.ServiceException;

import java.sql.SQLException;


public class MainDAO {


    public static void main(String[] args) throws DAOException, ServiceException, SQLException, CommandException {


        RoleService roleService=new RoleService();
        Role role=new Role("Lexa","Sukiiii");


       Controller controller=new Controller();
        System.out.println(controller.doAction("CHANGER_USER_PASS, Lexa, man"));
        //System.out.println(roleService.create(role));





    }
}
