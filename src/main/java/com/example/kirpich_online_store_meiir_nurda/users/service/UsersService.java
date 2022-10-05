package com.example.kirpich_online_store_meiir_nurda.users.service;

import com.example.kirpich_online_store_meiir_nurda.users.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService extends UserDetailsService {
    Users getUsersByEmail(String email);

    Users getUsersByID(long id);

    void saveUser(Users users);

    void deleteUserById(long id);

    Users createUser(Users users);

    List<Users> getAllUsers();


    Page<Users> listAllUsers(Integer pageable, String sortField, String sortDir, String keyword);

//    Users getCurrentlyLoggedInUser(Authentication authentication);
}
