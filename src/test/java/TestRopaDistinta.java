import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
   // private Prenda camisa2;

    @Before
    public void init() throws Exception {

        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Camisa", Prenda.CategoriaPrenda.ParteSuperior);
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Zapatilla", Prenda.CategoriaPrenda.Calzado);
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







