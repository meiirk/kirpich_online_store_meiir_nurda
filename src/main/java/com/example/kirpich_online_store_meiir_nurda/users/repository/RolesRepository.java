package com.example.kirpich_online_store_meiir_nurda.users.repository;

import com.example.kirpich_online_store_meiir_nurda.users.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}
