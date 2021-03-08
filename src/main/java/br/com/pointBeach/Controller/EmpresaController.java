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
import br.com.pointBeach.Convert.EmpresaIO;
import br.com.pointBeach.Entity.EmpresaEntity;
import br.com.pointBeach.Model.Input.EmpresaModelIn;
import br.com.pointBeach.Model.Output.EmpresaModelOut;
import br.com.pointBeach.Model.Output.UsuarioModelOut;
import br.com.pointBeach.Service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({ "/empresa" })
@Api(value = "Api Cadastro de Empresa", tags = { "CRUD_Empresa" }, description = "CRUD de empresa no sistema")
@CrossOrigin
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	AppControllerBase appControllerBase;

	@Autowired
	EmpresaIO empresaIO;

	@ApiOperation(value = "Retorna uma lista de Empresa")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna a lista de Empresas"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping({ "/", "" })
	public ResponseEntity<?> indexEmpresa() {
		Type type = new TypeToken<List<EmpresaModelOut>>() {
		}.getType();
		List<UsuarioModelOut> result = appControllerBase.toList(empresaService.index(), type);
		return ResponseEntity.ok(result);
	}

	@ApiOperation(value = "Retorna Empresa por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna Empresa pelo ID"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping({ "/{id}/", "/{id}" })
	public EmpresaModelOut showEmpresa(@PathVariable("id") Long id) {
		return appControllerBase.mapTo(empresaService.show(id), EmpresaModelOut.class);
	}

	@ApiOperation(value = "Cadastra Empresa")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastra Empresa"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PostMapping({ "/", "" })
	public ResponseEntity<Object> createEmpresa(@Valid @RequestBody EmpresaModelIn empresa) {
		EmpresaEntity empresaModel = empresaIO.mapTo(empresa);
		EmpresaEntity savedEmpresa = empresaService.create(empresaModel);
		// @formatter:off
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmpresa.getIdEmpresa()).toUri();
		return ResponseEntity.created(location).build();
		// @formatter:on
	}

	@ApiOperation(value = "Altera cadastro de empresa")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ALtera cadastro da Empresa pelo ID"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PutMapping({ "/{id}/", "/{id}" })
	public ResponseEntity<?> updateEmpresa(
			// @formatter:off
			@Min(value = 1) @PathVariable("id") Long id, @RequestBody EmpresaModelIn empresa) throws Exception {
		EmpresaEntity user1 = empresaIO.mapTo(empresa);
		empresaService.update(id, user1);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deleta cadastro de Empresa")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleta Empresa pelo ID"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Api não encontrada favor verificar"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@DeleteMapping({ "/{id}/", "/{id}" })
	public ResponseEntity<?> deleteEmpresa(@PathVariable("id") Long id) {
		empresaService.delete(id);
		return ResponseEntity.ok().build();
	}

}
