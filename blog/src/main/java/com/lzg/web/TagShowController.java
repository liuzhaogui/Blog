package com.lzg.web;

import com.lzg.po.Tag;
import com.lzg.service.BlogService;
import com.lzg.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @PACKAGE_NAME: com.lzg.web
 * @NAME: TagShowController
 * @USER: 86185
 * @DATE: 2020/8/5
 * @TIME: 11:07
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 05
 * @DAY_NAME_SHORT: 周三
 * @DAY_NAME_FULL: 星期三
 * @HOUR: 11
 * @MINUTE: 07
 * @PROJECT_NAME: blog
 **/
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model) {
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }

}
