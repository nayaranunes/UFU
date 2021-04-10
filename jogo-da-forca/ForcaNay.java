package tarefa;

import java.util.*;

/***
 * JOGO DA FORCA CRIADO POR NAYARA TEREZINHA NUNES
 * 10/04/2000 - UNIVERSIDADE FEDERAL DE UBERLANDIA
 */

public class ForcaNay {
    public static void main(String[] args) {

        Random random = new Random();

        List<String> bancoDePalavres = Arrays.asList("TAFAREL", "CAFU", "PELE", "ROMARIO", "DUNGA", "BEBETO");

        String palavra = bancoDePalavres.get(random.nextInt(bancoDePalavres.size()));

        List<String> letrasEnigma = new ArrayList<>(); // _ _ _ _ _
        List<String> letrasPalavra = Arrays.asList(palavra.split("")); // palavra em string[]
        List<String> letrasUtilizadas = new ArrayList<>(); // inicia vazia

        int tamanho = palavra.length();

        while(tamanho != 0){
            //preenchendo o enigma com o tamanho da palavra _ _ _ _ _
            letrasEnigma.add("_");
            tamanho--;
        }

        System.out.print("FORCA : ");
        letrasEnigma.forEach( letra -> System.out.print(letra + " "));

        //numero de tentativas eh o tamanho da palavra + 3 chances
        int tentativas = palavra.length() + 3;

        while (true) {
            if (!letrasEnigma.contains("_")) {
                System.out.println("VOCÊ GANHOU PARABÉNS!! A PALAVRA ERA " + palavra);
                break;
            }

            if (tentativas == 0) {
                System.out.println("SUAS CHANCES ACABARAM!! A PALAVRA ERA " + palavra);
                break;
            }

            System.out.print("\nVOCÊ TEM "+tentativas+" TENTATIVAS!!" + "\nTENTE ACERTAR UMA LETRA: ");

            String letra = leLetra(letrasUtilizadas);

            List<String> aux = new ArrayList<>(letrasPalavra);

            List<Integer> indexes = new ArrayList<>();

            while(true) {
                int index = aux.indexOf(letra);
                if (index == -1) {
                    break;
                }
                indexes.add(index);
                aux.set(index, "#");
            }

            if (palavra.contains(letra)) {
                indexes.forEach(in -> letrasEnigma.set(in, letra));
                System.out.println("LETRA " + letra + " FOI LIBERADA!!");
            } else {
                System.out.println("LETRA " + letra + "NÃO PERTENCE A PALAVRA! LETRAS UTILIZADAS: ");
                letrasUtilizadas.forEach( utilizada -> System.out.print(utilizada + " "));
            }
            letrasUtilizadas.add(letra);
            System.out.println("\nPALAVRA DA FORCA: ");
            letrasEnigma.forEach( l -> System.out.print(l + " "));

            tentativas--;
        }
    }

    private static String leLetra(List<String> letrasUtilizadas) {
        Scanner read = new Scanner(System.in);

        while(true) {

            char input = read.nextLine().charAt(0);
            String letra = String.valueOf(input).toUpperCase();

            if (!letrasUtilizadas.contains(letra)) {
                return letra;
            }
            System.out.println("LETRAS UTILIZADAS: ");
            letrasUtilizadas.forEach( u -> System.out.print(u + " "));
            System.out.println("\nLETRA "+letra+" JÁ UTILIZADA! DIGITE OUTRA: ");
        }
    }

}
