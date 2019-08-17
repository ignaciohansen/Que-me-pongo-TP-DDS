import Clima.ApiClima;
import Imagenes.pruebaImagen;
import Ropas.*;
import TipoPrenda.*;
import Usuario.*;
import Telas.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class Entrega1 {
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


    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();
    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();


    private Guardarropa guardarropaPruebaJuan = new Guardarropa();
    private Guardarropa guardarropaConRelojError = new Guardarropa();
    private Guardarropa guardarropaPruebaTomas = new Guardarropa();
    private Usuario juan = new Usuario(premium);
    private Usuario tomas = new Usuario(gratuito);


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

        juan.agregarUnGuardarropas(guardarropaPruebaJuan);


    }



    // entrega 1 = linea 63,72,77,86,147
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
    public void cantidadDePrendasDeAtuendoMinimo4() throws Exception {
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
        // Retorna 6 porque tiene 3 capas de parte superior , si son 5 son dos capas
        System.out.println("La cantidad de prendas del atuendo resultante es:" +atuendoCreado.cantidadDePrendas());
        Assert.assertTrue(atuendoCreado.cantidadDePrendas()>= 4);

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
}






