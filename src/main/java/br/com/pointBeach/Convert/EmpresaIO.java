package br.com.pointBeach.Convert;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.com.pointBeach.Entity.EmpresaEntity;
import br.com.pointBeach.Model.Input.EmpresaModelIn;

@Component("empresaIO")
public class EmpresaIO {
	
	private ModelMapper modelMapper;

	final Converter<EmpresaModelIn, EmpresaEntity> empresaConvert = new Converter<EmpresaModelIn, EmpresaEntity>() {

		@Override
		public EmpresaEntity convert(MappingContext<EmpresaModelIn, EmpresaEntity> context) {
			EmpresaModelIn empresaModelIn = context.getSource();
			// @formatter:off
			EmpresaEntity empresa = new EmpresaEntity();
			empresa.setNomeEmpresa(empresaModelIn.getNomeEmpresa());
			empresa.setCnpjEmpresa(empresaModelIn.getCnpjEmpresa());
			empresa.setIeEmpresa(empresaModelIn.getIeEmpresa());
			empresa.setFantasiaEmpresa(empresaModelIn.getFantasiaEmpresa());
			empresa.setCepEmpresa(empresaModelIn.getCepEmpresa());
			empresa.setCidadeEmpresa(empresaModelIn.getCidadeEmpresa());
			empresa.setEstadoEmpresa(empresaModelIn.getEstadoEmpresa());
			empresa.setBairroEmpresa(empresaModelIn.getBairroEmpresa());
			empresa.setEnderecoEmpresa(empresaModelIn.getEnderecoEmpresa());
			empresa.setNumeroEmpresa(empresaModelIn.getNumeroEmpresa());
			empresa.setComplementoEmpresa(empresaModelIn.getComplementoEmpresa());
			empresa.setRamoEmpresa(empresaModelIn.getRamoEmpresa());
			empresa.setResponsavelEmpresa(empresaModelIn.getResponsavelEmpresa());	
			// @formatter:on
			return empresa;
		}
	};
	public EmpresaIO() {
		modelMapper = new ModelMapper();
		modelMapper.addConverter(empresaConvert);
	}
	public EmpresaEntity mapTo(EmpresaModelIn empresaInput) {
		return this.modelMapper.map(empresaInput, EmpresaEntity.class);
	}
}

