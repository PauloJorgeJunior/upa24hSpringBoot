package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.UF;


public interface UfsRepository extends JpaRepository<UF, Long>{

	List<UF> findAllByOrderByNome();

}
