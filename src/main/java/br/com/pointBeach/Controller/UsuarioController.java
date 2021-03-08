package br.com.pointBeach.Controller;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pointBeach.Config.AppControllerBase;
import br.com.pointBeach.Convert.UserIO;
import br.com.pointBeach.Entity.UsuarioEntity;
import br.com.pointBeach.Model.Input.UsuarioModelIn;
import br.com.pointBeach.Model.Output.UsuarioModelOut;
import br.com.pointBeach.Service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({ "/usuario" })
@Api(value = "Api Cadastro de Usuário", tags = { "CRUD_Usuarios" }, description = "CRUD de usuário no sistema")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	AppControllerBase appControllerBase;

	@Autowired
	UserIO userIO;

	@PostMapping({ "/", "" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna a lista de usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@ApiOperation(value = "Salvar usuário", notes = "Também retorna um link para recuperar o usuário salvo no cabeçalho do local")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UsuarioModelIn user) {
		UsuarioEntity userModel = userIO.mapTo(user);
		UsuarioEntity savedUser = userService.create(userModel);
		// @formatter:off
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getIdUsuario()).toUri();
		return ResponseEntity.created(location).build();
		// @formatter:on
	}

	@ApiOperation(value = "Listar todos usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping({ "/", "" })
	public ResponseEntity<?> indexUsers() {
		Type type = new TypeToken<List<UsuarioModelOut>>() {
		}.getType();

		List<UsuarioModelOut> result = appControllerBase.toList(userService.index(), type);
		return ResponseEntity.ok(result);

	}

	@ApiOperation(value = "Pegar Usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna usuário"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping({ "/{id}/", "/{id}" })
	public UsuarioModelOut showUser(@PathVariable("id") Long id) {
		return appControllerBase.mapTo(userService.show(id), UsuarioModelOut.class);
	}

	@PutMapping({ "/{id}/", "/{id}" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Atualiza usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@ApiOperation(value = "Atualizar usuário")
	public ResponseEntity<?> updateUser(
			// @formatter:off
			@Min(value = 1) @PathVariable("id") Long id, @RequestBody UsuarioModelIn user) throws Exception {
		UsuarioEntity user1 = userIO.mapTo(user);
		userService.update(id, user1);
		return ResponseEntity.noContent().build();
	}

	// @formatter:on
	@DeleteMapping({ "/{id}/", "/{id}" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleta usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@ApiOperation(value = "Deletar usuário")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}


}
