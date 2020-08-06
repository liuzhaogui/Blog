package com.lzg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PACKAGE_NAME: com.lzg.web
 * @NAME: AboutShowController
 * @USER: 86185
 * @DATE: 2020/8/5
 * @TIME: 11:02
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 05
 * @DAY_NAME_SHORT: 周三
 * @DAY_NAME_FULL: 星期三
 * @HOUR: 11
 * @MINUTE: 02
 * @PROJECT_NAME: blog
 **/
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
