import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {

    private final String palavraSorteada;

    public BancoDePalavras() {
        Random random = new Random();
        List<String> bancoDePalavres = Arrays.asList("TAFAREL", "CAFU", "PELE", "ROMARIO", "DUNGA", "BEBETO");
        this.palavraSorteada = bancoDePalavres.get(random.nextInt(bancoDePalavres.size()));
    }

    public String getPalavraSorteada() {
       return this.palavraSorteada;
    }

}
