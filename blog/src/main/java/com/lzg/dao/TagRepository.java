package com.lzg.dao;

import com.lzg.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.dao
 * @NAME: TagRepository
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 13:57
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 13
 * @MINUTE: 57
 * @PROJECT_NAME: blog
 **/
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
