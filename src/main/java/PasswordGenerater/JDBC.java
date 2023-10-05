package PasswordGenerater;

// Java Program Illustrating Utility class for Connecting
// and Querying the Database

import PasswordGenerater.UserDetails;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Annotation to provide logging feature
@Slf4j

// Class
public class JDBC {

    public int insert(UserDetails user)
    {
        DataSource dataSource = null;
        Connection connection = null;
        PreparedStatement prepStatement = null;

        int result = 0;
        try {

            // Get the configured datasourse
            dataSource = ConfigDataSource.source();
            // Attempt for connection to MySQL
            connection = dataSource.getConnection();
            prepStatement = connection.prepareStatement(
                    "insert into user (user,username,password) values (?,?,?)");
            prepStatement.setString(1, user.getUser());
            prepStatement.setString(2, user.getUserName());

            BCryptPasswordEncoder bCryptPasswordEncoder
                    = new BCryptPasswordEncoder(
                    10, new SecureRandom());
            String encodedPassword
                    = bCryptPasswordEncoder.encode(
                    user.getPassword());

            prepStatement.setString(3, encodedPassword);
            result = prepStatement.executeUpdate();
        }
        catch (SQLException e) {
            log.getName();
        }

        return result;
    }
}

