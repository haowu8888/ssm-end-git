package com.controller;

import com.domain.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
        public String findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name="size",required = true,defaultValue = "5") int size, Model model) throws Exception{
        List<Account> AccountList = accountService.findAll(page,size);
        //第二参数指定是连续显示的页数,可以不写
        PageInfo<Account> list = new PageInfo<Account>(AccountList);
        model.addAttribute("AccountList",list);
       return "list_account";
        }
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println("表现层 保存账户信息");
        //调用service方法
         accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int accountId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Account account=accountService.findById(accountId);
        mv.addObject("account", account);
        mv.setViewName("edit_account");
        return mv;
    }
}
