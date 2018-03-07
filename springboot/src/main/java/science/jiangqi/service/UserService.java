package science.jiangqi.service;

import science.jiangqi.entity.User;

/**
 * Created by chongaizhen on 2017/12/17.
 */
public interface UserService {

    User findByUserName(String userName);
}
