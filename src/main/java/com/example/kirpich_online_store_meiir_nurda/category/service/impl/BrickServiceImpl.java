package com.example.kirpich_online_store_meiir_nurda.category.service.impl;

import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import com.example.kirpich_online_store_meiir_nurda.brick.repository.BrickRepository;
import com.example.kirpich_online_store_meiir_nurda.brick.service.BricksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BrickServiceImpl implements BricksService {

    @Autowired
    BrickRepository bricksRepository;

    @Override
    public Brick createBrick(Brick brick) {
        return bricksRepository.save(brick);
    }

    @Override
    public void saveBrick(Brick brick) {
        bricksRepository.save(brick);
    }

    @Override
    public void deleteBrickById(Long id) {
        bricksRepository.deleteById(id);
    }

    @Override
    public Brick findBrickById(Long id) {
        return bricksRepository.findById(id).orElse(null);
    }

    @Override
    public double totalSum(HttpServletRequest req) {
        return 0;
    }
}
