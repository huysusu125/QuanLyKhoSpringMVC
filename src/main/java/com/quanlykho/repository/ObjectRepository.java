package com.quanlykho.repository;

import com.quanlykho.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}
