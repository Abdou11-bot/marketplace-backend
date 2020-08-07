package com.project.marketplace.repository;

import com.project.marketplace.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByEmailEqualsAndPasswordEquals(String Login,String Password);
    Medecin findByEmailEquals(String Login);
}
