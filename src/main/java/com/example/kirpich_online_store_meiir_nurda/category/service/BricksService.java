package com.example.kirpich_online_store_meiir_nurda.category.service;

import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface BricksService {

    void createBrick(Brick brick);

    void saveBrick(Brick brick);

    void deleteBrickById(Long id);

    List<Brick> getAllBricks();

    Page<Brick> listAllBricks(Integer pageable, String sortField, String sortDir, String keyword);

    Brick findBrickById(Long id);
}
