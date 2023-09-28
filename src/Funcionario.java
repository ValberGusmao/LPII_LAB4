import java.util.ArrayList;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected float salarioBase;
    protected Derpartamento derpartamento;
    protected ArrayList<Beneficio> beneficios;
    protected ArrayList<Desconto> descontos;
    public static ArrayList<Modificador> modificadores = new ArrayList<>();

    public Funcionario(String nome, String cpf, float salarioBase, Derpartamento derpartamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.derpartamento = derpartamento;
        this.beneficios = new ArrayList<>();
        this.descontos = new ArrayList<>();
        for (Modificador m: modificadores) {
            if (m.getClass() == Beneficio.class){
                beneficios.add((Beneficio) m);
            }
            else{
                descontos.add((Desconto) m);
            }
        }

    }
    public void adicionarBeneficios(Beneficio beneficio){
        this.beneficios.add(beneficio);
    }
    public void adicionarDescontos(Desconto desconto){
        this.descontos.add(desconto);
    }

    public float calcularSalario(){
        return salarioBase;
    }

    public float getValorFinal(){
        float total = 0;
        for (Beneficio b:beneficios) {
            total += b.getValor();
        }
        for (Desconto d: descontos){
            if(d.getValorNum() != 0){
                total -= d.getValorNum()*salarioBase;
            }
            if (d.getValorPerc() != 0){
                total -= d.getValorPerc()*salarioBase;
            }
        }
        total += calcularSalario();
        return total;
    }

    protected String beneficiosEDescontos(){
        String retorno = "";
        if (!beneficios.isEmpty()){
            retorno += "Benefiícios: \n";
        }
        for (Beneficio b:beneficios) {
            retorno = retorno.concat("\t"+b.getNome()+": "+b.getValor()+"\n");
        }

        if (!descontos.isEmpty()){
            retorno += "Descontos: \n";
        }
        for (Desconto d:descontos) {
            if (d.getValorNum() != 0){
                retorno = retorno.concat("\t"+d.getNome()+": "+d.getValorNum()+"\n");
            }
            else if (d.getValorPerc() != 0){
                retorno = retorno.concat("\t"+d.getNome()+": "+
                        String.format("%.2f",(d.getValorPerc()*salarioBase))+"\n");
            }
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "NOME: "+nome+"\nCPF: "+cpf +"\nDerpartamento: "+
                derpartamento.getNome()+"\nSalario Base: "+salarioBase+"\n"+
                beneficiosEDescontos();
    }
}
