package com.example.restcontrol.demo.repo;

import com.example.restcontrol.demo.model.ShapeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends JpaRepository<ShapeModel, Integer> {
}
