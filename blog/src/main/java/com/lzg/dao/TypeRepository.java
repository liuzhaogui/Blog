package com.lzg.dao;

import com.lzg.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.dao
 * @NAME: TypeRepository
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 8:51
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 08
 * @MINUTE: 51
 * @PROJECT_NAME: blog
 **/
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
