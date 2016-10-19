package br.com.portovelho.upa24h.repository.helper.salaAtendimento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.portovelho.upa24h.model.SalaAtendimento;
import br.com.portovelho.upa24h.repository.filter.SalaAtendimentoFiltro;

public class SalaAtendimentoRepositoryImpl implements SalaAtendimentoRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<SalaAtendimento> filtrar(SalaAtendimentoFiltro filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(SalaAtendimento.class);

		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getDescricao())) {
				criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(),MatchMode.ANYWHERE));
			}
		}
		return criteria.list();
	}
}
