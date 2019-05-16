import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda reloj;
    private Prenda campera;
    private Guardarropa guardarropaPruebaJuan;
    private Usuario juan;
    //private Set<Guardarropa> guardarropasDeJuan;
    // private Prenda camisa2;

    @Before
    public void init() throws Exception {
        pantalon = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, "Pantalon", Prenda.CategoriaPrenda.ParteInferior);
        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Camisa", Prenda.CategoriaPrenda.ParteSuperior);
        campera = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, "Campera", Prenda.CategoriaPrenda.ParteSuperior);
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Zapatilla", Prenda.CategoriaPrenda.Calzado);
        reloj = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, "Reloj", Prenda.CategoriaPrenda.Accesorio);


        guardarropaPruebaJuan = new Guardarropa();
        juan = new Usuario();
        juan.agregarUnGuardarropas(guardarropaPruebaJuan);

        //camisa2 = new Prenda(Prenda.color.Negro, Prenda.color.Negro, "Camisa", Prenda.categoriaPrenda.ParteSuperior);ç
        //guardarropasDeJuan.add(guardarropaPruebaJuan);

    }
    @Test
    public void testDistintaCategoria(){
        Assert.assertNotEquals(camisa.getCategoria(),zapatillas.getCategoria());
    }

// Tests para verificar funcionamiento de Set y cantidades

    @Test
    public void cantidadDePrendasEnGuardarropaDeJuan(){
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);
        Assert.assertEquals(4,guardarropaPruebaJuan.cantidadDePrendas());
    }

    @Test
    public void cantidadDeGuardarropasDeJuan(){
        juan.agregarUnGuardarropas(guardarropaPruebaJuan);
        Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

    @Test
    public void cantidadDePrendasDeAtuendo(){
        // Cargo el guardarropa
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(campera);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);

        //Armo el atuendo
        Atuendo atuendoCreado = juan.generarAtuendo(guardarropaPruebaJuan);

        // Test funciona, tengo 5 prendas y retorna 4, el filtrado anda bien
        Assert.assertEquals(4,atuendoCreado.cantidadDePrendas());

    }


    // Test que da mal, solo para pruebas
    @Test
    public void PrendasDistintasDeAtuendo(){
        // Cargo el guardarropa
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(campera);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);

        //Armo el atuendo
        Atuendo atuendoCreado = juan.generarAtuendo(guardarropaPruebaJuan);

        // Verifico con el hash, si da distinto significa que la parte superior va variando, hay 2 opciones
        Assert.assertEquals(4,atuendoCreado.getPrendas());

        /*
        Resultados de ejecucion:

        1º [Prenda@9e89d68, Prenda@77556fd, Prenda@3b192d32, Prenda@16f65612]
        2º [Prenda@368239c8, Prenda@77556fd, Prenda@3b192d32, Prenda@16f65612]  Cambio el primero, random funcionando
        3º [Prenda@9e89d68, Prenda@77556fd, Prenda@3b192d32, Prenda@16f65612]
        4º [Prenda@9e89d68, Prenda@77556fd, Prenda@3b192d32, Prenda@16f65612]
                                                    Funciona
        */
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







