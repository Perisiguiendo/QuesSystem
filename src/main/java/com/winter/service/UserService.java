package com.winter.service;

import com.winter.mapper.UserMapper;
import com.winter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public String login(User user){//TODO：登陆逻辑函数
        try {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            User userExistN = userMapper.findByName(user.getUsername());
            System.out.println("正常1");
            if (userExistN != null){
                String userExistP = userMapper.findPswByName(user.getUsername());
                if (userExistP.equals(user.getPassword())){
                    System.out.println("正常2");
                    return "app";
                }else {
                    return "index";
                }
            }else {
                System.out.println("错误3");
                return "index";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

