import com.example.lotemax.MegaCena;

import junit.framework.TestCase;

import java.util.Arrays;

public class MegaCenaTest extends TestCase {

    MegaCena mega = new MegaCena();

    public void testGeradorDeNumeros(){
       System.out.println("Resultado: " + Arrays.toString(mega.gerarNumero()) );
    }
}