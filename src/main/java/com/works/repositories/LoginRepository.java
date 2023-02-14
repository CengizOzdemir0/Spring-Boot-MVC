package com.works.repositories;

import com.works.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmailEqualsIgnoreCase(String email);

    // select * from login where email= ?
    //Optional<Login> findByEmailEquals(String email);
    // beklenen tek ise find instance çalıştırılır

}