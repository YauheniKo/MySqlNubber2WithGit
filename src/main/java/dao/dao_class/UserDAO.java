package dao.dao_class;

import bean.User;
import dao.dao_exception.DAOException;
import dao.dao_interf.DAOInterf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAOInterf<User> {
    private static final String URL = "jdbc:mysql://localhost:3306/" +
            "mydbtest3?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static final String INSERT_NEW = "INSERT INTO user (login, password,role_id) VALUES (?,?,?)";
    public static final String DELETE = "DELETE FROM user  WHERE login=?";
    public static final String GET_ALL = "SELECT*FROM user ";
    public static final String CHANGE = "UPDATE user SET password=? where login=?";


    @Override
    public User search(int ident) throws DAOException, SQLException {
        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String login = res.getString("login");
                String password = res.getString("password");
                int role_id=res.getInt("role_id");

                if (ident == id) {

                    user = new User( login, password,role_id);

                }

            }
            if(user==null){
                throw new DAOException("Пользователь не найдено");
            }
        } catch (SQLException e) {
            throw new DAOException("Пользователь не найдено");
        }

        if (user == null) {
            throw new DAOException("Пользователь не найден");
        } else return user;


    }

    @Override
    public User search(String log, String passw) throws  SQLException,DAOException {

        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {

                String login = res.getString("login");
                String password = res.getString("password");
                int roles = res.getInt("role_id");
                if (log.equalsIgnoreCase(login) && passw.equals(password)) {
                    user = new User(login, password, roles);
                    break;
                }
            }
            if (user ==null)
                throw new DAOException();




        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;

    }

    @Override
    public boolean create(User user) throws DAOException, SQLException {
        boolean res = true;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {
                String log = result.getString("login");

                if (log.equalsIgnoreCase(user.getLogin()) && log != null) {
                    throw new DAOException("логин занят");

                }
            }

            if (res != false) {

                try (PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_NEW)) {
                    preparedStatement1.setString(1, user.getLogin());
                    preparedStatement1.setString(2, user.getPassword());
                    preparedStatement1.setInt(3, user.getRole());

                    preparedStatement1.executeUpdate();

                     return true;

                } catch (SQLException e) {

                }
            }
            else throw new SQLException();

        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка добавления пользователя");

        }

        return false;

    }

    @Override
    public boolean delete(User user) throws DAOException, SQLException {
/*
Я создаю пользователя для того что бы его потом удалить??

 */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean res = true;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

            preparedStatement.setString(1, user.getLogin());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка удаления");
        }
        return res;

    }

    @Override
    public List getAll() throws DAOException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<User> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {

                String log = res.getString("login");
                String passw = res.getString("password");
                int rol = res.getInt("role_id");

                User user = new User(log, passw, rol);
                list.add(user);

            }


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка демонстрации всех авто");
        }

        return list;

    }

    @Override
    public boolean change(User user) throws DAOException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE)) {


            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getLogin());


            if(preparedStatement.executeUpdate()!=1){
                throw new DAOException("Не верный логин");
            }


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка изменения параметров");
        }
        return true;
    }


}
