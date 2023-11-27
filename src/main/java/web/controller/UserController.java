package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping(value = "/users/edit")
    public String editPage(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }
    @PostMapping(value = "/users/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/users";

    }

    //страница добавления Пользователя
    @GetMapping(value = "/users/add")
    public String addPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    //метод добавление Пользователя
    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";

    }
    @GetMapping(value = "/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }
}