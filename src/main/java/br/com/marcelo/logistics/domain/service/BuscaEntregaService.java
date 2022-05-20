package br.com.marcelo.logistics.domain.service;

import org.springframework.stereotype.Service;

import br.com.marcelo.logistics.domain.exception.EntidadeNaoEncontradaException;
import br.com.marcelo.logistics.domain.model.Entrega;
import br.com.marcelo.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaEntregaService {

	private EntregaRepository entregaRepo;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepo.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("A entrega referenciada não existe"));
	}
}
