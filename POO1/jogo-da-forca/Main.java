
/***
 * JOGO DA FORCA CRIADO POR NAYARA TEREZINHA NUNES
 * 10/04/2000 - UNIVERSIDADE FEDERAL DE UBERLANDIA
 */

public class Main {
    public static void main(String[] args) {

        BancoDePalavras bancoDePalavras = new BancoDePalavras();
        Forca forca = new Forca(bancoDePalavras.getPalavraSorteada());

        System.out.print("FORCA : ");
        forca.printLetrasEnigma();

        while (!forca.ganhou() && !forca.perdeu()) {
            forca.printTentativas();
            String letra = forca.leLetra();
            forca.achaLetra(letra);
            forca.addLetrasUtilizadas(letra);
            forca.printEnigma();
            forca.removeTentativas();
        }
    }
}
