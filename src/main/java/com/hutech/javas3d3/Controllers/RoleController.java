package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Role;
import com.hutech.javas3d3.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public String listRoles(Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "Role/getAll";
    }

    @GetMapping("/add")
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "Role/add";
    }

    @PostMapping("/add")
    public String addRole(Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "Role/add";
        }
        roleRepository.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoleForm(@PathVariable("id") String id, Model model) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        model.addAttribute("role", role);
        return "Role/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRole(@PathVariable("id") String id, Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "Role/edit";
        }
        roleRepository.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteRoleConfirmation(@PathVariable("id") String id, Model model) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        model.addAttribute("role", role);
        return "role-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") String id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        roleRepository.delete(role);
        return "redirect:/roles";
    }
}
