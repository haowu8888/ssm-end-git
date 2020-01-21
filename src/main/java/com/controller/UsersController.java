package com.controller;

import com.domain.Hostel;
import com.domain.Users;
import com.github.pagehelper.PageInfo;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Users> usersList = usersService.findAll(page, size);
        //第二参数指定是连续显示的页数,可以不写
        PageInfo<Users> list = new PageInfo<Users>(usersList);
        mv.addObject("UsersList", list);
        mv.setViewName("list_users");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Users users) throws Exception {
        //调用service方法
        usersService.saveHostel(users);
       //response.sendRedirect(request.getContextPath() + "/users/findAll");
        return "redirect:findAll";
    }
}
