package br.com.alessanderleite.app.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import br.com.alessanderleite.app.integration.IpVigilanteClient;
import br.com.alessanderleite.app.integration.MetaweatherClient;

@Configuration
@EnableFeignClients(clients = {IpVigilanteClient.class, MetaweatherClient.class})
public class FeignConfig {

}
