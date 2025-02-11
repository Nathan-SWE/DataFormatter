# DataFormatter

## Objetivo

Desenvolver um projeto com os seguintes requisitos:

1. Criar a classe `Pessoa` com os atributos:

   - `nome` (String)
   - `dataNascimento` (LocalDate)

2. Criar a classe `Funcionario`, que estende `Pessoa`, adicionando os atributos:

   - `salario` (BigDecimal)
   - `funcao` (String)

## Funcionalidades

- Inserir todos os funcionários na mesma ordem e com as mesmas informações da tabela.
- Remover o funcionário "João" da lista.
- Imprimir todos os funcionários com todas as informações, seguindo os formatos:
  - Datas no formato `dd/MM/yyyy`
  - Valores numéricos formatados com separador de milhar como ponto e decimal como vírgula. Exemplo: `1.452,45`
- Atualizar a lista de funcionários com um aumento de **10%** no salário.
- Agrupar os funcionários por função.
- Imprimir os funcionários que fazem aniversário nos meses **10** e **12**.
- Identificar e imprimir o funcionário com a maior idade, exibindo apenas `nome` e `idade`.
- Ordenar e imprimir a lista de funcionários em ordem alfabética.
- Calcular e imprimir o **total somado** dos salários de todos os funcionários.
- Calcular e imprimir quantos **salários mínimos** cada funcionário ganha, considerando o salário mínimo de **R\$ 1212,00**.

## Estrutura do Projeto

```bash
/data
  dados.csv
/src
  /main
    Main.java
  /model
    Pessoa.java
    Funcionario.java
  /services
    FuncionarioService.java
  /utils
    LerDados.java
.gitignore
```

## Como executar o projeto na sua máquina

### 📌 **Pré-requisitos**

- Ter o Java instalado (**JDK** de sua preferência)

### 🔹 **1️⃣ Compilar o código**

Abra o terminal na raiz do projeto e execute:

```bash
javac -d out -cp src src/main/Main.java
```

Isso criará uma pasta `out` com os arquivos `.class` compilados.

### 🔹 **2️⃣ Executar o programa**

Após compilar, rode o programa com:

```bash
java -cp out main.Main
```

Ou simplesmente execute o código pela sua IDE.
