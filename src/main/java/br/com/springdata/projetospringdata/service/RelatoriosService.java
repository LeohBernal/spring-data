package br.com.springdata.projetospringdata.service;

import br.com.springdata.projetospringdata.orm.Cargo;
import br.com.springdata.projetospringdata.orm.Funcionario;
import br.com.springdata.projetospringdata.repository.CargoRepository;
import br.com.springdata.projetospringdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionário nome");
            System.out.println("2 - Busca funcionráio por nome, salário e data de contratação");
            System.out.println("3 - Busca funcionário com data de contratação maior");

            int action = scanner.nextInt();

            System.out.println(action);

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacaoMaior(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
        system = true;
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.next();

        System.out.println("Qual data contratação deseja pesquisar: ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar: ");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacaoMaior(Scanner scanner) {
        System.out.println("Qual data contratação deseja pesquisar: ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);
    }
}
