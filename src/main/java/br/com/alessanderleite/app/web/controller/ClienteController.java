package br.com.alessanderleite.app.web.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.app.business.ClienteBO;
import br.com.alessanderleite.app.model.Cliente;
import br.com.alessanderleite.app.vo.RetornoVO;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteBO clienteBO;
	
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Cliente cliente) throws URISyntaxException {
		RetornoVO clienteSave = clienteBO.salvar(cliente);
		return ResponseEntity
				.created(new URI("localhorst:8080/clientes/"+clienteSave.getCliente().getId()))
				.body(clienteSave);
	}
	
	@PutMapping()
	public ResponseEntity<?> atualizar(@Valid @RequestBody RetornoVO cliente) {
		return ResponseEntity.ok().body(clienteBO.atualizar(cliente));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarClienteId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(clienteBO.buscarClienteId(id));
	}
	
	@GetMapping
	public ResponseEntity<?> listaClientes() {
		return ResponseEntity.ok().body(clienteBO.listaClientes());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		clienteBO.deletar(id);
		return ResponseEntity.ok().build();
	}
}
