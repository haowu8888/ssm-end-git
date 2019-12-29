package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findUser(Model model) throws Exception{
        List<User> users = userService.findUser();
        model.addAttribute("UserList",users);
        return  "list_user";
    }
}
