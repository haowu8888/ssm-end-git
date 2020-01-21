package com.controller;

import com.domain.Hostel;
import com.github.pagehelper.PageInfo;
import com.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * 客房web
 */
@Controller
@RequestMapping("/hostel")
public class HostelController {
    @Autowired
    private HostelService hostelService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Hostel> hostelList = hostelService.findAll(page, size);
        //第二参数指定是连续显示的页数,可以不写
        PageInfo<Hostel> list = new PageInfo<Hostel>(hostelList);
        mv.addObject("HostelList", list);
        mv.setViewName("list_hostel");
        return mv;
    }

    @RequestMapping("/save")
    public String save(@RequestParam CommonsMultipartFile upload, Hostel hostel) throws Exception {
        //使用fileupload组件上传文件
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String name = path + uuid + "_" + filename;
        //文件上传
        upload.transferTo(new File(name));

        //调用service方法
        hostel.setHostelImage(uuid + "_" + filename);
        hostelService.saveHostel(hostel);
        //response.sendRedirect(request.getContextPath() + "/hostel/findAll");
        return "redirect:findAll";
    }
    @RequestMapping("/edit")
    public String edit(@RequestParam CommonsMultipartFile upload, Hostel hostel) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        Hostel h = hostelService.findById(hostel.getId());
        String hostelImage =path+ h.getHostelImage();
        File f = new File(hostelImage);
        if (f.exists())
            f.delete();

        //使用fileupload组件上传文件

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String name = path + uuid + "_" + filename;
        //文件上传
        upload.transferTo(new File(name));

        //调用service方法
        hostel.setHostelImage(uuid + "_" + filename);
        hostelService.updateHostel(hostel);
        //response.sendRedirect(request.getContextPath() + "/hostel/findAll");
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Hostel hostel = hostelService.findById(id);
        hostel.setHostelImage(request.getContextPath()+"/upload/"+hostel.getHostelImage());
        mv.addObject("hostel", hostel);
        mv.setViewName("edit_hostel");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        Hostel hostel = hostelService.findById(id);
        String hostelImage =request.getSession().getServletContext().getRealPath("/upload/")+ hostel.getHostelImage();
        File file = new File(hostelImage);
        if (file.exists())
            file.delete();
        hostelService.deleteHostel(id);
        return "redirect:findAll";
    }
}