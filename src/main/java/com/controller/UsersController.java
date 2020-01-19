package com.controller;

import com.domain.Users;
import com.github.pagehelper.PageInfo;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size, Model model) throws Exception {
        List<Users> usersList = usersService.findAll(page, size);
        //第二参数指定是连续显示的页数,可以不写
        PageInfo<Users> list = new PageInfo<Users>(usersList);
        model.addAttribute("UsersList", list);
        return "list_users";
    }
}
