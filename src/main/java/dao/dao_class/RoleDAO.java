package dao.dao_class;

import bean.Role;
import dao.dao_exception.DAOException;
import dao.dao_interf.DAOInterf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements DAOInterf<Role> {
    private static final String URL = "jdbc:mysql://localhost:3306/" +
            "mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static final String INSERT_NEW = "INSERT INTO role (login, password, role) VALUES (?,?,?)";
    public static final String DELETE = "DELETE FROM role  WHERE login=?";
    public static final String GET_ALL = "SELECT*FROM role ";


    @Override
    public Role search(int ident) throws DAOException, SQLException {
        Role role = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");

                String login = res.getString("login");
                String password = res.getString("password");
                String roles = res.getString("role");
                if (ident == id) {

                    role = new Role( login, password,roles);
                }

            }

        } catch (SQLException e) {
            throw new DAOException("Пользователь не найдено");
        }

        if (role == null) {
            throw new DAOException("Пользователь не найден");
        } else return role;


    }

    @Override
    public Role search(String log, String passw) throws  SQLException,DAOException {

        Role role = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {

                String login = res.getString("login");
                String password = res.getString("password");
                String roles = res.getString("role");
                if (log.equalsIgnoreCase(login) && passw.equals(password)) {
                    role = new Role(login, password, roles);
                    break;
                }
            }



        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return role;

    }

    @Override
    public boolean create(Role role) throws DAOException, SQLException {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet result = preparedStatement.executeQuery();
            boolean res = true;

            while (result.next()) {
                String log = result.getString("login");

                if (log.equalsIgnoreCase(role.getLogin()) && log != null) {
                    res = false;
                    throw new DAOException();

                }
            }

            if (res != false) {

                try (PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_NEW)) {
                    preparedStatement1.setString(1, role.getLogin());
                    preparedStatement1.setString(2, role.getPassword());
                    preparedStatement1.setString(3, role.getRole());
                    preparedStatement1.execute();
                    return true;
                } catch (SQLException e) {

                }
            }
            else throw new SQLException();

        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка добавления пользователя");

        }

        return true;

    }

    @Override
    public boolean delete(Role role) throws DAOException, SQLException {
/*
Я создаю пользователя для того что бы его потом удалить??
 */

        boolean res = true;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

            preparedStatement.setString(1, role.getLogin());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка удаления");
        }
        return res;

    }

    @Override
    public List getAll() throws DAOException, SQLException {


        List<Role> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {

                String log = res.getString("login");
                String passw = res.getString("password");
                String rol = res.getString("role");

                Role role = new Role(log, passw, rol);
                list.add(role);

            }


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка демонстрации всех авто");
        }

        return list;

    }
}
