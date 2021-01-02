package br.com.springdata.projetospringdata;

import br.com.springdata.projetospringdata.orm.Cargo;
import br.com.springdata.projetospringdata.repository.CargoRepository;
import br.com.springdata.projetospringdata.service.CrudCargoService;
import br.com.springdata.projetospringdata.service.CrudFuncionarioService;
import br.com.springdata.projetospringdata.service.CrudUnidadeTrabalhoService;
import br.com.springdata.projetospringdata.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class ProjetoSpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
    private final RelatoriosService relatoriosService;

    public ProjetoSpringDataApplication(CrudCargoService cargoService,
                                        CrudFuncionarioService funcionarioService,
                                        CrudUnidadeTrabalhoService unidadeTrabalhoService,
                                        RelatoriosService relatoriosService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatoriosService = relatoriosService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system) {
            System.out.println("Qual função deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Funcionario");
            System.out.println("2 - Cargo");
            System.out.println("3 - Unidade");
            System.out.println("4 - Relatórios");

            Integer function = scanner.nextInt();

            switch (function) {
                case 1:
                    funcionarioService.inicial(scanner);
                    break;
                case 2:
                    cargoService.inicial(scanner);
                    break;
                case 3:
                    unidadeTrabalhoService.inicial(scanner);
                    break;
                case 4:
                    relatoriosService.inicial(scanner);
                    break;
                default:
                    System.out.println("Finalizando");
                    system = false;
                    break;
            }
        }
    }
}