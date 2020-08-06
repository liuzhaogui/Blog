package com.lzg.service;

import com.lzg.po.User;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: UserService
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 9:25
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 09
 * @MINUTE: 25
 * @PROJECT_NAME: blog
 **/
public interface UserService {

    User checkUser(String username, String password);

}
