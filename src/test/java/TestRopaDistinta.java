import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda reloj;
    private Guardarropa guardarropaPruebaJuan;
    private Usuario juan;
    private Set<Prenda> prendas;
    private Set<Guardarropa> guardarropasDeJuan;
    // private Prenda camisa2;

    @Before
    public void init() throws Exception {
        pantalon = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, "Pantalon", Prenda.CategoriaPrenda.ParteInferior);
        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Camisa", Prenda.CategoriaPrenda.ParteSuperior);
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Zapatilla", Prenda.CategoriaPrenda.Calzado);
        reloj = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, "Reloj", Prenda.CategoriaPrenda.Accesorio);

         /*
        // Ver como crear un set
        prendas.add(pantalon);
        prendas.add(camisa);
        prendas.add(zapatillas);
        prendas.add(reloj);
        guardarropasDeJuan.add(guardarropaPruebaJuan);
        guardarropaPruebaJuan = new Guardarropa(prendas);
        juan = new Usuario(guardarropasDeJuan);
        camisa2 = new Prenda(Prenda.color.Negro, Prenda.color.Negro, "Camisa", Prenda.categoriaPrenda.ParteSuperior);
        */
    }
    @Test
    public void testDistintaCategoria(){
        Assert.assertNotEquals(camisa.getCategoria(),zapatillas.getCategoria());
    }

     /*
    @Test
    public void cantidadPrendasEnGuardarropaDeJuan(){
        Assert.assertEquals(4,guardarropaPruebaJuan.getPrendas().size());
    }


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







