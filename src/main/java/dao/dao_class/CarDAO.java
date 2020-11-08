package dao.dao_class;

import bean.Car;
import dao.dao_exception.DAOException;
import dao.dao_interf.DAOInterf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAOInterf<Car> {
    private static final String URL = "jdbc:mysql://localhost:3306/" +
            "mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static final String INSERT_NEW = "INSERT INTO auto VALUES (?,?,?)";
    public static final String DELETE = "DELETE FROM auto  WHERE id=?";
    public static final String GET_ALL = "SELECT*FROM auto  ";
    public static final String CHANGE = "UPDATE auto SET model=?, type=? where id=?";



    @Override
    public Car search(int iD) throws  DAOException,SQLException {
        Car car = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String model = res.getString("model");
                String type = res.getString("type");
                if (iD == id) {

                    car = new Car(id, model, type);
                }

            }

        } catch (SQLException e) {
            throw new DAOException("Авто не найдено");
        }

        if (car == null) {
            throw new DAOException("Авто не найдено");
        } else return car;

    }

    @Override
    public Car search(String mod, String typ) throws DAOException,SQLException {
        Car car = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String model = res.getString("model");
                String type = res.getString("type");
                if (mod.equalsIgnoreCase(model) && typ.equalsIgnoreCase(type)) {
                    car = new Car(id, model, type);
                    break;
                }

            }



        } catch (SQLException e) {
            throw new DAOException("Авто не найдено");
        }


        return car;

    }

    @Override
    public boolean create(Car cars) throws DAOException,SQLException {


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW)) {

            preparedStatement.setInt(1, cars.getId());
            preparedStatement.setString(2, cars.getModel());
            preparedStatement.setString(3, cars.getType());
            preparedStatement.execute();



        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка добавления авто");
        }
        return true;
    }


    @Override
    public boolean delete(Car cars) throws DAOException,SQLException {
        boolean res = false;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

           preparedStatement.setInt(1, cars.getId());

            if(preparedStatement.executeUpdate()==1)
            res = true;
            else res=false;

        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка удаления");
        }
        return res;
    }

    @Override
    public List<Car> getAll() throws DAOException,SQLException {
        List<Car> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String model = res.getString("model");
                String type = res.getString("type");

                Car car = new Car(id, model, type);
                list.add(car);

                }
            if(list.size()<1) {
                throw new DAOException("Произошла ошибка демонстрации всех авто");
            }



        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка демонстрации всех авто");
        }


        return list;
    }

    @Override
    public boolean change(Car car) throws DAOException, SQLException {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE)) {


            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getType());
            preparedStatement.setInt(3, car.getId());

           if(preparedStatement.executeUpdate()!=1){
               throw new DAOException("Такого id не существует");
           }


        } catch (SQLException e) {
            throw new DAOException("Произошла ошибка изменения параметров");
        }
        return true;
    }


}
