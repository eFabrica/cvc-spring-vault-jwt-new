package br.com.service.doit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import br.com.service.doit.component.SecretVaultCVC;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(SecretVaultCVC.class)
@ComponentScan(basePackages = { "br.com.service.doit" })
public class ServiceDoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDoitApplication.class, args);
	}

}
