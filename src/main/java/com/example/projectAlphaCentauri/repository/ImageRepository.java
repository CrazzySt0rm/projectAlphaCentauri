package com.example.projectAlphaCentauri.repository;

import com.example.projectAlphaCentauri.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findById(long id);
}
