package com.example.kirpich_online_store_meiir_nurda.brick.repository;

import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BrickRepository extends MongoRepository<Brick, Long> {
}
