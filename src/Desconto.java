public class Desconto extends Modificador {
    private float valorPerc;
    private float valorNum;
    public Desconto(String nome, float valorPerc, float valorNum) {
        this.nome = nome;
        this.valorPerc = valorPerc;
        this.valorNum = valorNum;
    }

    @Override
    public String toString() {
        String r = nome;
        if (valorPerc == 0){
            r += "\n\tvalorPercentual: "+valorPerc;
        } else if (valorNum == 0) {
            r += "\n\tvalorNumerico: "+valorNum;
        }
        return r;
    }

    public float getValorPerc() {
        return valorPerc;
    }

    public float getValorNum() {
        return valorNum;
    }
}
