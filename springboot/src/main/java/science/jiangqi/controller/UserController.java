package science.jiangqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import science.jiangqi.entity.User;
import science.jiangqi.service.UserService;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/user/{userName}", method = RequestMethod.GET)
    public User getByName(@PathVariable String userName){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object a1 = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        Object a2 = SecurityContextHolder.getContext().getAuthentication().getCredentials();
//        Object a3 = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Object a = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return userService.findByUserName(userName);
        User user = userService.findByUserName(userName);
        System.out.println(user.toString());
        return user;
    }

    /**
     * 获取当前登录的用户
     * @return
     */
    @RequestMapping(value = "/auth/user", method = RequestMethod.GET)
    public String getInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object a1 = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object a2 = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        Object a3 = SecurityContextHolder.getContext().getAuthentication().getDetails();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object a = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "";
    }

}
