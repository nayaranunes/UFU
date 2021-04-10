package tarefa;
/***
 * JOGO DA FORCA CRIADO POR NAYARA TEREZINHA NUNES
 * 19/03/2000 - UNIVERSIDADE FEDERAL DE UBERLANDIA
 */

public class Main {

    public static void main(String[] args) throws Exception {

        Ponto centro = new Ponto(0,0);
        Circulo circulo = new Circulo(3.0, centro);

        Double area = circulo.calculaArea();
        Double diametro = circulo.calculaDiametro();
        Double circunferencia = circulo.calculaCircunferencia();
        circulo.setNome("Circulo de Dominic");

        System.out.println("Area do " + circulo.nome + " eh: " + area);
        System.out.println("Circunferência do " + circulo.nome + " eh: " + circunferencia);
        System.out.println("Diâmetro do " + circulo.nome + " eh: " + diametro);

        circulo.setNome("");

    }
}


