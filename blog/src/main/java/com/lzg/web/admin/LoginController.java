package com.lzg.web.admin;

import com.lzg.po.User;
import com.lzg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @PACKAGE_NAME: com.lzg.web.admin
 * @NAME: LonginController
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 9:34
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 09
 * @MINUTE: 34
 * @PROJECT_NAME: blog
 **/

/**
 * @Controller 控制层
 * @RequestMapping("/admin") 跳转路径 默认全局
 */
@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private UserService userService;

    /**
     * 跳转到登陆页面
     * @GetMapping Get方式提交 括号内不写则默认使用 @RequestMapping("/admin") 括号里的路径
     *  跳转到登陆
     * @return
     */
    @GetMapping
    public String loginPage(){

        return "admin/login";
    }

    /**
     * 登陆
     * 页面提交方法
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes
                        ){
            User user =userService.checkUser(username,password);
            // if 判断是否有数据 有数据则将 密码设为null 再将数据添加到 HttpSession
            if (user != null){
                user.setPassword(null);
                session.setAttribute("user",user);
                return "admin/index";
            /**
             * 失败则给出提示并重定向到登陆页面
             * redirect 重定向
            */
            } else {
                attributes.addFlashAttribute("message","用户名密码错误");
                return "redirect:/admin";
            }
    }

    /**
     * 登出  注销
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session,RedirectAttributes attributes){
    session.removeAttribute("user");
    attributes.addFlashAttribute("message","登出成功");
    return "redirect:/admin";
    }
}
