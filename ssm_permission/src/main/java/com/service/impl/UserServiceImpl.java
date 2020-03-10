package com.service.impl;

import com.dao.UserDao;
import com.domain.Role;
import com.domain.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.krb5.KrbCryptoException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @outhor li
 * @create 2020-03-06 16:01
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //用户权限创建方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try{
            userInfo = userDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        //将查询到的user对象封装为userDetails对象
        User user = new User(userInfo.getUsername(),  userInfo.getPassword(), userInfo.getStatus() == 0 ? false:true,true,true,true,getAuthority(userInfo.getRoles()) );
        return user;
    }

    //查询用户身份
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role :
                roles) {
            list.add(new SimpleGrantedAuthority(("ROLE_" + role.getRoleName())));
        }

        return list;
    }

    //查询用户
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfo = null;
        userInfo = userDao.findAll();
        return userInfo;
    }

    //保存用户
    @Override
    public void saveUser(UserInfo userInfo) {
        //对密码加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    //查询用户详情
    @Override
    public UserInfo findById(String userId) {
        return userDao.findUserById(userId);
    }

}
