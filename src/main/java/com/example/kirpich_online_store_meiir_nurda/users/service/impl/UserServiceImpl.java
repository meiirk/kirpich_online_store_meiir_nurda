package com.example.kirpich_online_store_meiir_nurda.users.service.impl;

import com.example.kirpich_online_store_meiir_nurda.users.models.Roles;
import com.example.kirpich_online_store_meiir_nurda.users.models.Users;
import com.example.kirpich_online_store_meiir_nurda.users.repository.UsersRepository;
import com.example.kirpich_online_store_meiir_nurda.users.service.RolesService;
import com.example.kirpich_online_store_meiir_nurda.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users myUser = usersRepository.findByEmail(email);
        if (myUser != null){
            return new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public Users getUsersByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users getUsersByID(long id) {
        return usersRepository.getById(id);
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUserById(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users createUser(Users user) {
        Users checkUser = usersRepository.findByEmail(user.getEmail());
        if (checkUser==null){
            Roles role = rolesService.findByRole("ROLE_USER");
            if (role!=null){
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return usersRepository.save(user);
            }
        }
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Page<Users> listAllUsers(Integer pageNo, String sortField, String sortDir, String keyword) {
        Pageable pageable = PageRequest.of(pageNo - 1, 6,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        if (keyword!=null){
            return usersRepository.findAllUsers(keyword, pageable);
        }
        return usersRepository.findAll(pageable);
    }
}
