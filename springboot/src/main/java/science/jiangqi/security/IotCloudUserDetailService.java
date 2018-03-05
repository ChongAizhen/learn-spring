package science.jiangqi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import science.jiangqi.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Chong AiZhen on 18-2-3,下午7:03.
 */
public class IotCloudUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户 - 用户的角色、权限等信息
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            science.jiangqi.entity.User user = userService.findByName(username);
            Collection<GrantedAuthority> authList = getAuthorities(user.getAuthority());
            userDetails = new User(username, user.getPassWord(), true, true, true, true, authList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    private Collection<GrantedAuthority> getAuthorities(String auth) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(auth));
        return authList;
    }
}