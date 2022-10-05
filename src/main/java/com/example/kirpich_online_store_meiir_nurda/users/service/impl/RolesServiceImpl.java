package com.example.kirpich_online_store_meiir_nurda.users.service.impl;

import com.example.kirpich_online_store_meiir_nurda.users.models.Roles;
import com.example.kirpich_online_store_meiir_nurda.users.repository.RolesRepository;
import com.example.kirpich_online_store_meiir_nurda.users.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles findByRole(String role) {
        return rolesRepository.findByRole(role);
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

}
