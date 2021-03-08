package br.com.pointBeach.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pointBeach.Entity.EmpresaEntity;

@Repository
public interface EmpresaRepositorio extends JpaRepository<EmpresaEntity, Long>{

}
