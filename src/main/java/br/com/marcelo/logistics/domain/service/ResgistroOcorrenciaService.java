package br.com.marcelo.logistics.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcelo.logistics.domain.model.Entrega;
import br.com.marcelo.logistics.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResgistroOcorrenciaService {

	private BuscaEntregaService buscaEntregaService;

	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);

	}
	
}
