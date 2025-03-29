package Model;
import DAO.IGestionUserDAO;
import DAO.UserDAO;
public class GestionUser  implements IGestionUser{
    private IGestionUserDAO userDAO=new UserDAO();

    @Override
    public String toString() {
        return "GestionUser{" +
                "userDAO=" + userDAO +
                '}';
    }

    @Override
    public boolean authentifier(String username, String password) {
        if(username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username invalide");
        }
        User user = userDAO.getUserByUsername(username);
        return (user!=null && user.getPassword().equals(password));
    }
    @Override
    public void inscrire(User user) {
        if(user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Données utilisateur incomplètes");
        }


        if(userDAO.getUserByUsername(user.getUsername()) != null) {
            throw new IllegalStateException("Username déjà utilisé");
        }
        userDAO.addUser(user);
    }




}
