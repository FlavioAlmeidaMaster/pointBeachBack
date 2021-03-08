package br.com.pointBeach.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Work")
public class EmpresaEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_empresa")
	private Long idEmpresa;
	@Column(name = "nome_empresa")
	private String nomeEmpresa;
	@Column(name = "cnpj_empresa")
	private String cnpjEmpresa;
	@Column(name = "ie_empresa")
	private String ieEmpresa;
	@Column(name = "fantasia_empresa")
	private String fantasiaEmpresa;
	@Column(name = "cep_empresa")
	private String cepEmpresa;
	@Column(name = "bairro_empresa")
	private String bairroEmpresa;
	@Column(name = "cidade_empresa")
	private String cidadeEmpresa;
	@Column(name = "estado_empresa")
	private String estadoEmpresa;
	@Column(name = "endereco_empresa")
	private String enderecoEmpresa;
	@Column(name = "complemento_empresa")
	private String complementoEmpresa;
	@Column(name = "numero_empresa")
	private String numeroEmpresa;
	@Column(name = "responsavel_empresa")
	private String responsavelEmpresa;
	@Column(name = "ramo_empresa")
	private String ramoEmpresa;
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_usuario")
//	private UsuarioEntity idUsuario;
	
	
}
