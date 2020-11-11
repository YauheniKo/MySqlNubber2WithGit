package somePackage;

import bean.User;
import command.command_exception.CommandException;
import dao.dao_class.UserDAO;
import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;

import java.sql.SQLException;


public class MainDAO {


    public static void main(String[] args) throws DAOException, ServiceException, SQLException, CommandException {


        User user =new User("nikita","554422",2);
        UserDAO userDAO =new UserDAO();

       System.out.println(userDAO.search("vasya","442255"));
        System.out.println(userDAO.search(1));
        System.out.println(userDAO.create(user));






    }
}
