package br.com.alessanderleite.app.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alessanderleite.app.model.Clima;
import br.com.alessanderleite.app.model.Geolocalizacao;

@FeignClient(name = "MetaweatherClient", url = "https://www.metaweather.com/api/location")
public interface MetaweatherClient {

	@GetMapping(path = "/search/")
	List<Geolocalizacao> obterLocalizacao(@RequestParam("lattlong") String latt);

	@GetMapping(path = "/{woeid}/{data}")
	List<Clima> obterClima(@PathVariable("woeid") String woeid, @PathVariable("data") String data);
}
