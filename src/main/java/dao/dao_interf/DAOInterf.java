package dao.dao_interf;



import dao.dao_exception.DAOException;
import service.service_exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterf<T> {



    T search(int id) throws DAOException, SQLException;

    T search(String parameter1, String parameter2) throws DAOException,SQLException;

    boolean create(T obj) throws DAOException,SQLException;

    boolean delete(T obj) throws DAOException,SQLException;

    List<T> getAll() throws DAOException, SQLException;

   boolean change(T obj) throws DAOException, SQLException;




}
