package com.example.projectAlphaCentauri.repository;

import com.example.projectAlphaCentauri.models.AlphaCentauri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlphaCentauriRepository extends JpaRepository<AlphaCentauri, Long> {

    List<AlphaCentauri> findByUsername(String username);
}
