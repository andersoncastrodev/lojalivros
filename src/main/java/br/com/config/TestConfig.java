package br.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.service.DBService;

@Configuration
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	//Para Iniciar Metodos quando iniciar a base.
	@Bean
	public void instanciaBd() {
	   this.dbService.baseDados();	
	}
	
}
