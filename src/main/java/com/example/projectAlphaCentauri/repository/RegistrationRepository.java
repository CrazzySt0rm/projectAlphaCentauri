package com.example.projectAlphaCentauri.repository;

import com.example.projectAlphaCentauri.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findByEmail(String email);
}
