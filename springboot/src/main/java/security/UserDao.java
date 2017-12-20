package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByName(String userName) {
        RowMapper<User> rw =  BeanPropertyRowMapper.newInstance(User.class);
        return jdbcTemplate.queryForObject("select * from user where userName='"+userName+"'", rw);
    }

    public User addUser(String userName, String passWord) {
        return null;
    }

    public boolean delUser(String userName) {
        return false;
    }
}
