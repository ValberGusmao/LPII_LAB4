public class Entregador extends Funcionario{
    private float periculosidade;

    public Entregador(String nome, String cpf, float salarioBase,
                      Derpartamento derpartamento, float periculosidade) {
        super(nome, cpf, salarioBase, derpartamento);
        this.periculosidade = periculosidade;
    }

    public float calcularSalario(){
        return salarioBase + periculosidade;
    }

    @Override
    public String toString() {
        String r;
        r = super.toString()+"Adicional de Periculosidade: "+periculosidade+"\n";
        r = r.concat(String.format("Valor Final: %.2f",getValorFinal()));
        return r;
    }
}
