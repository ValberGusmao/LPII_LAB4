import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FolhaDePagamento fp = new FolhaDePagamento();
        Derpartamento dpNorte = new Derpartamento("Norte");

        ArrayList<Beneficio> beneficios = new ArrayList<>();
        beneficios.add(new Beneficio("Vale Transporte", 300));
        beneficios.add(new Beneficio("Plano de Saúde", 700));

        ArrayList<Desconto> descontos = new ArrayList<>();
        descontos.add(new Desconto("INSS", 0.11f,0));
        descontos.add(new Desconto("Imposto de Renda", 0.15f,0));
        Funcionario.modificadores.addAll(beneficios);
        Funcionario.modificadores.addAll(descontos);

        Entregador entregador = new Entregador("Robson", "123.456.789-12",
                2200.79f, dpNorte, 500.50f);
        Administrador administrador = new Administrador("Jobson", "864.456.789-13",
                4200.99f, dpNorte, 2500);
        Vendedor vendedor = new Vendedor("Wanderley", "642.912.431-17",
                1320, dpNorte, 0.2f);

        Venda venda = new Venda("10-01-2023", 199.99f);
        vendedor.adicionarVendas(venda);
        venda = new Venda("15-04-2023", 49.75f);
        vendedor.adicionarVendas(venda);
        venda = new Venda("06-06-2023", 500.32f);
        vendedor.adicionarVendas(venda);

        fp.adicionarFuncionario(entregador);
        fp.adicionarFuncionario(administrador);
        fp.adicionarFuncionario(vendedor);
        fp.exibirFuncionarios();
        System.out.printf("Pagamento Mensal: %.2f%n",fp.pagamentoMensal());

        System.out.println("\n----------------------------------------------\n");

        fp.removerFuncionario(administrador);
        entregador.adicionarBeneficios(new Beneficio("Vale Alimentação", 400));
        vendedor.adicionarDescontos(new Desconto("Emprestimo",0,200));
        vendedor.adicionarVendas(new Venda("29-09-2023",760));
        vendedor.setTaxaComissao(0.4f);
        fp.exibirFuncionarios();
        System.out.printf("Pagamento do Mês Anterior: %.2f\n",fp.getPagamentoMensal());
        System.out.printf("Pagamento Mensal: %.2f%n",fp.pagamentoMensal());
    }
}
