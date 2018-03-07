package science.jiangqi.dao;

import org.apache.ibatis.annotations.Mapper;
import science.jiangqi.entity.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}