package PasswordGenerater;

// Java Program Illustrating Configuration of
// DataSourceConfiguration of DataSource

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Annotation
@Configuration

// Class
public class ConfigDataSource {

    @Bean public static DataSource source()
    {

        DataSourceBuilder<?> dSB
                = DataSourceBuilder.create();
        dSB.driverClassName("com.mysql.cj.jdbc.Driver");

        // MySQL specific url with database name
        dSB.url("jdbc:mysql://localhost:3306/users");

        // MySQL username credential
        dSB.username("root");

        // MySQL password credential
        dSB.password("marcus0329");

        return dSB.build();
    }
}

