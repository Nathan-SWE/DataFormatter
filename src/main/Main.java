package main;

import model.Funcionario;
import services.FuncionarioService;
import utils.LerDados;

import java.math.BigDecimal;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Funcionario> funcionarios = LerDados.carregarFuncionarios();
    FuncionarioService funcionarioService = new FuncionarioService();

    funcionarioService.removerFuncionario(funcionarios, "João");
    System.out.println("\n1 - Lista de todos funcionários:");
    funcionarioService.imprimirFuncionarios(funcionarios);

    funcionarioService.aumentarSalarios(funcionarios, new BigDecimal("1.10"));
    System.out.println("\n2 - Salários atualizados após aumento:");
    funcionarioService.imprimirFuncionarios(funcionarios);

    System.out.println("\n3 - Funcionários por função:");
    funcionarioService.imprimirFuncionariosPorFuncao(funcionarios);

    System.out.println("\n4 - Aniversariantes de Outubro e Dezembro:");
    funcionarioService.imprimirAniversariantes(funcionarios, 10, 12);

    System.out.println("\n5 - Funcionário mais velho:");
    funcionarioService.imprimirFuncionarioMaisVelho(funcionarios);

    System.out.println("\n6 - Funcionários em ordem alfabética:");
    funcionarioService.imprimirFuncionariosOrdenados(funcionarios);

    System.out.println("\n7 - Total dos salários:");
    funcionarioService.imprimirTotalSalarios(funcionarios);

    System.out.println("\n8 - Salário mínimo por funcionário:");
    funcionarioService.imprimirSalariosEmSalariosMinimos(funcionarios);
  }
}