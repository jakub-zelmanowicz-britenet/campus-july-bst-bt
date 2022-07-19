package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.User;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {

    private final DatabaseService databaseService;

    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<User> getUser(String username, String password) {
        User retrievedProduct = this.databaseService.performSQL(String.format("SELECT * FROM user WHERE username='%s' AND password='%s'", username, password), resultSet -> {
            try {
                if (resultSet.next()) {
                    User user = new User(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedProduct);
    }

}
