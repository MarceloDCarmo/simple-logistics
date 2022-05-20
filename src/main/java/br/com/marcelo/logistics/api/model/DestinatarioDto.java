package br.com.marcelo.logistics.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioDto {

	private String nome;
	private String logradouto;
	private String numero;
	private String complemento;
	private String bairro;
	
}
