package service;

import model.User;
import untils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService extends DbContext implements IUserService {

    private static final String SQL_FIND_USERNAME = "SELECT * FROM user WHERE name = ?";

    @Override
    public User findUserByUserName(String name){
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_USERNAME);
            ps.setString(1, name );
            System.out.println("findUserByUserName: " + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDB = rs.getInt("id");
                String usernameDB = rs.getString("name");
                String passwordDB = rs.getString("password");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                return new User(idDB, usernameDB, passwordDB, email, fullname, phone,address);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        try {
            Connection connection = getConnection();

            String strPass = PasswordUtils.hashPassword(user.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `user` (`name`, `password`) VALUES (?, ?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, strPass);

            System.out.println("createUser: " +  preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void updateUser(long id, User user) {

    }
}
