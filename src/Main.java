import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<ContaCorrente> contas = new ArrayList<>();

        int opcao, numeroDeConta = 1;

        do {
            System.out.println("""
                    +---------------------+
                    | Escolha uma opção:  |
                    | 1 - Criar conta     |
                    | 2 - Sacar valor     |
                    | 3 - Depositar valor |
                    | 4 - Transferir valor|
                    | 5 - Ver saldo       |
                    | 6 - Exibir extrato  |
                    | 7 - Exibir contas   |
                    | 8 - Sair            |
                    +---------------------+
                    """);

            opcao = scanner.nextByte();

            switch (opcao) {
                case 1:
                    {
                        int numeroAgentia = (int) (Math.random() * 100);

                        System.out.println("Digite o nome do cliente");
                        String mome = scanner.next();

                        System.out.println("Digite a data de nascimento do cliente");
                        String dataNascimento = scanner.next();

                        ContaCorrente conta = new ContaCorrente(numeroDeConta, numeroAgentia, mome, dataNascimento);
                        contas.add(conta);
                        numeroDeConta++;
                        System.out.println("Criar conta Com sucesso");
                    }
                    break;
                case 2:
                    {
                        System.out.println("Digite o número da conta");
                        int numeroContaSacar = scanner.nextInt();

                        System.out.println("Digite o valor a ser sacado");
                        float valorSacar = scanner.nextFloat();

                        System.out.println("Digite a data da transação");
                        String dataTransacao = scanner.next();

                        contas.get(numeroContaSacar - 1).sacarValor(dataTransacao, valorSacar, "Saque");

                        System.out.println("Saque feito com sucesso!");
                    }
                    break;
                case 3:
                    {
                        System.out.println("Digite o número da conta");
                        int numeroContaDepositar = scanner.nextInt();

                        System.out.println("Digite o valor a ser depositado");
                        float valorDepositar = scanner.nextFloat();

                        System.out.println("Digite a data da transação");
                        String dataTransacaoDepositar = scanner.next();

                        contas.get(numeroContaDepositar - 1).depositarValor(dataTransacaoDepositar, valorDepositar, "Deposito");

                        System.out.println("Deposito feito com sucesso!");
                    }
                    break;
                case 4:
                    {
                        System.out.println("Digite o número da conta");
                        int numeroContaTranferencia = scanner.nextInt();

                        System.out.println("Digite o número do destinatario");
                        int numeroContaDestinatario = scanner.nextInt();

                        System.out.println("Digite o valor a ser tranferido");
                        float valorTransferido = scanner.nextFloat();

                        System.out.println("Digite a data da transação");
                        String dataTransacao = scanner.next();

                        contas.get(numeroContaTranferencia - 1).transferir(contas.get(numeroContaDestinatario - 1), valorTransferido, dataTransacao, "Transação");

                        System.out.println("Transferir valor");
                    }
                    break;
                case 5:
                    {
                        System.out.println("Digite o numero da conta: ");
                        int numeroContaSaldo = scanner.nextInt();

                        System.out.println("Saldo: " + contas.get(numeroContaSaldo - 1).consultarSaldo());
                    }
                    break;
                case 6:
                    {
                        System.out.println("Digite o número da conta");
                        int numeroContaExtrato = scanner.nextInt();

                        System.out.println("Digite a data de inicio");
                        String dataInicio = scanner.next();

                        System.out.println("Digite a data de fim");
                        String dataFim = scanner.next();

                        contas.get(numeroContaExtrato - 1).exibirExtrato(dataInicio, dataFim);
                    }
                    System.out.println("Exibir extrato");
                    break;
                case 7:
                    {
                        for (ContaCorrente conta : contas) {
                            System.out.println("Número da conta: " + conta.getNumeroConta());
                            System.out.println("Nome do cliente: " + conta.getNomeCliente());
                        }
                    }
                    System.out.println("Exibir todas as contas");
                    break;
                case 8:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 8);


        // Criar uma conta
        // ContaCorrente conta = new ContaCorrente(1234, "Fulano", "01/01/2000");
        // contas.add(conta);


    }
}