import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<ContaCorrente> contas = new ArrayList<>();
        int opcao, numeroDeConta = 1;

        do {
            // Exibição do menu com design aprimorado
            System.out.println("\n===============================");
            System.out.println("       MENU - Conta Corrente   ");
            System.out.println("===============================");
            System.out.println("1. Criar conta");
            System.out.println("2. Sacar valor");
            System.out.println("3. Depositar valor");
            System.out.println("4. Transferir valor");
            System.out.println("5. Ver saldo");
            System.out.println("6. Exibir extrato");
            System.out.println("7. Exibir todas as contas");
            System.out.println("8. Sair");
            System.out.println("===============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    int numeroAgencia = (int) (Math.random() * 100);
                    System.out.println("\n=== Criando nova conta ===");
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.next();

                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    String dataNascimento = scanner.next();

                    ContaCorrente conta = new ContaCorrente(numeroDeConta, numeroAgencia, nome, dataNascimento);
                    contas.add(conta);
                    numeroDeConta++;

                    System.out.println("\nConta criada com sucesso!");
                    System.out.println("Número da conta: " + conta.getNumeroConta());
                    System.out.println("Agência: " + conta.getNumeroAgencia());
                }
                case 2 -> {
                    System.out.println("\n=== Sacar valor ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaSacar = scanner.nextInt();

                    System.out.print("Digite o valor a ser sacado: R$ ");
                    float valorSacar = scanner.nextFloat();

                    System.out.print("Digite a data da transação (dd/MM/yyyy): ");
                    String dataTransacao = scanner.next();

                    if (contas.get(numeroContaSacar - 1).sacarValor(dataTransacao, valorSacar, "Saque")) {
                        System.out.println("Saque realizado com sucesso!");
                    }
                }
                case 3 -> {
                    System.out.println("\n=== Depositar valor ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaDepositar = scanner.nextInt();

                    System.out.print("Digite o valor a ser depositado: R$ ");
                    float valorDepositar = scanner.nextFloat();

                    System.out.print("Digite a data da transação (dd/MM/yyyy): ");
                    String dataTransacaoDepositar = scanner.next();

                    contas.get(numeroContaDepositar - 1).depositarValor(dataTransacaoDepositar, valorDepositar, "Depósito");
                }
                case 4 -> {
                    System.out.println("\n=== Transferir valor ===");
                    System.out.print("Digite o número da conta remetente: ");
                    int numeroContaRemetente = scanner.nextInt();

                    System.out.print("Digite o número da conta destinatária: ");
                    int numeroContaDestinatario = scanner.nextInt();

                    System.out.print("Digite o valor a ser transferido: R$ ");
                    float valorTransferido = scanner.nextFloat();

                    System.out.print("Digite a data da transação (dd/MM/yyyy): ");
                    String dataTransacao = scanner.next();

                    contas.get(numeroContaRemetente - 1).transferir(contas.get(numeroContaDestinatario - 1), valorTransferido, dataTransacao, "Transferência");
                }
                case 5 -> {
                    System.out.println("\n=== Consultar saldo ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaSaldo = scanner.nextInt();

                    System.out.println("Saldo disponível: R$ " + contas.get(numeroContaSaldo - 1).consultarSaldo());
                }
                case 6 -> {
                    System.out.println("\n=== Exibir extrato ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaExtrato = scanner.nextInt();

                    System.out.print("Digite a data de início (dd/MM/yyyy): ");
                    String dataInicio = scanner.next();

                    System.out.print("Digite a data de fim (dd/MM/yyyy): ");
                    String dataFim = scanner.next();

                    contas.get(numeroContaExtrato - 1).exibirExtrato(dataInicio, dataFim);
                }
                case 7 -> {
                    System.out.println("\n=== Exibir todas as contas ===");
                    for (ContaCorrente conta : contas) {
                        System.out.println("----------------------------");
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Nome do cliente: " + conta.getNomeCliente());
                        System.out.println("Agência: " + conta.getNumeroAgencia());
                        System.out.println("----------------------------");
                    }
                }
                case 8 -> System.out.println("\nSaindo do sistema... Até logo!");
                default -> System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}
