package com.qa.flower.repos;

import com.qa.flower.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepo extends JpaRepository<Flower, Integer> {
}
