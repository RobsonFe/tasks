package br.com.robson.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
		System.out.println("Acesse a API localmente em http://localhost:8080");
		System.out.println("Acesse a Documentação em http://localhost:8080/swagger-ui/index.html");
	}

}
