package com.lzg.dao;

import com.lzg.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @PACKAGE_NAME: com.lzg.dao
 * @NAME: UserRepository
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 9:28
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 09
 * @MINUTE: 28
 * @PROJECT_NAME: blog
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
