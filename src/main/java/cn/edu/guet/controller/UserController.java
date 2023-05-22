package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.UserService;
import cn.edu.guet.service.impl.UserServiceImpl;

/**
 * @Author liwei
 * @Date 2023/5/18 20:52
 * @Version 1.0
 */
@Controller
public class UserController {

    private UserService userService;

    /**
     * 曾经new的方式，耦合度太强（一个变化会影响另一个也跟着变了）
     * 依赖的方式发生了《反转：曾经自己new，现在别人送货上门》，这种现象在官方Spring框架中叫做：IoC（Inverse of Control），也叫DI（依赖注入）
     *
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/saveUser")
    public ResponseData saveUser(User user) {
        return userService.saveUser(user);
    }
}
