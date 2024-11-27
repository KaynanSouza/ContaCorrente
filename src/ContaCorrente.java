import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ContaCorrente {
    private int numeroConta;
    private int numeroAgencia;
    private String nomeCliente;
    private Date dataNascimento;
    private float saldoConta;
    private List<Transacao> transacoes;

    public ContaCorrente(int numeroConta, int numeroAgencia, String nomeCliente, String dataNascimento) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = converterStringParaDate(dataNascimento);
        this.saldoConta = 0; // Saldo inicial
        this.transacoes = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }

    private Date converterStringParaDate(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void adicionarTransacao(String data, float valor, String descricao) {
        Date dataFormatada = converterStringParaDate(data);
        if (dataFormatada != null) {
            transacoes.add(new Transacao(dataFormatada, valor, descricao));
        }
    }

    public List<Transacao> consultarExtrato(String dataInicio, String dataFim) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date inicio = formato.parse(dataInicio);
            Date fim = formato.parse(dataFim);

            return transacoes.stream()
                    .filter(t -> t.getData().compareTo(inicio) >= 0 && t.getData().compareTo(fim) <= 0)
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void exibirExtrato(String dataInicio, String dataFim) {
        List<Transacao> extrato = consultarExtrato(dataInicio, dataFim);
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação encontrada no período informado.");
        } else {
            System.out.println("Extrato de " + dataInicio + " a " + dataFim + ":");
            extrato.forEach(System.out::println);
        }
    }

    public boolean sacarValor(String data, float valor, String descricao) {
        if (valor > saldoConta) {
            System.out.println("Saldo insuficiente!");
            return false;
        }

        saldoConta -= valor;
        // O menos antes do "valor" é para que o valor seja negativo
        adicionarTransacao(data, -valor, descricao);
        System.out.println("Saque feito com sucesso!");
        return true;
    }

    public void transferir(ContaCorrente destinatario, float valor, String data, String descricao) {
        if (sacarValor(data, valor, "Transferência para " + destinatario.getNomeCliente())) {
            destinatario.depositarValor(data, valor, "Transferência de " + nomeCliente);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência não realizada por saldo insuficiente.");
        }
    }

    public void depositarValor(String data, float valor, String descricao) {
        saldoConta += valor;
        adicionarTransacao(data, valor, descricao);
    }

    public float consultarSaldo() {
        return saldoConta;
    }
}
