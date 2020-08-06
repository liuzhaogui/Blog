package com.lzg.web.admin;

import com.lzg.po.Type;
import com.lzg.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @PACKAGE_NAME: com.lzg.web.admin
 * @NAME: TypeController
 * @USER: 86185
 * @DATE: 2020/8/3
 * @TIME: 8:59
 * @YEAR: 2020
 * @MONTH: 08
 * @MONTH_NAME_SHORT: 8月
 * @MONTH_NAME_FULL: 八月
 * @DAY: 03
 * @DAY_NAME_SHORT: 周一
 * @DAY_NAME_FULL: 星期一
 * @HOUR: 08
 * @MINUTE: 59
 * @PROJECT_NAME: blog
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     *  PageableDefault 分页
     *  size 一页显示多少行数据
     *  sort 传参
     *  direction 正序还是倒序
     * @param pageable
     * @return
     */
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable,
                                    Model model){
        model.addAttribute("page",typeService.listType(pageable));
        typeService.listType(pageable);
        return "admin/types";
    }

    /**
     * 新增跳转
     * @return
     */
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }


    /**
     * 修改
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }


    /**
     * @Valid 标识属性要进行校验
     * BindingResult 接收验证后的结果
     * @param type
     * @param attributes
     * @return
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null){
            result.rejectValue("name","nameError","该分类以存在，不能重复添加分类");
        }
        //非空验证，异常验证
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Type t = typeService.saveType(type);
       if (t == null){
            attributes.addFlashAttribute("message","新增失败");
       } else {
           attributes.addFlashAttribute("message","新增成功");
       }
       return "redirect:/admin/types";
    }

    /**
     * 更新
     * @param type
     * @param result
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    /**
     * 删除
     */
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}














