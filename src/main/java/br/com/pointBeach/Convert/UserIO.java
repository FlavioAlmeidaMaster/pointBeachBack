package br.com.pointBeach.Convert;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.com.pointBeach.Entity.UsuarioEntity;
import br.com.pointBeach.Model.Input.UsuarioModelIn;

@Component("userIO")
public class UserIO {

	private ModelMapper modelMapper;

	final Converter<UsuarioModelIn, UsuarioEntity> userConverter = new Converter<UsuarioModelIn, UsuarioEntity>() {

		@Override
		public UsuarioEntity convert(MappingContext<UsuarioModelIn, UsuarioEntity> context) {
			UsuarioModelIn usuarioModelIn = context.getSource();
			// @formatter:off
			UsuarioEntity user = new UsuarioEntity();
			user.setLoginUser(usuarioModelIn.getLoginUser());
			user.setSenhaUser(usuarioModelIn.getSenhaUser());
			user.setNomeUser(usuarioModelIn.getNomeUser());
			user.setCpfUser(usuarioModelIn.getCpfUser());
			user.setRgUser(usuarioModelIn.getRgUser());
			user.setCltUser(usuarioModelIn.getCltUser());
			user.setCelularUser(usuarioModelIn.getCelularUser());
			user.setEmailUser(usuarioModelIn.getEmailUser());
			user.setObsUser(usuarioModelIn.getObsUser());

			// @formatter:on
			return user;
		}

	};

	public UserIO() {
		modelMapper = new ModelMapper();
		modelMapper.addConverter(userConverter);
	}

	public UsuarioEntity mapTo(UsuarioModelIn userInput) {
		return this.modelMapper.map(userInput, UsuarioEntity.class);
	}

}
