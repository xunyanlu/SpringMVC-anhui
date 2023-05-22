package cn.edu.guet.service;


import cn.edu.guet.bean.User;
import cn.edu.guet.common.ResponseData;

/**
 * @Author liwei
 * @Date 2023/5/16 20:20
 * @Version 1.0
 */
public interface UserService {

    ResponseData saveUser(User user);// 这是一个方法，报错的原因是：没有返回类型
}
