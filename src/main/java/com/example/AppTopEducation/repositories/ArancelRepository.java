package com.example.AppTopEducation.repositories;

import com.example.AppTopEducation.entities.ArancelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArancelRepository extends JpaRepository<ArancelEntity, Long> {
}
