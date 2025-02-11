package utils;

import model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LerDados {
  private static final String PLANILHA_DADOS = "data/dados.csv";
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static List<Funcionario> carregarFuncionarios() {
    List<Funcionario> funcionarios = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(PLANILHA_DADOS))) {
      String linha;
      boolean primeiraLinha = true; // Para ignorar o cabeçalho

      while ((linha = br.readLine()) != null) {
        linha = linha.trim();
        if (linha.isEmpty()) continue;

        // Ignorar cabeçalho
        if (primeiraLinha) {
          primeiraLinha = false;
          continue;
        }

        String[] dados = linha.split(",");

        if (dados.length < 4) {
          System.out.println("⚠️ Linha inválida ignorada: " + linha);
          continue;
        }

        try {
          String nome = dados[0];
          LocalDate dataNascimento = LocalDate.parse(dados[1], FORMATTER);
          BigDecimal salario = new BigDecimal(dados[2]);
          String funcao = dados[3];

          funcionarios.add(new Funcionario(nome, dataNascimento, salario, funcao));

        } catch (Exception e) {
          System.out.println("⚠️ Erro ao processar linha: " + linha + " - " + e.getMessage());
        }
      }

    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

    return funcionarios;
  }
}
