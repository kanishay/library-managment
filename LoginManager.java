package manager;
import model.User;
import java.util.*;

public class LoginManager {
    public User login(String u,String p,ArrayList<User> users){
        for(User user: users){
            String tempUsername=user.getuserame();
            String tempPassword=user.getPassword();
            if(tempUsername.equals(u) && tempPassword.equals(p)){
                return user;
            }
        }
        return null;

    }
}
