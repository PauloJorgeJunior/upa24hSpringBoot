package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.Municipio;


public interface MunicipiosRepository extends JpaRepository<Municipio, Long>{

	List<Municipio> findAllByOrderByNome();

}
