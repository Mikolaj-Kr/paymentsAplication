package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.service.AuthoritiesService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class UsersController {

    private final GetModelAndView getModelAndView;

    private final UserService userService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UsersController(GetModelAndView getModelAndView, UserService userService, AuthoritiesService authoritiesService) {
        this.getModelAndView = getModelAndView;
        this.userService = userService;
    }


    @RequestMapping("/pay-users")
    public ModelAndView getUsers(){
        Map<String, Object> params = getModelAndView.getModelAndViewParams("users");
        params.put("usersList", userService.findAllUsers());
        return new ModelAndView("main-site", params);
    }

    @GetMapping("/pay-users-delete-user")
    public ModelAndView getDeleteUserSecondStep(HttpServletRequest request){
        Map<String, Object> params = getModelAndView.getModelAndViewParams("deleteUser");
        params.put("userToDelete", userService.findUserByUsername(request.getParameter("username")));
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-user-delete-user")
    public ResponseEntity<String> postDeleteUserFirstStep(@RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        response.sendRedirect("/pay-users-delete-user?username=" + username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/pay-user-delete-user-confirm")
    public ResponseEntity<String> posDeleteUserConfirm(@RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        userService.deleteUser(username);
        logger.info("User " + username + "deleted");
        response.sendRedirect("/pay-users");
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

}
