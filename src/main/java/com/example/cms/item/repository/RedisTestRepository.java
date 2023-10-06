package com.example.cms.item.repository;

import com.example.cms.item.domain.ItemRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedisTestRepository extends CrudRepository<ItemRedis, Long> {

    List<ItemRedis> findAll();
}
