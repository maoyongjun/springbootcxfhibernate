package org.foxconn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.foxconn.dao.UserRepository;
import org.foxconn.entity.User;
import org.foxconn.exception.UsernameIsExitedException;
import org.foxconn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:myz
 * @version 1.0 创建时间：2018年5月13日 下午5:27:54
 */
@RestController
@RequestMapping("/users")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/userList")
    public Map<String, Object> userList(){
        List<User> users = userRepository.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        User bizUser = userRepository.findByUsername(user.getUsername());
        if(null != bizUser){
            throw new UsernameIsExitedException("用户已经存在");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(new String (encoder.encode(user.getPassword()).getBytes()));
        return userRepository.save(user);
    }

}
