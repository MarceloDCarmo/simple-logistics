package br.com.marcelo.logistics.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioDto {
	
	private String nome;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cep;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
}
