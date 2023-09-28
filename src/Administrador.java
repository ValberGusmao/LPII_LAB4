public class Administrador extends Funcionario {
    private float bonusChefia;

    public Administrador(String nome, String cpf, float salarioBase,
                         Derpartamento derpartamento, float bonusChefia) {
        super(nome, cpf, salarioBase, derpartamento);
        this.bonusChefia = bonusChefia;
    }

    public float calcularSalario(){
        return salarioBase + bonusChefia;
    }

    @Override
    public String toString() {
        String r;
        r = super.toString()+"Adicional de Chefia: "+bonusChefia+"\n";
        r = r.concat(String.format("Valor Final: %.2f",getValorFinal()));
        return r;
    }
}
