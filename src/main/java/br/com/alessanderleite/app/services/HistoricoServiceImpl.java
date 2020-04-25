package br.com.alessanderleite.app.services;

import javax.cache.annotation.CacheRemoveAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alessanderleite.app.model.Historico;
import br.com.alessanderleite.app.repository.HistoricoRepository;

@Service
@CacheConfig(cacheNames = "historico")
public class HistoricoServiceImpl implements HistoricoService {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	@Override
	@CacheRemoveAll(afterInvocation = false)
	public Iterable<Historico> listAll() {
		return historicoRepository.findAll();
	}

	@Override
	@Cacheable(key = "#id", unless = "#result==null")
	@Transactional(readOnly = true)
	public Historico getById(Integer id) {
		return historicoRepository.findById(id).orElse(null);
	}

	@Override
	@CachePut(key = "#entity.id", unless = "#result==null")
	public Historico save(Historico entity) {
		if (entity.getId() == null) {
			return historicoRepository.save(entity);
		}
		return null;
	}

	@Override
	@CacheEvict(key = "#id")
	public void delete(Integer id) {
		historicoRepository.deleteById(id);
	}

	@Override
	@CachePut(key = "#entity.id", unless = "#result==null")
	public Historico update(Historico entity) {
		Historico historico = getById(entity.getId());
		if (historico != null) {
			return historicoRepository.save(entity);
		}
		return null;
	}

}
