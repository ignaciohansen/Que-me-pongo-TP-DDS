
import Api.Mensajeria.Whatsapp;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.Algodon;
import Entities.Telas.Cuero;
import Entities.TipoPrenda.*;
import Entities.Usuario.Usuario;
import Entities.Usuario.UsuarioGratuito;
import Entities.Usuario.UsuarioPremium;
import Entities.Sensibilidad.Indiferente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega1 {
    private Prenda pantufla;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda joggin;
    private Prenda reloj;
    private Prenda pulsera;
    private Prenda campera;
    private Prenda camperon;
    private Prenda camisa;
    private Prenda remera;
    private Prenda musculosa;
    private Prenda sweater;
    private Prenda buzo;

    private Sweater TipoSweater = new Sweater();
    private Camisa TipoCamisa = new Camisa();
    private Reloj TipoReloj = new Reloj();
    private RemeraCuelloRedondoMangaCorta tipoRemera = new RemeraCuelloRedondoMangaCorta();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Pantufla TipoPantufla = new Pantufla();
    private PantalonLargo TipoPantalon = new PantalonLargo();
    private Campera TipoCampera = new Campera();


    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();
    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();
    private Indiferente indiferente = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);

    private Guardarropa guardarropaPruebaJuan = new Guardarropa();
    private Guardarropa guardarropaConRelojError = new Guardarropa();
    private Guardarropa guardarropa = new Guardarropa();
    private Usuario juan = new Usuario(premium,indiferente);
    private Usuario tomas = new Usuario(gratuito,indiferente);


    @Before
    public void init() throws Exception {
        pantufla = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoPantufla, Prenda.CategoriaPrenda.Calzado,cuero,"pantufla");
        zapatillas = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoZapatilla, Prenda.CategoriaPrenda.Calzado,cuero,"zapatilla");
        pantalon = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoPantalon, Prenda.CategoriaPrenda.ParteInferior,cuero,"pantalon");
        joggin = new Prenda(Prenda.Color.Azul, Prenda.Color.Blanco, TipoPantalon, Prenda.CategoriaPrenda.ParteInferior,cuero,"joggin");
        camisa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoCamisa, Prenda.CategoriaPrenda.ParteSuperior,algodon,"camisa");
        remera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,algodon,"remera");
        musculosa = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,algodon,"musculosa");
        sweater = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoSweater, Prenda.CategoriaPrenda.ParteSuperior,algodon,"sweater");
        buzo = new Prenda(Prenda.Color.Amarillo, Prenda.Color.Blanco, TipoSweater, Prenda.CategoriaPrenda.ParteSuperior,algodon,"buzo");
        campera = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, TipoCampera, Prenda.CategoriaPrenda.ParteSuperior,cuero,"campera");
        camperon = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoCampera, Prenda.CategoriaPrenda.ParteSuperior,cuero,"camperon");
        reloj = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"reloj");
        pulsera = new Prenda(Prenda.Color.Rojo, Prenda.Color.Blanco, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"pulsera");


        guardarropaPruebaJuan.agregarPrenda(pantalon);
        guardarropaPruebaJuan.agregarPrenda(camisa);
        guardarropaPruebaJuan.agregarPrenda(sweater);
        guardarropaPruebaJuan.agregarPrenda(remera);
        guardarropaPruebaJuan.agregarPrenda(musculosa);
        guardarropaPruebaJuan.agregarPrenda(campera);
        guardarropaPruebaJuan.agregarPrenda(zapatillas);
        guardarropaPruebaJuan.agregarPrenda(reloj);
        guardarropaPruebaJuan.agregarPrenda(pantufla);
        guardarropaPruebaJuan.agregarPrenda(pulsera);
        guardarropaPruebaJuan.agregarPrenda(joggin);
        guardarropaPruebaJuan.agregarPrenda(camperon);

        juan.agregarUnGuardarropas(guardarropaPruebaJuan);


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
    public void cantidadDePrendasDeAtuendoMinimo4() throws Exception {

        //Armo el atuendo
        juan.setTelefono(1161906402);
        juan.setNombre("juan");
        Whatsapp mensaje = new Whatsapp();

        //juan.setEmail("ignaciohansen@hotmail.com");
        Atuendo atuendoCreado = juan.generarAtuendo(guardarropaPruebaJuan);
        mensaje.recibirMensajeAtuendo(atuendoCreado,juan);


        // Test funciona, tengo 7 prendas y retorna 6, el filtrado anda bien
        // Retorna 6 porque tiene 3 capas de parte superior , si son 5 son dos capas
        System.out.println("La cantidad de prendas del atuendo resultante es:" +atuendoCreado.cantidadDePrendas());
        Assert.assertTrue(atuendoCreado.cantidadDePrendas()>= 4);

    }


    @Test
    public void PrendasDistintasDeAtuendo() throws Exception {


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






