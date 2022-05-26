package com.br.gatravesso.app.mysql.repository;

import com.br.gatravesso.app.mysql.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends CrudRepository<LoginEntity, Long> {

    LoginEntity findByUsuario(String usuario);

}
