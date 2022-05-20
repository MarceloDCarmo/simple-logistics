package br.com.marcelo.logistics.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.marcelo.logistics.api.model.OcorrenciaDto;
import br.com.marcelo.logistics.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

	private ModelMapper mapper;
	
	public OcorrenciaDto toModel(Ocorrencia ocorrencia) {
		return mapper.map(ocorrencia, OcorrenciaDto.class);
	}

	public List<OcorrenciaDto> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());		
	}
}