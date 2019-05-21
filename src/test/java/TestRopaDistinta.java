import Telas.Cuero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda reloj;
    private Prenda campera;
    private Prenda pantufla;
    private Cuero cuero;


    private Guardarropa guardarropaPruebaJuan;
    private Guardarropa guardarropaConRelojError;
    private Usuario juan;
    private Usuario tomas;
    //private Set<Guardarropa> guardarropasDeJuan;

    @Before
    public void init() throws Exception {
        cuero = new Cuero();
        pantufla = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, "Pantufla", Prenda.CategoriaPrenda.Calzado,cuero);
        pantalon = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, "Pantalon", Prenda.CategoriaPrenda.ParteInferior,cuero);
        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Camisa", Prenda.CategoriaPrenda.ParteSuperior,cuero);
        campera = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, "Campera", Prenda.CategoriaPrenda.ParteSuperior,cuero);
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "Zapatilla", Prenda.CategoriaPrenda.Calzado,cuero);
        reloj = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, "Reloj", Prenda.CategoriaPrenda.Accesorio,cuero);



        guardarropaConRelojError = new Guardarropa();
        guardarropaPruebaJuan = new Guardarropa();
        juan = new Usuario();
        tomas = new Usuario();
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
    public void verColorSecundario() {
        Assert.assertEquals(Prenda.Color.Rojo,camisa.getColorSecundario());
    }

    @Test
    public void cantidadDePrendasEnGuardarropaDeJuan() throws Exception {
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);
        Assert.assertEquals(4,guardarropaPruebaJuan.cantidadDePrendas());
    }

    @Test
    public void cantidadDePrendasDeAtuendo() throws Exception {
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



    @Test
    public void cantidadDeGuardarropasDeJuan() throws Exception{
        juan.agregarUnGuardarropas(guardarropaConRelojError);
        Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

    // Test que dan mal, solo para pruebas

    @Test(expected = Exceptions.MismoGuardarropas.class)
    public void mismoGuardarropaADosUsuarios() throws Exception{
        tomas.agregarUnGuardarropas(guardarropaPruebaJuan);
        //Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

    @Test(expected = exceptions.En2Guardarropas.class)
    public void MismaPrendaEnDosGuardarropas() throws Exception {
            guardarropaPruebaJuan.agregarPrenda(reloj);
            guardarropaConRelojError.agregarPrenda(reloj);
            // Assert.assertEquals(1, guardarropaConRelojError.cantidadDePrendas());
        }


    @Test(expected = Exceptions.TelaIncompatible.class)
    public void remeraCueroError() throws Exception {
        Prenda remeraDeCuero;

        remeraDeCuero = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, "remera", Prenda.CategoriaPrenda.ParteSuperior,cuero);

        //Assert.fail();
    }

    @Test
    public void PrendasDistintasDeAtuendo() throws Exception {
        // Cargo el guardarropa
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(pantufla);
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
           [Prenda@39a054a5, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]
           [Prenda@71bc1ae4, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]
           [Prenda@71bc1ae4, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]
           [Prenda@71bc1ae4, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]
           [Prenda@71bc1ae4, Prenda@4cc77c2e, Prenda@6ed3ef1, Prenda@2437c6dc]
           [Prenda@71bc1ae4, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]
           [Prenda@39a054a5, Prenda@4cc77c2e, Prenda@7a7b0070, Prenda@2437c6dc]


        */
       }



    /*

    @Test
    public void testMismoColor(){
        try{
            juan.agregarUnGuardarropas(guardarropaPruebaJuan);
        }
        catch(Exception exception){
            System.out.print(exception.getMessage());
        }
    }

     @Test
    public void cantidadDeGuardarropasDeJuan() throws Exception{
        juan.agregarUnGuardarropas(guardarropaPruebaJuan);
        Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

     */


}







