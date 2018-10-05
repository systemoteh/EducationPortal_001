package ru.systemoteh.educationportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome.xhtml";
    }

    @RequestMapping(value = "/user-detail", method = RequestMethod.GET)
    public String userDetail(Model model) {
        return "user-detail.xhtml";
    }

}
