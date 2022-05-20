package br.com.marcelo.logistics.api.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.marcelo.logistics.api.model.DestinatarioDto;
import br.com.marcelo.logistics.domain.model.Destinatario;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DestinatarioMapper {

	private ModelMapper mapper;
	
	public Destinatario toEntity(DestinatarioDto destinatarioDto) {
		return mapper.map(destinatarioDto, Destinatario.class);
	}
	
}
