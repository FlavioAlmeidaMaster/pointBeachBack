package br.com.pointBeach.Model.Output;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UsuarioModelOut {
	
	@ApiModelProperty(example = "1", required = true)
    @NotEmpty
	private String idUsuario;
	
	@ApiModelProperty(example = "login do usuario", required = true)
	@NotEmpty
	@Size(min = 8, max = 20, message = "Observação deve ter entre 5 e 250 caracteres")
	private String loginUser;

	@ApiModelProperty(example = "P@ssw0rd", required = true)
	@NotEmpty
	@Size(min = 8, max = 20, message = "Observação deve ter entre 5 e 250 caracteres")
	private String senhaUser;

	@NotNull
	@ApiModelProperty(example = "Usuario nome", required = true)
	@Size(min = 5, max = 70, message = "Observação deve ter entre 5 e 250 caracteres")
	private String nomeUser;

	@NotNull
	@ApiModelProperty(example = "CPF usuário", required = true)
	private String cpfUser;

	@ApiModelProperty(example = "E-Mail usuário", required = true)
	@Email(message = "E-mail deve ser válido")
	private String emailUser;

	@NotNull
	@ApiModelProperty(example = "R.G usuário", required = true)
	private String rgUser;

	@ApiModelProperty(example = "CLT do usuário", required = true)
	private String cltUser;

	@NotNull
	@ApiModelProperty(example = "(000)00000-0000", required = true)
	private String celularUser;

	@Size(max = 250, message = "Observação deve ter máximo 250 caracteres")
	@ApiModelProperty(example = "Obs: usuário", required = true)
	private String obsUser;
}
