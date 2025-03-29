package DAO;
import Model.User;

public interface IGestionUserDAO
{
    User getUserById(int id);
    User getUserByUsername(String username);
    void addUser(User user);
    boolean validateUser(String username, String password);
}
