
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.CarEntity;

@Repository
public interface CarRepo extends JpaRepository<CarEntity, Integer> {
}
