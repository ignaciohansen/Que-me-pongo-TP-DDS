import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRopaDistinta {
   private Prenda camisa;
   private Prenda zapatillas;

    @Before
    public void init(){
    camisa = new Prenda("Negro","Parte superior");
    zapatillas = new Prenda("Negro","Calzado");

    }

    @Test
    public void laCamisaEsDistintaAZapatilla(){

        Assert.assertTrue(camisa.sonDistintoTipo(zapatillas));

}
    @Test
    public void noSeAgregaColorSecundarioIgualQuePrimario(){
        camisa.setColorSecundario("Negro");
        Assert.assertNull(camisa.getColorSecundario());

    }
}



