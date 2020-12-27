package br.com.springdata.projetospringdata;

import br.com.springdata.projetospringdata.orm.Cargo;
import br.com.springdata.projetospringdata.repository.CargoRepository;
import br.com.springdata.projetospringdata.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoSpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;

	private Boolean system = true;

	public ProjetoSpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system) {
			System.out.println("Qual ação executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	}
}
