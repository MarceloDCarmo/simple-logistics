package br.com.marcelo.logistics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelo.logistics.api.mappers.EntregaMapper;
import br.com.marcelo.logistics.api.model.EntregaDto;
import br.com.marcelo.logistics.api.model.input.EntregaInputDto;
import br.com.marcelo.logistics.domain.repository.EntregaRepository;
import br.com.marcelo.logistics.domain.service.FinalizacaoEntregaService;
import br.com.marcelo.logistics.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoService;
	private EntregaRepository entregaRepo;
	private EntregaMapper entregaMapper;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	
	@GetMapping
	public List<EntregaDto> listar() {
		return entregaMapper.toCollectionModel(entregaRepo.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
		return entregaRepo.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDto solicitar(@Valid @RequestBody EntregaInputDto entregaInputDto) {
		return entregaMapper.toModel(solicitacaoService.solicitar(entregaMapper.toEntity(entregaInputDto)));
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
};