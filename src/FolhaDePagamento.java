import java.util.ArrayList;

public class FolhaDePagamento {
    private ArrayList<Funcionario> funcionarios;
    private float pagamentoMensal;

    public FolhaDePagamento() {
        this.funcionarios = new ArrayList<>();
    }

    public boolean adicionarFuncionario(Funcionario f){
        if (f != null){
            funcionarios.add(f);
            return true;
        }
        return false;
    }

    public boolean removerFuncionario(Funcionario f){
        if (f != null){
            funcionarios.remove(f);
            return true;
        }
        return false;
    }

    public float pagamentoMensal(){
        pagamentoMensal = 0;
        for (Funcionario f: funcionarios) {
            pagamentoMensal += f.getValorFinal();
            if (f.getClass() == Vendedor.class){
                ((Vendedor) f).contabilizarVendas();
            }
        }
        return pagamentoMensal;
    }

    public void exibirFuncionarios(){
        for (Funcionario f: funcionarios) {
            System.out.println(f+"\n");
        }
    }

    public float getPagamentoMensal() {
        return pagamentoMensal;
    }
}
