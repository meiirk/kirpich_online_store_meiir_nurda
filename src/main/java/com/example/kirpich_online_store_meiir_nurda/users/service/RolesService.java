package com.example.kirpich_online_store_meiir_nurda.users.service;

import com.example.kirpich_online_store_meiir_nurda.users.models.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolesService {
    Roles findByRole(String role);
    List<Roles> getAllRoles();
}
