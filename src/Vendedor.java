import java.util.ArrayList;

public class Vendedor extends Funcionario{

    private float taxaComissao;
    private ArrayList<Venda> vendas;

    public Vendedor(String nome, String cpf, float salarioBase,
                    Derpartamento derpartamento, float taxaComissao) {
        super(nome, cpf, salarioBase, derpartamento);
        this.taxaComissao = taxaComissao;
        vendas = new ArrayList<Venda>();
    }

    public void adicionarVendas(Venda v){
        vendas.add(v);
    }

    public float calcularComissao(){
        float total = 0;
        for (Venda v: vendas) {
            total += v.getValor()*taxaComissao;
        }
        return total;
    }

    public float calcularSalario(){
        return calcularComissao() + salarioBase;
    }

    @Override
    public String toString() {
        String r;
        r = super.toString()+"Taxa da Comissaao: "+taxaComissao+
                "\nAdicional de Comissao: "+
                String.format("%.2f",calcularComissao())+"\n";
        r = r.concat(String.format("Valor Final: %.2f",getValorFinal()));
        return r;
    }
}
