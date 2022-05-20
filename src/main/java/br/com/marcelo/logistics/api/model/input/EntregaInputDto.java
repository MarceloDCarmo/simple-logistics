package br.com.marcelo.logistics.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputDto {

	@Valid
	@NotNull
	private ClienteIdInputDto cliente;
	
	@Valid
	@NotNull
	private DestinatarioInputDto destinatario;
//	private Destinatario destinatario;  Também funciona, mas  não é boa prática. Caso haja uma futura alteração na classe de domínio, seria necessária a criação da classe DTO
	
	@NotNull
	private BigDecimal taxa;	
}
