package br.com.marcelo.logistics.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.marcelo.logistics.api.model.EntregaDto;
import br.com.marcelo.logistics.api.model.input.EntregaInputDto;
import br.com.marcelo.logistics.domain.model.Entrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;
	
	public EntregaDto toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDto.class);
	}
	
	public List<EntregaDto> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInputDto entregaInputDto) {
		return modelMapper.map(entregaInputDto, Entrega.class);
	}
	
}
