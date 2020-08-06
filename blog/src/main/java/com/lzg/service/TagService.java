package com.lzg.service;

import com.lzg.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: TagService
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 13:58
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 13
 * @MINUTE: 58
 * @PROJECT_NAME: blog
 **/
public interface TagService {

    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);

}
