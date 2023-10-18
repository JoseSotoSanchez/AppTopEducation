package com.example.AppTopEducation.repositories;

import com.example.AppTopEducation.entities.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long> {
}