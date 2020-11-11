package service.service_class;

import bean.User;
import dao.dao_class.DAOFactory;
import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.sql.SQLException;
import java.util.List;

public class UserService implements ServiceInterf<User> {

    @Override
    public User search(int id) throws ServiceException {
        DAOFactory daoFactory = null;
        User user = null;

        try {
            daoFactory = DAOFactory.getInstance();
            user = (User) daoFactory.getRoleDAO().search(id);

        } catch (DAOException e) {
            throw new ServiceException("Пользователь не найдено");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;

    }

    @Override
    public User search(String login, String password) throws ServiceException {
        DAOFactory daoFactory = null;
        User user = null;

        try {
            daoFactory = DAOFactory.getInstance();
            user = (User) daoFactory.getRoleDAO().search(login, password);

        } catch (DAOException e) {
            throw new ServiceException("Пользователь не найдено");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;

    }

    @Override
    public boolean create(User user) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getRoleDAO().create(user);


        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }

        return res;

    }

    @Override
    public boolean delete(User user) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getRoleDAO().delete(user);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Пользователь не удален");
        }

        return res;
    }

    @Override
    public List<User> getAll() throws ServiceException {
        List<User> res;

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

    @Override
    public boolean change(User user) throws ServiceException {
        List<User> list = null;
        boolean res;
        String login = user.getLogin();
        String password = user.getPassword();

        DAOFactory daoFactory = null;
        try {

            daoFactory = DAOFactory.getInstance();
            list = daoFactory.getRoleDAO().getAll();
            for (User rolesCheck : list) {
                if (rolesCheck.getLogin().equalsIgnoreCase(login) &
                        rolesCheck.getPassword().equalsIgnoreCase(password)) {

                    throw new DAOException("Это старый пароль");
                }
            }
            res = daoFactory.getRoleDAO().change(user);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Ошибка изменения  пароля");
        }

        return res;

    }
}
