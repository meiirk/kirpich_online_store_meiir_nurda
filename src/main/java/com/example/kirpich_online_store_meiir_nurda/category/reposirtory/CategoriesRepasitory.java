package com.example.kirpich_online_store_meiir_nurda.category.reposirtory;

import com.example.kirpich_online_store_meiir_nurda.category.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoriesRepasitory extends JpaRepository<Category, Long> {
    @Query("SELECT p FROM Category p WHERE CONCAT(p.categoryName, p.id) LIKE %?1%")
    Page<Category> findAllCategory(String keyword, Pageable pageable);
}
