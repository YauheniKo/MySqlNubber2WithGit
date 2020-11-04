package service.service_class;

import bean.Car;
import bean.Role;
import dao.dao_class.DAOFactory;
import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements ServiceInterf<Role> {

    @Override
    public Role search(int id) throws ServiceException {
        DAOFactory daoFactory = null;
        Role role = null;

        try {
            daoFactory = DAOFactory.getInstance();
            role = (Role) daoFactory.getRoleDAO().search(id);

        } catch (DAOException e) {
            throw new ServiceException("Пользователь не найдено");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return role;

    }

    @Override
    public Role search(String login, String password) throws ServiceException {
        DAOFactory daoFactory = null;
        Role role = null;

        try {
            daoFactory = DAOFactory.getInstance();
            role = (Role) daoFactory.getRoleDAO().search(login, password);

        } catch (DAOException e) {
            throw new ServiceException("Пользователь не найдено");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return role;

    }

    @Override
    public boolean create(Role role) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getRoleDAO().create(role);


        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }

        return res;

    }

    @Override
    public boolean delete(Role role) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getRoleDAO().delete(role);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Пользователь не удален");
        }

        return res;
    }

    @Override
    public List<Role> getAll() throws ServiceException {
        List<Role> res;

        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getRoleDAO().getAll();
            if (res == null) {
                throw new DAOException();
            }
        } catch (DAOException | SQLException e) {
            throw new ServiceException("Авто не добавлено");
        }


        return res;
    }
}
