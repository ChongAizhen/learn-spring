package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String userName) {
        return userDao.findByName(userName);
    }

    public User addUser(String userName, String passWord) {
        return null;
    }

    public boolean delUser(String userName) {
        return false;
    }
}
