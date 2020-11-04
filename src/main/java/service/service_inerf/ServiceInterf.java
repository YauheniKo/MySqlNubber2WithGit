package service.service_inerf;

import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;

import java.util.List;

public interface ServiceInterf<T> {

    T search(int id) throws ServiceException;

    T search(String parameter1, String parameter2) throws ServiceException;

    boolean create(T obj) throws ServiceException;

    boolean delete(T obj) throws ServiceException;

    List<T> getAll() throws ServiceException;





}
