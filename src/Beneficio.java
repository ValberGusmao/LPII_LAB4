public class Beneficio extends Modificador {
    private float valor;

    public Beneficio(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome+"\n\tvalor: "+valor;
    }


    public float getValor() {
        return valor;
    }
}
