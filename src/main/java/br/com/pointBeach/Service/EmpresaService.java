package br.com.pointBeach.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pointBeach.Entity.EmpresaEntity;
import br.com.pointBeach.Repository.EmpresaRepositorio;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepositorio empresaRepositorio;

	public List<EmpresaEntity> index() {
		return empresaRepositorio.findAll();

	}

	public EmpresaEntity show(Long id) {
		return empresaRepositorio.getOne(id);
	}

	public EmpresaEntity create(EmpresaEntity entity) {
		return empresaRepositorio.save(entity);

	}

	public EmpresaEntity update(Long idEmpresa, EmpresaEntity newEmpresa) throws Exception {
		EmpresaEntity empresa = empresaRepositorio.getOne(idEmpresa);
		if (empresa == null) {
			throw new Exception();
		}
		if (empresa.getIdEmpresa() != idEmpresa) {
			throw new Exception();
		}
		empresa.setIdEmpresa(idEmpresa);
		EmpresaEntity empresaNew = empresaRepositorio.save(newEmpresa);
		return empresaNew;

	}

	public void delete(Long idEmpresa) {
		empresaRepositorio.deleteById(idEmpresa);
	}
}
