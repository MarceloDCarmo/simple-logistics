package br.com.marcelo.logistics.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioInputDto {

	@NotBlank
	private String nome;
	
//	@NotBlank
//	private String logradouro;
	
	@NotBlank
	@Setter(AccessLevel.NONE)
	@Size(min = 8, max = 9)
	private String cep;
	
	@NotBlank
	private String numero;
	private String complemento;
	
//	@NotBlank
//	private String bairro;
	
	public void setCep(String cep) {
		if(cep.length() == 8) {
			this.cep = cep;
		} else {
			this.cep = cep.replace("-", "");
		}
	}
}
