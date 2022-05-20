package br.com.marcelo.logistics.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcelo.logistics.domain.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
