package com.wany.springsecurity01.controller;

import com.wany.springsecurity01.bean.Msg;
import com.wany.springsecurity01.bean.SysRole;
import com.wany.springsecurity01.bean.SysUser;
import com.wany.springsecurity01.dao.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping("test")
    public void test() {
        System.out.println("test is running");
        List<SysRole> list = new ArrayList<SysRole>();
        SysRole sysRole = new SysRole();
        sysRole.setName("ADMIN");
        list.add(sysRole);
        SysUser sysUser = new SysUser();
        sysUser.setUsername("wan");
        sysUser.setPassword("6666");
        sysUser.setRoles(list);
        sysUserRepository.save(sysUser);
    }
}
