package com.example.kirpich_online_store_meiir_nurda.brick.controller;

import com.example.kirpich_online_store_meiir_nurda.brick.mapper.BrickMapper;
import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import com.example.kirpich_online_store_meiir_nurda.brick.model.BrickDto;
import com.example.kirpich_online_store_meiir_nurda.brick.service.BricksService;
import com.example.kirpich_online_store_meiir_nurda.users.models.Roles;
import com.example.kirpich_online_store_meiir_nurda.users.models.Users;
import com.example.kirpich_online_store_meiir_nurda.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/brick")
@RequiredArgsConstructor
public class BrickController {

    private final UsersService usersService;

    private final BricksService bricksService;

    // СТРАНИЦА С КНОПКАМИ
    @GetMapping("/")
    public String brick() {
        return "admin/kirpich/adminKirpich";
    }


    @GetMapping("/add")
    public String addKirpich(Model model) {
        return "admin/kirpich/addKirpich";
    }

    //lab mongodb
    @PostMapping(value = "/addBrick")
    public ResponseEntity<?> kirpichAddAdmin(@RequestBody BrickDto brick) {
        bricksService.createBrick(BrickMapper.INSTANCE.toDtoEntity(brick));
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    private Users getUsersData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User secUser = (User) authentication.getPrincipal();
            return usersService.getUsersByEmail(secUser.getUsername());
        }
        return null;
    }

    @PostMapping("/{id}/delete")
    public String kirpichDelete(@PathVariable(value = "id") Long id) {
        bricksService.deleteBrickById(id);
        System.out.println("brick deleted!");
        return "redirect:/admin/kirpich/list";
    }


}
