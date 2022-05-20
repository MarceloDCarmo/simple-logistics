package br.com.marcelo.logistics.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcelo.logistics.domain.exception.NegocioException;
import br.com.marcelo.logistics.domain.model.Cliente;
import br.com.marcelo.logistics.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepo;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepo.findByEmail(cliente.getEmail())
				.stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Este email já está em uso");
		}
		
		return clienteRepo.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepo.deleteById(clienteId);
	}
	
	public Cliente buscar (Long id) {
		Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		return cliente;
	}
	
}
