package br.com.pointBeach.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pointBeach.Entity.UsuarioEntity;
import br.com.pointBeach.Repository.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<UsuarioEntity> index() {
		return usuarioRepositorio.findAll();

	}

	public UsuarioEntity show(Long id) {
		return usuarioRepositorio.getOne(id);
	}

	public UsuarioEntity create(UsuarioEntity entity) {
		return usuarioRepositorio.save(entity);

	}

	public UsuarioEntity update(Long idUser, UsuarioEntity newUser) throws Exception {
		UsuarioEntity user = usuarioRepositorio.getOne(idUser);
		if (user == null) {
			throw new Exception();
		}
		if (user.getIdUsuario() != idUser) {
			throw new Exception();
		}
		user.setIdUsuario(idUser);
		UsuarioEntity usuario = usuarioRepositorio.save(newUser);
		return usuario;

	}

	public void delete(Long idUser) {
		usuarioRepositorio.deleteById(idUser);
	}

}
