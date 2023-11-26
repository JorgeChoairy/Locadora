package com.br.Locadora.authentication.repository;


import com.br.Locadora.authentication.model.RoleModel;
import com.br.Locadora.enuns.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface RoleModelRepository  extends JpaRepository<RoleModel, Long> {

    public List<RoleModel> findByRoleNameIn(List<RoleName> roles);

    public RoleModel findByRoleName(String nome);

}
