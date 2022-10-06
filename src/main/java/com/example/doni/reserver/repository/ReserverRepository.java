package com.example.doni.reserver.repository;

import com.example.doni.reserver.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserverRepository extends JpaRepository<Reserver,Long> {
}
