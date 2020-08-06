package com.lzg.service;

import com.lzg.NotFoundException;
import com.lzg.dao.TagRepository;
import com.lzg.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.service
 * @NAME: TagServiceImpl
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 13:59
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 13
 * @MINUTE: 59
 * @PROJECT_NAME: blog
 **/
@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = new PageRequest(0, size, sort);
        return tagRepository.findTop(pageable);
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAll(converToList(ids));
    }


    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findOne(id);
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }

    /**
     * 将字符串转换为数组
     * @param ids
     */
    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (int i = 0; i<idarray.length; i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.delete(id);
    }
}
