package SistemaVendas_Gabi;

public class Produto {
    private Integer codigo; //não é possível salvar inteiros com zero à esquerda, como dado no exemplo
    private String nome;
    private String unidade;
    private Double preco;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", unidade='" + unidade + '\'' +
                ", preco=" + preco +
                '}';
    }
}
