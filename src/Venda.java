public class Venda {
    private String data;
    private float valor;
    private boolean foiContabilizada;

    public Venda(String data, float valor) {
        this.data = data;
        this.valor = valor;
        foiContabilizada = false;
    }

    public String getData() {
        return data;
    }

    public boolean isFoiContabilizada() {
        return foiContabilizada;
    }

    public float getValor() {
        return valor;
    }
    public void contabilizar(){
        foiContabilizada = true;
    }
}
