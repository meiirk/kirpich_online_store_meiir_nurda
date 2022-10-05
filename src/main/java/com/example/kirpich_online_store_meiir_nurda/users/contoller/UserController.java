package com.example.kirpich_online_store_meiir_nurda.users.contoller;


import com.example.kirpich_online_store_meiir_nurda.users.models.Users;
import com.example.kirpich_online_store_meiir_nurda.users.repository.UsersRepository;
import com.example.kirpich_online_store_meiir_nurda.users.service.RolesService;
import com.example.kirpich_online_store_meiir_nurda.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;
    private final RolesService rolesService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String register() {
        System.out.println("--- Открыта страница регистрации ---");
        return "authorize/register";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("--- Открыта страница авторизации ---");
        return "authorize/login";
    }

    @PostMapping("/registration")
    public String toRegister(@RequestParam(name = "user_firstName") String firstName,
                             @RequestParam(name = "user_lastName") String lastName,
                             @RequestParam(name = "user_email") String email,
                             @RequestParam(name = "user_password") String password,
                             @RequestParam(name = "image") String image,
                             @RequestParam(name = "user_RePassword") String rePass) {
        Users newUser = null;
        if (password.equals(rePass)) {
            Users ckeckUser = usersService.getUsersByEmail(email);
            if (ckeckUser == null) {
                Users user = new Users();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPassword(password);
                user.setImage(image);
                newUser = usersService.createUser(user);
            }
            if (newUser != null) {
                return "redirect:/login";
            }
            return "redirect:/registration?emailIsAlreadyExists";
        }
        return "redirect:/registration?passwordDoNotMatch";
    }

    @GetMapping("/403")
    public String errorPage() {
        return "403";
    }
}
