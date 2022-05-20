package br.com.marcelo.logistics.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.marcelo.logistics.api.mappers.DestinatarioMapper;
import br.com.marcelo.logistics.api.model.DestinatarioDto;
import br.com.marcelo.logistics.domain.model.Cliente;
import br.com.marcelo.logistics.domain.model.Destinatario;
import br.com.marcelo.logistics.domain.model.Entrega;
import br.com.marcelo.logistics.domain.model.StatusEntrega;
import br.com.marcelo.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private RestTemplate restTemplate;
	private DestinatarioMapper destinatarioMapper;
	private EntregaRepository entrgeRepo;
	private CatalogoClienteService clienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		DestinatarioDto destinatarioDto = 
				restTemplate.getForObject(String.format("https://viacep.com.br/ws/%s/json/", entrega.getDestinatario().getCep()), DestinatarioDto.class);
		Destinatario destinatario = destinatarioMapper.toEntity(destinatarioDto);
		destinatario.setNome(entrega.getDestinatario().getNome());
		destinatario.setNumero(entrega.getDestinatario().getNumero());
		
		entrega.setDestinatario(destinatario);
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entrgeRepo.save(entrega);
	}
}
