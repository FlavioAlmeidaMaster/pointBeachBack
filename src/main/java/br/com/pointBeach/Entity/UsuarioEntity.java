package br.com.pointBeach.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Userpoint")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idEmpresa")
//	private List<EmpresaEntity> idEmpresa;

	@Column(name = "login_user")
	private String loginUser;
	@Column(name = "senha_user")
	private String senhaUser;
	@Column(name = "nome_user")
	private String nomeUser;
	@Column(name = "cpf_user")
	private String cpfUser;
	@Column(name = "email_user")
	private String emailUser;
	@Column(name = "rg_user")
	private String rgUser;
	@Column(name = "clt_user")
	private String cltUser;
	@Column(name = "celular_user")
	private String celularUser;
	@Column(name = "obs_user")
	private String obsUser;

}
