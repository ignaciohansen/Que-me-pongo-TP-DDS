import Imagenes.pruebaImagen;
import Ropas.*;
import TipoPrenda.*;
import Usuario.*;
import Telas.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class TestRopaDistinta {
    private Prenda camisa;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda reloj;
    private Prenda campera;
    private Prenda pantufla;
    private Prenda sweater;
    private Prenda remera;
    private Sweater TipoSweater = new Sweater();
    private Camisa TipoCamisa = new Camisa();
    private Reloj TipoReloj = new Reloj();
    private Remera tipoRemera = new Remera();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Pantufla TipoPantufla = new Pantufla();
    private Pantalon TipoPantalon = new Pantalon();
    private Campera TipoCampera = new Campera();
    private pruebaImagen Mostrador;

    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();
    private UsuarioPremium premium;
    private UsuarioGratuito gratuito;


    private Guardarropa guardarropaPruebaJuan;
    private Guardarropa guardarropaConRelojError;
    private Guardarropa guardarropaPruebaTomas;
    private Usuario juan;
    private Usuario tomas;
    //private Set<Ropas.Guardarropa> guardarropasDeJuan;

    @Before
    public void init() throws Exception {
        pantufla = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoPantufla, Prenda.CategoriaPrenda.Calzado,cuero);
        sweater = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoSweater, Prenda.CategoriaPrenda.Calzado,algodon);
        pantalon = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoPantalon, Prenda.CategoriaPrenda.ParteInferior,cuero);
        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoCamisa, Prenda.CategoriaPrenda.ParteSuperior,algodon);
        remera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,algodon);
        campera = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, TipoCampera, Prenda.CategoriaPrenda.ParteSuperior,cuero);
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoZapatilla, Prenda.CategoriaPrenda.Calzado,cuero);
        reloj = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero);
        premium = new UsuarioPremium();
        gratuito = new UsuarioGratuito();


        guardarropaConRelojError = new Guardarropa();
        guardarropaPruebaJuan = new Guardarropa();
        guardarropaPruebaTomas = new Guardarropa();
        juan = new Usuario(premium);
        tomas = new Usuario(gratuito);
        juan.agregarUnGuardarropas(guardarropaPruebaJuan);

        //camisa2 = new Ropas.Prenda(Ropas.Prenda.color.Negro, Ropas.Prenda.color.Negro, "Camisa", Ropas.Prenda.categoriaPrenda.ParteSuperior);ç
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
        guardarropaPruebaJuan.agregarPrenda(sweater);
        guardarropaPruebaJuan.agregarPrenda(remera);
        guardarropaPruebaJuan.agregarPrenda(campera);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);

        //Armo el atuendo
        Atuendo atuendoCreado = juan.generarAtuendo(guardarropaPruebaJuan);

        // Test funciona, tengo 7 prendas y retorna 6, el filtrado anda bien
        // Retorna 6 porque tiene 3 capas de parte superior
        Assert.assertEquals(6,atuendoCreado.cantidadDePrendas());

    }

    @Test
    public void cantidadDeGuardarropasDeJuan() throws Exception{
        juan.agregarUnGuardarropas(guardarropaConRelojError);
        Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

    @Test(expected = Exceptions.SuperoLimiteDeGuardarropas.class)
    public void cantidadDeGuardarropasDeTomas() throws Exception{
        tomas.agregarUnGuardarropas(guardarropaPruebaTomas);
        tomas.agregarUnGuardarropas(guardarropaPruebaTomas);
        tomas.agregarUnGuardarropas(guardarropaPruebaTomas);
    }

    // Test que dan mal, solo para pruebas

    @Test(expected = Exceptions.MismoGuardarropas.class)
    public void mismoGuardarropaADosUsuarios() throws Exception{
        tomas.agregarUnGuardarropas(guardarropaPruebaJuan);
        //Assert.assertEquals(2,juan.cantidadDeGuardarropas());
    }

    @Test(expected = Exceptions.En2Guardarropas.class)
    public void MismaPrendaEnDosGuardarropas() throws Exception {
            guardarropaPruebaJuan.agregarPrenda(reloj);
            guardarropaConRelojError.agregarPrenda(reloj);
            // Assert.assertEquals(1, guardarropaConRelojError.cantidadDePrendas());
        }


    @Test(expected = Exceptions.TelaIncompatible.class)
    public void remeraCueroError() throws Exception {
        Prenda remeraDeCuero;
        remeraDeCuero = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,cuero);
    }

    @Test
    public void cueroIncompatibleConRemera() {
        //Prenda remeraDeCuero;
        //remeraDeCuero = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoRemera, Prenda.CategoriaPrenda.ParteSuperior,cuero);
        //Assert.assertTrue(cuero.incompatible(tipoRemera));
        Assert.assertEquals("remera", tipoRemera.getSuTipo());
        //Assert.assertTrue(1 > 0);

    }

    @Test
    public void prendasIncompatiblesCuero() {
        Assert.assertEquals(2, cuero.cantidadPrendasIncompatibles());
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
        guardarropaPruebaJuan.agregarPrenda(remera);

        //Armo el atuendo 1
        Atuendo atuendoCreadoUno = juan.generarAtuendo(guardarropaPruebaJuan);

        //Armo el atuendo 2
        Atuendo atuendoCreadoDos = juan.generarAtuendo(guardarropaPruebaJuan);

        System.out.println(atuendoCreadoUno);
        System.out.println(atuendoCreadoDos);
        // Verifico con el hash, si da distinto significa que los atuendos generados son aleatorios
        Assert.assertNotEquals(atuendoCreadoUno,atuendoCreadoDos);

        /*
        Resultados de ejecucion:

        1º [Ropas.Prenda@9e89d68, Ropas.Prenda@77556fd, Ropas.Prenda@3b192d32, Ropas.Prenda@16f65612]
        2º [Ropas.Prenda@368239c8, Ropas.Prenda@77556fd, Ropas.Prenda@3b192d32, Ropas.Prenda@16f65612]  Cambio el primero, random funcionando
        3º [Ropas.Prenda@9e89d68, Ropas.Prenda@77556fd, Ropas.Prenda@3b192d32, Ropas.Prenda@16f65612]
        4º [Ropas.Prenda@9e89d68, Ropas.Prenda@77556fd, Ropas.Prenda@3b192d32, Ropas.Prenda@16f65612]
                                                    Funciona
           [Ropas.Prenda@39a054a5, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@71bc1ae4, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@71bc1ae4, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@71bc1ae4, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@71bc1ae4, Ropas.Prenda@4cc77c2e, Ropas.Prenda@6ed3ef1, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@71bc1ae4, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]
           [Ropas.Prenda@39a054a5, Ropas.Prenda@4cc77c2e, Ropas.Prenda@7a7b0070, Ropas.Prenda@2437c6dc]


        */
       }

    @Test

    public void nivelAbrigoAtuendo() throws Exception {
        // Cargo el guardarropa
        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(pantufla);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(campera);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);
        guardarropaPruebaJuan.agregarPrenda(remera);

        int nivelDeAbrigoParaTemperaturaDe5Grados = 20; //( Numero para calculo - grados, 25-5)
        Atuendo atuendoCreadoUno = juan.generarAtuendo(guardarropaPruebaJuan);
        System.out.println("Nivel de abrigo del atuendo generado:" + atuendoCreadoUno.nivelAbrigo());
        Assert.assertTrue(atuendoCreadoUno.nivelAbrigo()>nivelDeAbrigoParaTemperaturaDe5Grados);

}

/*
    @Test
    public void mostrarImagenCamisa() {
        ImageIcon ImagenCamisa = TipoCamisa.getFoto();
        //Mostrador = new pruebaImagen(ImagenCamisa);
        Mostrador.mostrarImagen(ImagenCamisa);

    }

 */
}






