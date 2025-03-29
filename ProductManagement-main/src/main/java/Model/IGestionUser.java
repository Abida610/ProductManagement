package Model;

public interface IGestionUser {
    boolean authentifier(String username, String password);
    void inscrire(User user);
}
