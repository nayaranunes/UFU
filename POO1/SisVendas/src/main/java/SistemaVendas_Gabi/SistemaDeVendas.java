package SistemaVendas_Gabi;

import java.text.DecimalFormat;
import java.util.*;

public class SistemaDeVendas {
    public static void main(String[] args) {

        Map<String, String> medidas = new HashMap<>();
        medidas.put("pc", "Peça");
        medidas.put("kg", "Kilo");
        medidas.put("mt", "Metro");
        medidas.put("un", "Unidade");

        Scanner ler = new Scanner(System.in);
        Scanner lerString = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();

        System.out.println("Quantidade de produtos para cadastrar: ");
        Integer cont = ler.nextInt();
        Integer i = 1;

        while(cont >= i) {
            System.out.println("\nCriando produto "+i);
            Produto produto = new Produto();
            System.out.println("Código: ");
            produto.setCodigo(ler.nextInt());
            System.out.println("Nome: ");
            produto.setNome(lerString.nextLine());
            System.out.println("Unidades disponíveis: pc, kg, mt, un");
            produto.setUnidade(lerString.nextLine());
            System.out.println("Preço: ");
            produto.setPreco(ler.nextDouble());
            produtos.add(produto);
            System.out.println(produto + " adicionado.\n");
            i++;
        }

        System.out.println("\nCriando nova venda");
        System.out.println("Numero:");
        Integer numero = ler.nextInt();
        System.out.println("Data:");
        String data = lerString.nextLine();
        System.out.println("Nome cliente:");
        String nomeCliente = lerString.nextLine();
        Venda venda = new Venda();
        venda.setNumero(numero);
        venda.setData(data);
        venda.setNomeCliente(nomeCliente);
        System.out.println(venda + " criada.\n");

        i = 1;
        for (Produto p : produtos) {
            System.out.println("(" + i + ") : " + p.getCodigo() + " - " + p.getNome() + "\n");
            i++;
        }

        System.out.println("Quantidade de produtos da venda:");

        cont = ler.nextInt();
        i = 1;

        ArrayList<Produto> produtosVenda = new ArrayList<>();
        ArrayList<ItemVenda> itens = new ArrayList<>();

        while (cont >= i) {

            System.out.println("Informe o numero do produto para adicionar:");
            int index = ler.nextInt()-1;
            Produto produtoIndex = produtos.get(index);
            produtosVenda.add(produtoIndex);
            System.out.println("Informe a quantidade do produto:");
            int qtd = ler.nextInt();
            itens.add(new ItemVenda(qtd, produtoIndex.getPreco(), produtoIndex));
            i++;
        }

        DecimalFormat df = new DecimalFormat("#,###.00");

        venda.setProdutos(produtosVenda);
        venda.setItens(itens);
        System.out.println("Produtos inseridos na venda:");
        venda.getProdutos().forEach(produto -> {
            int qtd = 0;
            for(ItemVenda itemVenda : venda.getItens()) {
                if (itemVenda.getProduto() == produto) {
                    qtd = itemVenda.getQuantidade();
                }
            }
            System.out.println(produto.getNome()+ " - "+qtd+ " "+ medidas.get(produto.getUnidade()) +
                    "(s) - R$ "+ df.format(produto.getPreco())+ " - R$ " + df.format(produto.getPreco()*qtd));

        });

        Double valorTotal = venda.calcularTotal();
        Double valorImposto = venda.calcularImpostos(valorTotal);
        Double valorVenda = valorTotal + valorImposto;
        System.out.println("\nTotal Produtos : R$ "+ df.format(valorTotal));
        System.out.println("Total Impostos : R$ "+ df.format(valorImposto));
        System.out.println("Total Venda : R$ "+ df.format(valorVenda));

    }
}
