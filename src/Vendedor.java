import java.util.ArrayList;

public class Vendedor extends Funcionario{

    private float taxaComissao;
    private ArrayList<Venda> vendas;

    public Vendedor(String nome, String cpf, float salarioBase,
                    Derpartamento derpartamento, float taxaComissao) {
        super(nome, cpf, salarioBase, derpartamento);
        this.taxaComissao = taxaComissao;
        vendas = new ArrayList<>();
    }

    public void adicionarVendas(Venda v){
        vendas.add(v);
    }
    public void contabilizarVendas(){
        for (Venda v: vendas) {
            v.contabilizar();
        }
    }

    public float calcularComissao(){
        float total = 0;
        for (Venda v: vendas) {
            if (!v.isFoiContabilizada()){
                total += v.getValor()*taxaComissao;
            }
        }
        return total;
    }

    public float calcularSalario(){
        return calcularComissao() + salarioBase;
    }

    public float getTaxaComissao() {
        return taxaComissao;
    }
    public void setTaxaComissao(float taxaComissao) {
        if (taxaComissao > 0){
            this.taxaComissao = taxaComissao;
        }
    }

    @Override
    public String toString() {
        String r;
        r = super.toString()+"Taxa da Comissaao: "+taxaComissao*100+"%"+
                "\nAdicional de Comissao: "+
                String.format("%.2f",calcularComissao())+"\n";
        r = r.concat(String.format("Valor Final: %.2f",getValorFinal()));
        return r;
    }
}
