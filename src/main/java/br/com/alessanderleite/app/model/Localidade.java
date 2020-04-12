package br.com.alessanderleite.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "LOCALIDADE")
public class Localidade {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	@SequenceGenerator(name = "ID_LOCALIDADE_SEQ", sequenceName = "LOCALIDADE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_LOCALIDADE_SEQ")
	private Integer id;
	
	private String status;

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "ID_DATA", referencedColumnName = "ID", nullable = false)})
	private Data data;
	
	@OneToMany(mappedBy = "localidade", fetch = FetchType.LAZY)
	private Set<Historico> historicos = new HashSet<>(0);
	
	public Localidade() {}

	public Localidade(Integer id, String status, Data data) {
		this.id = id;
		this.status = status;
		this.data = data;
	}

	public Localidade(Integer id, Data data) {
		this.id = id;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Set<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(Set<Historico> historicos) {
		this.historicos = historicos;
	}
	
	
	
}
