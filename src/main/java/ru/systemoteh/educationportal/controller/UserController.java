package ru.systemoteh.educationportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.systemoteh.educationportal.bean.UserBean;
import ru.systemoteh.educationportal.model.User;
import ru.systemoteh.educationportal.service.security.SecurityService;
import ru.systemoteh.educationportal.service.security.UserSecurityService;
import ru.systemoteh.educationportal.validator.UserSecurityValidator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Controller for {@link User}'s pages.
 */

@Controller
public class UserController {

    @Autowired
    private UserSecurityService userSecurityService;  // Description in applicationContext-root.xml

    @Autowired
    private SecurityService securityService;  // Description in applicationContext-root.xml

    @Autowired
    private UserSecurityValidator userSecurityValidator;  // Description in applicationContext-root.xml

    @Autowired
    private UserBean userBean;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userSecurityValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration.jsp";
        }

        userSecurityService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
//            model.addAttribute("message", "Logged out successfully.");
            userBean.setCurrentUser(null);  // TODO Refactor -> Guest
            return "redirect:/index.xhtml";
        }
        return "login.jsp";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome.xhtml";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "../secure/admin.jsp";
    }

}
