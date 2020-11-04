package dao.dao_class;

import bean.Car;
import bean.Role;
import dao.dao_exception.DAOException;
import dao.dao_interf.DAOInterf;

public class DAOFactory  {
    private static final DAOFactory instance = new DAOFactory();

    private DAOInterf<Car> carDAO = new CarDAO();
    private  DAOInterf<Role> roleDAO=new RoleDAO();


    private DAOFactory(){

    }


    public static DAOFactory getInstance(){
        return instance;
    }

    public DAOInterf getCarDAO() {
        return carDAO;
    }
    public DAOInterf getRoleDAO() {
        return roleDAO;
    }
}
