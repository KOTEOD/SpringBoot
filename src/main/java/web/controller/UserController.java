package web.controller;

import Hiber.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Dao.UserService;


@Controller
//@RequestMapping()//анатация которая создаёт прификс /My
public class UserController {

    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/")
    public String showUser(Model model) {
        model.addAttribute("listUser", UserService.getAllUser());
        return "show";
    }

    @GetMapping("/user")
    public String index(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", UserService.show(id));
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        UserService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model,@RequestParam("id") int id) {
        model.addAttribute("user", UserService.show(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "id") int id) {
        UserService.update(id, user);
        return "redirect:/";
    }
    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        UserService.delete(id);
        return "redirect:/";
    }
}
