package science.jiangqi.service;

import org.springframework.stereotype.Service;
import science.jiangqi.entity.User;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Service
public interface UserService {

    User findByUserName(String userName);
}
