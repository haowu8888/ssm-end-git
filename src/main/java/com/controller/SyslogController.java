package com.controller;

import com.domain.Syslog;
import com.github.pagehelper.PageInfo;
import com.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SyslogController {
    @Autowired
    private SyslogService syslogService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Syslog> syslogList = syslogService.findAll(page, size);
        PageInfo<Syslog> pageInfo = new PageInfo<Syslog>(syslogList);
        mv.addObject("syslogList",pageInfo);
        mv.setViewName("list_syslog");
        return mv;
    }
}
