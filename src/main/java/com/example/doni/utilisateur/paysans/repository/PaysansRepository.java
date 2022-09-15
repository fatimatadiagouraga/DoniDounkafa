package com.example.doni.utilisateur.paysans.repository;

import com.example.doni.utilisateur.paysans.Paysans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaysansRepository extends JpaRepository<Paysans,Long> {
    Optional<Paysans> findApprenantByLoginAndPassword(String login, String Password);
    @Query(value = "SELECT ap FROM Paysans ap WHERE ap.login = :login")
    List<Paysans> findPaysansByLogin(@Param("login") String login);





    @Query(value = "SELECT tel FROM Paysans tel WHERE tel.telephone = :telephone")
    List<Paysans> findPaysansByTelephone(@Param("telephone") Long telephone);
}
