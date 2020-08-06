package com.lzg.service;

import com.lzg.dao.UserRepository;
import com.lzg.po.User;
import com.lzg.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: UserServiceImpl
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 9:26
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 09
 * @MINUTE: 26
 * @PROJECT_NAME: blog
 **/
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * MD5 加密登陆密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
