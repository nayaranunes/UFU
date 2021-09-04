package SistemaVendas_Gabi;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Integer numero;  //não é possível salvar inteiros com zero à esquerda, como dado no exemplo
    private String data;
    private String nomeCliente;
    private ArrayList<Produto> produtos;
    private ArrayList<ItemVenda> itens;

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double calcularTotal() {
        Double total = 0.0;
        for (ItemVenda itemVenda : this.itens){
            total+= itemVenda.getPreco()*itemVenda.getQuantidade();
        }
        return total;
    }

    public Double calcularImpostos(Double valorVenda) {
        Double imposto = 0.0;
        if (valorVenda <= 400.00) {
            imposto = valorVenda * 0.05;
        } else {
            imposto += valorVenda * 0.10 + calcularImpostos(valorVenda/2);
        }
        return imposto;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "numero=" + numero +
                ", data='" + data + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}
