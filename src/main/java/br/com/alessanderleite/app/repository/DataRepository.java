package br.com.alessanderleite.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.app.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{

}
