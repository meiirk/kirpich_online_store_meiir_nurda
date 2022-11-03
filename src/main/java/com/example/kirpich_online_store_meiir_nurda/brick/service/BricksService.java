package com.example.kirpich_online_store_meiir_nurda.brick.service;

import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface BricksService {

    Brick createBrick(Brick brick);

    void saveBrick(Brick brick);

    void deleteBrickById(Long id);

    Brick findBrickById(Long id);

    double totalSum(HttpServletRequest req);
}
