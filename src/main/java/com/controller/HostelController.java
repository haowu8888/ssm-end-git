package com.controller;

import com.domain.Hostel;
import com.github.pagehelper.PageInfo;
import com.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客房web
 */
@Controller
@RequestMapping("/hostel")
public class HostelController {
    @Autowired
    private HostelService hostelService;
    @RequestMapping("/findAll")
        public String findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name="size",required = true,defaultValue = "5") int size, Model model) throws Exception{
        List<Hostel> hostelList = hostelService.findAll(page, size);
        //第二参数指定是连续显示的页数,可以不写
        PageInfo<Hostel> list = new PageInfo<Hostel>(hostelList);
        model.addAttribute("HostelList",list);
       return "list_hostel";
        }
    @RequestMapping("/save")
    public void save(Hostel hostel, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println("表现层 保存账户信息");
        //调用service方法
        hostelService.saveHostel(hostel);
        response.sendRedirect(request.getContextPath()+"/hostel/findAll");
        //return "redirect:findAll";
    }
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int hid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Hostel hostel=hostelService.findById(hid);
        mv.addObject("hostel", hostel);
        mv.setViewName("edit_hostel");
        return mv;
    }
}
