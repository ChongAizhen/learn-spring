package security;

/**
 * Created by chongaizhen on 2017/12/17.
 */
public interface UserService {

    User findByName(String userName);
    User addUser(String userName, String passWord);
    boolean delUser(String userName);
}
