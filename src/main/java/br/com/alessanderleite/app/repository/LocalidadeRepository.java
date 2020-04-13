package br.com.alessanderleite.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.app.model.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer>{

}
