package science.jiangqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import science.jiangqi.dao.UserMapper;
import science.jiangqi.entity.User;
import science.jiangqi.service.UserService;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String username) {
        return userMapper.selectByPrimaryKey(1);
    }

    public void testTask() {
        System.out.println("当前时间戳为："+System.currentTimeMillis());
    }
}
