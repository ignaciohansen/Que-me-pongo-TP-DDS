
import Entities.TipoPrenda.*;
import Entities.Eventos.Evento;
import Entities.Exceptions.En2Guardarropas;
import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.SuperoLimiteDeGuardarropas;
import Entities.Exceptions.atuendoEnListaNegra;
import Api.Mensajeria.Whatsapp;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Sensibilidad.Caluroso;
import Entities.Sensibilidad.Friolento;
import Entities.Sensibilidad.Indiferente;
import Entities.Telas.Algodon;
import Entities.Telas.Cuero;

import Entities.Usuario.Usuario;
import Entities.Usuario.UsuarioGratuito;
import Entities.Usuario.UsuarioPremium;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.stream.Collectors;

public class Entrega3 {

    private Prenda pantufla;
    private Prenda zapatillas;
    private Prenda pantalon;
    private Prenda joggin;
    private Prenda reloj;
    private Prenda gorro;
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
    private Gorro TipoGorro = new Gorro();
    private Remera tipoRemera = new Remera();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Pantufla TipoPantufla = new Pantufla();
    private Pantalon TipoPantalon = new Pantalon();
    private Campera TipoCampera = new Campera();

    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();

    private Caluroso caluroso = new Caluroso(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
    private Friolento friolento = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
    private Friolento friolentoYfriolentoCabeza = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Cabeza);
    private Friolento friolentoYfriolentoManos = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Manos);
    private Indiferente indiferente = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);

    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();
    private Usuario juan = new Usuario(premium,caluroso);
    private Usuario tomas = new Usuario(gratuito,friolentoYfriolentoCabeza);
    private Usuario ana = new Usuario(premium,friolentoYfriolentoManos);

    Whatsapp mensaje = new Whatsapp();

    private Guardarropa guardarropaCompartido = new Guardarropa();
    private Guardarropa guardarropaCasiVacio = new Guardarropa();

    private Evento eventoDiaDeHoy = new Evento(new Date(),"CABA",1);

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
        gorro = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoGorro, Prenda.CategoriaPrenda.Accesorio,algodon,"gorro");
        pulsera = new Prenda(Prenda.Color.Rojo, Prenda.Color.Blanco, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"pulsera");

        juan.agregarUnGuardarropas(guardarropaCompartido);
        tomas.agregarUnGuardarropas(guardarropaCompartido);
        ana.agregarUnGuardarropas(guardarropaCasiVacio);

        guardarropaCompartido.agregarPrenda(pantalon);
        guardarropaCompartido.agregarPrenda(pantufla);
        guardarropaCompartido.agregarPrenda(camisa);
        guardarropaCompartido.agregarPrenda(musculosa);
        guardarropaCompartido.agregarPrenda(campera);
        guardarropaCompartido.agregarPrenda(zapatillas);
        guardarropaCompartido.agregarPrenda(reloj);
        guardarropaCompartido.agregarPrenda(remera);
        guardarropaCompartido.agregarPrenda(joggin);
        guardarropaCompartido.agregarPrenda(pulsera);
        guardarropaCompartido.agregarPrenda(camperon);
        guardarropaCompartido.agregarPrenda(sweater);
        guardarropaCompartido.agregarPrenda(buzo);
        guardarropaCompartido.agregarPrenda(gorro);

    }

//Test para probar que usuario no arme un atuendo con ropa ya utilizada por otro

    @Test
public void AtuendosSinRepetirRopaDeMismoGuardarropa() throws En2Guardarropas, SuperoLimiteDeGuardarropas, ListaRopaVacia, atuendoEnListaNegra {

    System.out.println("Cantidad de prendas en guardarropa sin utilizar " + guardarropaCompartido.getPrendas().stream().filter(prenda -> prenda.getSeUtilizaEnUnAtuendo() == false).collect(Collectors.toList()).size());
    Atuendo segundoAtuendo = tomas.generarAtuendo(guardarropaCompartido);
    System.out.println("Cantidad de prendas en guardarropa sin utilizar " + guardarropaCompartido.getPrendas().stream().filter(prenda -> prenda.getSeUtilizaEnUnAtuendo() == false).collect(Collectors.toList()).size());
    Atuendo primerAtuendo = juan.generarAtuendo(guardarropaCompartido);



}

@Test
public void parteDelCuerpoCubiertaPorAccesorio() {
    System.out.println(TipoReloj.getParteDelCuerpo());
}

@Test
public void tomasConGorroAlSerSensible() throws ListaRopaVacia, atuendoEnListaNegra {

tomas.generarAtuendo(guardarropaCompartido);
    }

    @Test
public void juanCalurosoYtomasFriolento() throws ListaRopaVacia, atuendoEnListaNegra {
    tomas.setSensibilidad(friolento);
    Atuendo atuendoCreadoJuan = juan.generarAtuendo(guardarropaCompartido);
    System.out.println(atuendoCreadoJuan.cantidadDePrendas());
    Atuendo atuendoCreadoTomas = tomas.generarAtuendo(guardarropaCompartido);
    System.out.println(atuendoCreadoTomas.cantidadDePrendas());
  Assert.assertTrue(atuendoCreadoTomas.cantidadDePrendas() > atuendoCreadoJuan.cantidadDePrendas());

}

    @Test(expected = Exception.class)
    public void anaNoLeGustaAtuendo() throws ListaRopaVacia, En2Guardarropas, atuendoEnListaNegra {

        guardarropaCompartido.sacarPrenda(zapatillas);
        guardarropaCompartido.sacarPrenda(reloj);
        guardarropaCompartido.sacarPrenda(remera);
        guardarropaCompartido.sacarPrenda(joggin);
        guardarropaCasiVacio.agregarPrenda(zapatillas);
        guardarropaCasiVacio.agregarPrenda(reloj);
        guardarropaCasiVacio.agregarPrenda(remera);
        guardarropaCasiVacio.agregarPrenda(joggin);
        ana.generarAtuendo(guardarropaCasiVacio);
        ana.generarAtuendo(guardarropaCasiVacio);
    }

@Test
    public void whatsappPrueba(){
    mensaje.recibirMensaje();
}

    @Test
    public void whatsappPruebaAtuendo() throws ListaRopaVacia, atuendoEnListaNegra {
        Atuendo atuendoCreadoJuan = juan.generarAtuendo(guardarropaCompartido);
        mensaje.recibirMensajeAtuendo(atuendoCreadoJuan);
    }



    @Test
    public void generarEventoParaManiana(){

        Evento siguienteEvento = eventoDiaDeHoy.crearSiguienteEvento();
        System.out.println("Mi evento del dia de hoy es: " + eventoDiaDeHoy);
        System.out.println("Cree el evento para mañana: " + siguienteEvento);

    }

    @Test
    public void JuanAsisteAEvento() throws ListaRopaVacia, atuendoEnListaNegra {
        juan.cargarEvento(eventoDiaDeHoy);
        System.out.println("Eventos: " + juan.getEventos());
        juan.asistirAEvento(guardarropaCompartido);


    }

}

