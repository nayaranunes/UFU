package tarefa;
/***
 * JOGO DA FORCA CRIADO POR NAYARA TEREZINHA NUNES
 * 19/03/2000 - UNIVERSIDADE FEDERAL DE UBERLANDIA
 */

/*
Crie a classe Circulo.
        Crie um construtor para inicializar a instância que recebe como parâmetros o raio e o valor do centro, que é um ponto em duas dimensões. Utilize a classe Ponto.
        Adicione como atributos, também, um nome.
        Adicione como métodos:
        Calcular diâmetro
        Calcular área
        Calcular circunferência
        Acessar e modificar nome (não pode ser vazio)
        Exibir os dados em um método.
*/
public class Circulo {

    public Double raio;
    public Ponto centro;
    public String nome;

    public Circulo(Double raio, Ponto centro) {
        this.raio = raio;
        this.centro = centro;
    }

    public Double calculaDiametro(){
        return 2 * this.raio;
    }

    public Double calculaArea(){
        return 3.14 * (this.raio * this.raio);
    }

    public Double calculaCircunferencia(){
        return 2 * 3.14 * this.raio;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String novo) throws Exception {
        if (novo.isEmpty()) {
            throw new Exception("Nome não pode ser vazio");
        }
        this.nome = novo;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                ", centro=" + centro +
                ", nome='" + nome + '\'' +
                '}';
    }
}
