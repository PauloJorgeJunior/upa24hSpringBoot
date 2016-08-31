package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.MotivoAtendimento;

public interface MotivosAtendimentoRepository extends JpaRepository<MotivoAtendimento, Long> {
    
    public List<MotivoAtendimento> findByDescricaoContainingOrderByDescricaoAsc(String descricao);

    public MotivoAtendimento findByDescricao(String descricao);

    public List<MotivoAtendimento> findAllByOrderByDescricao();
}
