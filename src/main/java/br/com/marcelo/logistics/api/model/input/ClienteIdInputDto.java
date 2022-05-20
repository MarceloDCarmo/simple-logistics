package br.com.marcelo.logistics.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdInputDto {

	@NotNull
	private Long id;
	
}
