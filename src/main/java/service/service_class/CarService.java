package service.service_class;

import bean.Car;
import dao.dao_class.DAOFactory;
import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;
import service.service_inerf.ServiceInterf;

import java.sql.SQLException;
import java.util.List;

public class CarService implements ServiceInterf<Car> {
    @Override
    public Car search(int id) throws ServiceException {
        DAOFactory daoFactory = null;
        Car car = null;

        try {
            daoFactory = DAOFactory.getInstance();
            car = (Car) daoFactory.getCarDAO().search(id);

        } catch (DAOException e) {
            throw new ServiceException("Авто не найдено");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return car;
    }

    @Override
    public Car search(String parameter1, String parameter2) throws ServiceException {
        DAOFactory daoFactory = null;
        Car car = null;

        try {
            daoFactory = DAOFactory.getInstance();

            car = (Car) daoFactory.getCarDAO().search(parameter1, parameter2);

        } catch (SQLException| DAOException e) {
            throw new ServiceException("Авто не найдено");
        }
        return car;
    }

    @Override
    public boolean create(Car car) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res =daoFactory.getCarDAO().create(car);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Авто не добавлено");
        }

        return res;
    }

    @Override
    public boolean delete(Car car) throws ServiceException {
        boolean res;
        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getCarDAO().delete(car);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Авто не удалено");
        }

        return res;

    }


    @Override
    public List<Car> getAll() throws ServiceException {
        List<Car> res;

        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res = daoFactory.getCarDAO().getAll();
            if (res == null) {
                throw new DAOException();
            }
        } catch (DAOException | SQLException e) {
            throw new ServiceException("Произошла ошибка демонстрацииавто");
        }


        return res;
    }
    @Override
    public boolean change(Car car) throws ServiceException {
        boolean res;


        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getInstance();
            res =daoFactory.getCarDAO().change(car);

        } catch (DAOException | SQLException e) {
            throw new ServiceException("Ошибка редактирования авто");
        }

        return res;

    }

}
