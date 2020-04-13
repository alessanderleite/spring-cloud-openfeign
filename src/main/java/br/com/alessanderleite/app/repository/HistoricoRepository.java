package br.com.alessanderleite.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.app.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer>{

}
