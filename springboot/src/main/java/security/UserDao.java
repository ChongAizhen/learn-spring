package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByName(String userName) {
        return jdbcTemplate.queryForObject("select * from user where userName='"+userName+"'", User.class);
    }

    public User addUser(String userName, String passWord) {
        return null;
    }

    public boolean delUser(String userName) {
        return false;
    }
}
