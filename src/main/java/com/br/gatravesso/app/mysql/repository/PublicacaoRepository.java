package com.br.gatravesso.app.mysql.repository;

import com.br.gatravesso.app.mysql.entity.PublicacaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicacaoRepository  extends CrudRepository<PublicacaoEntity, Long> {

    Optional<PublicacaoEntity> findById(Long id);

    List<PublicacaoEntity> findAll();
}
