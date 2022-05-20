package br.com.marcelo.logistics.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInputDto {

	@NotBlank
	private String descricao;
	
}
