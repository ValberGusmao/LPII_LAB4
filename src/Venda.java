public class Venda {
    private String data;
    private float valor;

    public Venda(String data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }
}
