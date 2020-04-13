package br.com.alessanderleite.app.integration;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alessanderleite.app.model.Localidade;

@FeignClient(name = "IpVigilanteClient", url = "https://ipvigilante.com/")
public interface IpVigilanteClient {

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	Localidade getLocalidade();
}
