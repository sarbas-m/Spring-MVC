
package com.faith.demo.controller;

import com.faith.demo.entity.Role;
import com.faith.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListRoleController {

    private final IRoleService roleService;

    @Autowired
    public ListRoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role/list")
    public String listRoles(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "listrole";
    }
}