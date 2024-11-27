import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private Date data;
    private float valor;
    private String descricao;

    public Transacao(Date data, float valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Data: " + formato.format(data) + ", Valor: " + valor + ", Descrição: " + descricao;
    }
}
