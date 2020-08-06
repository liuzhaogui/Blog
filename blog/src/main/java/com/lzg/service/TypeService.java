package com.lzg.service;

import com.lzg.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: TypeService
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 8:44
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 08
 * @MINUTE: 44
 * @PROJECT_NAME: blog
 **/
public interface TypeService {

    /**
     * 新增
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 分类查询
     * @param id
     * @return
     */
    Type getType(Long id);

    Type getTypeByName(String name);

    /**
     * 查询
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);


    List<Type> listType();

    /**
     * 修改
     * @param id
     * @param type
     * @return
     */
    Type updateType(Long id,Type type);

    /**
     * 删除
     * @param id
     */
    void deleteType(Long id);


    List<Type> listTypeTop(Integer size);


}
