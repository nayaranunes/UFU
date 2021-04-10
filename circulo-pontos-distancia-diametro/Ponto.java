package tarefa;
/***
 * JOGO DA FORCA CRIADO POR NAYARA TEREZINHA NUNES
 * 19/03/2000 - UNIVERSIDADE FEDERAL DE UBERLANDIA
 */

/*
    Crie a classe Ponto que possui duas dimensões (int x, int y).
    Crie os métodos get e set.
    Faça o main para instanciar e testar a classe.
    Adicione o método distancia (int x, int y) que calcula a distância do ponto às coordenadas (x,y).
    Sobrecarregue o com o método distancia(Ponto p).
 */
public class Ponto {
    public Integer x;
    public Integer y;

    public Ponto(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double distancia(Ponto p) {
        Double px = Double.valueOf(p.getX());
        Double py = Double.valueOf(p.getY());
        Double x1 = Double.valueOf(this.x);
        Double y1 = Double.valueOf(this.y);
        return Math.sqrt(((px - x1)*(px - x1)) + ((py - y1) * (py - y1)));
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
