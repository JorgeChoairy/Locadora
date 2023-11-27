package com.br.Locadora.authentication.repository;

import com.br.Locadora.authentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUserName(String userName);
}
