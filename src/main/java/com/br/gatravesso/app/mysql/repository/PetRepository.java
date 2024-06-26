package com.br.gatravesso.app.mysql.repository;

import com.br.gatravesso.app.mysql.entity.PetEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {

    Optional<PetEntity> findById(Long aLong);

    @Query(
            "Select p from PetEntity p " +
                    "where p.disponivelAdocao = 'S'")
    List<PetEntity> buscaTodosDisponiveis();
}
