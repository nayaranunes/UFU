import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Forca {

    private final List<String> letrasEnigma; // _ _ _ _ _
    private final List<String> letrasPalavra;
    private final List<String> letrasUtilizadas; // inicia vazia
    private int tentativas;
    public final String palavraSorteada;

    public Forca(String palavraSorteada) {
        this.palavraSorteada = palavraSorteada;
        //numero de tentativas eh o tamanho da palavra + 3 chances
        this.tentativas = this.palavraSorteada.length() + 3;
        // palavra em string[]
        this.letrasPalavra = Arrays.asList(this.palavraSorteada.split(""));
        this.letrasEnigma = new ArrayList<>();
        this.letrasUtilizadas = new ArrayList<>();
        setLetrasEnigmaInicio();
    }

    public List<String> getLetrasEnigma() {
        return letrasEnigma;
    }

    public void setLetrasEnigmaInicio() {
        int tamanho = this.palavraSorteada.length();

        while(tamanho != 0){
            //preenchendo o enigma com o tamanho da palavra _ _ _ _ _
            letrasEnigma.add("_");
            tamanho--;
        }
    }

    public void printLetrasEnigma() {
        letrasEnigma.forEach( letra -> System.out.print(letra + " "));
    }

    public int getTentativas() {
        return tentativas;
    }

    public boolean ganhou() {
        if (!getLetrasEnigma().contains("_")) {
            System.out.println("VOCÊ GANHOU PARABÉNS!! A PALAVRA ERA " + this.palavraSorteada);
            return true;
        }
        return false;
    }

    public boolean perdeu() {
        if (getTentativas() == 0) {
            System.out.println("SUAS CHANCES ACABARAM!! A PALAVRA ERA " + this.palavraSorteada);
            return true;
        }
        return false;
    }

    public void printTentativas() {
        System.out.print("\nVOCÊ TEM " + getTentativas() + " TENTATIVAS!!" + "\nTENTE ACERTAR UMA LETRA: ");
    }

    public String leLetra() {
        Scanner read = new Scanner(System.in);

        while(true) {

            char input = read.nextLine().charAt(0);
            String letra = String.valueOf(input).toUpperCase();

            if (!this.letrasUtilizadas.contains(letra)) {
                return letra;
            }
            System.out.println("LETRAS UTILIZADAS: ");
            this.letrasUtilizadas.forEach( u -> System.out.print(u + " "));
            System.out.println("\nLETRA "+letra+" JÁ UTILIZADA! DIGITE OUTRA: ");
        }
    }

    public List<Integer> getIndexes(String letra) {
        List<String> aux = new ArrayList<>(this.letrasPalavra);
        List<Integer> indexes = new ArrayList<>();

        while (true) {
            int index = aux.indexOf(letra);
            if (index == -1) {
                break;
            }
            indexes.add(index);
            aux.set(index, "#");
        }
        return indexes;
    }

    public void achaLetra(String letra) {
        List<Integer> indexes = getIndexes(letra);
        if (this.palavraSorteada.contains(letra)) {
            indexes.forEach(in -> this.letrasEnigma.set(in, letra));
            System.out.println("LETRA " + letra + " FOI LIBERADA!!");
        } else {
            System.out.println("LETRA " + letra + " NÃO PERTENCE A PALAVRA! LETRAS UTILIZADAS: ");
            this.letrasUtilizadas.forEach(utilizada -> System.out.print(utilizada + " "));
        }
    }

    public void addLetrasUtilizadas(String letra) {
        this.letrasUtilizadas.add(letra);
    }

    public void removeTentativas() {
        this.tentativas = tentativas--;
    }

    public void printEnigma() {
        System.out.println("\nPALAVRA DA FORCA: ");
        this.letrasEnigma.forEach(l -> System.out.print(l + " "));
    }
}
