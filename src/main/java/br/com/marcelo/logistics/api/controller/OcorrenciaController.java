package br.com.marcelo.logistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelo.logistics.api.mappers.OcorrenicaMapper;
import br.com.marcelo.logistics.api.model.OcorrenciaDto;
import br.com.marcelo.logistics.api.model.input.OcorrenciaInputDto;
import br.com.marcelo.logistics.domain.model.Entrega;
import br.com.marcelo.logistics.domain.model.Ocorrencia;
import br.com.marcelo.logistics.domain.service.BuscaEntregaService;
import br.com.marcelo.logistics.domain.service.ResgistroOcorrenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private ResgistroOcorrenciaService regOcorrenciaService;
	private OcorrenicaMapper ocorrenciaMapper;
	private BuscaEntregaService buscarEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDto registrar (@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInputDto ocorrenciaInput) {
		
		Ocorrencia ocorrencia = regOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		return ocorrenciaMapper.toModel(ocorrencia);
	}
	
	@GetMapping
	public List<OcorrenciaDto> buscar (@PathVariable Long entregaId) {
		
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
	}

}
