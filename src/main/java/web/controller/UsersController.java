package web.controller;

import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImlp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("messages", userService.getList());
        model.addAttribute("user", new User());
        return  "index";
    }
    @PostMapping("/post")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect://";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect://";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam ("id_patch") int id) {
        userService.deleteById(id);
        return "redirect://";
    }

}
