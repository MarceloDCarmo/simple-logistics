package br.com.marcelo.logistics.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Embeddable
public class Destinatario {
	
	@NotBlank
	@Column(name = "destinatario_nome")
	private String nome;
	
	@NotBlank
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name = "destinatario_numero")
	private String numero;
	
	@Column(name = "destinatario_complemento")
	private String complemento;
	
	@NotBlank
	@Column(name = "destinatario_bairro")
	private String bairro;
	
	@NotBlank
	@Column(name = "destinatario_cep")
	private String cep;
	
	@NotBlank
	@Column(name = "destinatario_localidade")
	private String localidade;
	
	@NotBlank
	@Column(name = "destinatario_uf")
	private String uf;
	
	@NotBlank
	@Column(name = "destinatario_ibge")
	private String ibge;
	
	@NotBlank
	@Column(name = "destinatario_gia")
	private String gia;
	
	@NotBlank
	@Column(name = "destinatario_ddd")
	private String ddd;
	
	@NotBlank
	@Column(name = "destinatario_siafi")
	private String siafi;
}
