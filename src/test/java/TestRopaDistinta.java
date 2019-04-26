import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
   // private Prenda camisa2;

    @Before
    public void init() throws Exception {

        camisa = new Prenda(Prenda.color.Negro, Prenda.color.Rojo, "Camisa", Prenda.categoriaPrenda.ParteSuperior);
        zapatillas = new Prenda(Prenda.color.Negro, Prenda.color.Rojo, "Zapatilla", Prenda.categoriaPrenda.Calzado);
     //   camisa2 = new Prenda(Prenda.color.Negro, Prenda.color.Negro, "Camisa", Prenda.categoriaPrenda.ParteSuperior);

    }
    @Test
    public void testDistintaCategoria(){
        Assert.assertNotEquals(camisa.getCategoria(),zapatillas.getCategoria());
    }
    /*
    @Test
    public void testMismoColor(){
        try{
            Assert.assertEquals(Prenda.color.Negro,camisa2.getColorSecundario());
        }
        catch(Exception exception){
            System.out.print(exception.getMessage());
        }
    }

     */
}







