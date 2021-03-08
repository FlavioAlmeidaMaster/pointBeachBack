package br.com.pointBeach.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pointBeach.Entity.UsuarioEntity;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, Long>{

}
