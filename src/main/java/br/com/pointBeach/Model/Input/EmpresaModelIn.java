package br.com.pointBeach.Model.Input;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EmpresaModel")
public class EmpresaModelIn {

	@ApiModelProperty(example = "Empresa do usuario ou fornecedor", required = true)
	@NotEmpty
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String nomeEmpresa;

	@ApiModelProperty(example = "CNPJ Empresa do empresa ou fornecedor", required = true)
	@NotEmpty
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String cnpjEmpresa;

	@ApiModelProperty(example = "I.E Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String ieEmpresa;

	@ApiModelProperty(example = "Nome Fantasia Empresa do usuario ou Fornecedor", required = true)
	@NotEmpty
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String fantasiaEmpresa;

	@ApiModelProperty(example = "CEP Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String cepEmpresa;

	@ApiModelProperty(example = "Bairro Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String bairroEmpresa;

	@ApiModelProperty(example = "Cidade Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String cidadeEmpresa;

	@ApiModelProperty(example = "Estado Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String estadoEmpresa;

	@ApiModelProperty(example = "Endereço Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String enderecoEmpresa;

	@ApiModelProperty(example = "Complemento Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String complementoEmpresa;

	@ApiModelProperty(example = "Numero Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String numeroEmpresa;

	@ApiModelProperty(example = "Responsável Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String responsavelEmpresa;

	@ApiModelProperty(example = "Ramo Empresa do usuario ou Fornecedor", required = false)
	@Size(min = 8, max = 20, message = "Observação deve ter entre 3 e 250 caracteres")
	private String ramoEmpresa;

}
