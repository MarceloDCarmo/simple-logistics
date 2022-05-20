package br.com.marcelo.logistics.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.marcelo.logistics.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDto {

	private Long id;
	private ClienteDto cliente;
	private DestinatarioDto destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
}
