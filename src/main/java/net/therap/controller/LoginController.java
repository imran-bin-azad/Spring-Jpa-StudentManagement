package net.therap.controller;

import net.therap.domain.Login;
import net.therap.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

/**
 * Created by imran.azad on 6/19/14.
 */
@Controller
@RequestMapping({"/", "/login"})
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@RequestParam(value = "username", required = true) String username,
                         @RequestParam(value = "password", required = true) String password,
                         ModelMap model) {
        Login loginCredential = new Login();
        loginCredential.setUsername(username);
        loginCredential.setPassword(password);

        Login verifiedLogin = loginService.verifyLoginAndGetDetails(loginCredential);

        logger.info("Given Login Credentials match : " + verifiedLogin);

        if (verifiedLogin == null) {
            model.addAttribute("message", "Invalid username, password combination");
            return "login";
        } else {
            logger.debug("redirecting to hello page");
            model.addAttribute("message", "Hello " + verifiedLogin.getUsername());
            return "hello";
        }
    }
}
