package services;

import model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
  private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
    funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
  }

  public void imprimirFuncionarios(List<Funcionario> funcionarios) {
    funcionarios.forEach(this::imprimirFuncionario);
  }

  public void aumentarSalarios(List<Funcionario> funcionarios, BigDecimal fator) {
    funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(fator)));
  }

  public void imprimirFuncionariosPorFuncao(List<Funcionario> funcionarios) {
    Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios
        .stream()
        .collect(Collectors.groupingBy(Funcionario::getFuncao));

    funcionariosPorFuncao.forEach((funcao, lista) -> {
      System.out.println("\nFunção: " + funcao);
      lista.forEach(this::imprimirFuncionario);
    });
  }

  public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
    funcionarios.stream()
        .filter(f -> Arrays.stream(meses).anyMatch(m -> f.getDataNascimento().getMonthValue() == m))
        .forEach(this::imprimirFuncionario);
  }

  public void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
    Funcionario maisVelho = Collections.max(funcionarios,
        Comparator.comparing(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()));
    System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", Idade: "
        + Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears());
  }

  public void imprimirFuncionariosOrdenados(List<Funcionario> funcionarios) {
    funcionarios.stream()
        .sorted(Comparator.comparing(Funcionario::getNome))
        .forEach(this::imprimirFuncionario);
  }

  public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
    BigDecimal totalSalarios = funcionarios.stream()
        .map(Funcionario::getSalario)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("Total dos salários: " + formatarValor(totalSalarios));
  }

  public void imprimirSalariosEmSalariosMinimos(List<Funcionario> funcionarios) {
    funcionarios.forEach(f -> {
      BigDecimal qtdSalariosMinimos = f.getSalario().divide(SALARIO_MINIMO, 2, BigDecimal.ROUND_HALF_UP);
      System.out.println(f.getNome() + " ganha " + qtdSalariosMinimos + " salários mínimos");
    });
  }

  private void imprimirFuncionario(Funcionario f) {
    System.out.println(f.getNome() + ", " + f.getDataNascimento().format(FORMATTER) + ", "
        + formatarValor(f.getSalario()) + ", " + f.getFuncao());
  }

  private String formatarValor(BigDecimal valor) {
    return String.format("%,.2f", valor).replace(",", "_").replace(".", ",").replace("_", ".");
  }
}