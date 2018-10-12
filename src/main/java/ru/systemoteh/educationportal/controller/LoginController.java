package ru.systemoteh.educationportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for {@link login/registration}'s pages.
 */

@Controller
public class LoginController {

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
            userBean.setCurrentUser(null);
            return "redirect:/index.xhtml";
        }
        return "login.jsp";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index.xhtml";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "../secure/admin.jsp";
    }

}
