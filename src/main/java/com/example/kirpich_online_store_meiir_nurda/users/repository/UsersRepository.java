package com.example.kirpich_online_store_meiir_nurda.users.repository;

import com.example.kirpich_online_store_meiir_nurda.users.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

    @Query("SELECT m FROM Users m WHERE CONCAT(m.firstName, ' ', m.lastName, ' ', m.email) LIKE %?1%")
    Page<Users> findAllUsers(String keyword, Pageable pageable);
}
