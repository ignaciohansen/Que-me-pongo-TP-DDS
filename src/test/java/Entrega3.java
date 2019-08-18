import Clima.ApiClima;
import Exceptions.En2Guardarropas;
import Exceptions.SuperoLimiteDeGuardarropas;
import Imagenes.pruebaImagen;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;
import Sensibilidad.Caluroso;
import Sensibilidad.Friolento;
import Sensibilidad.Indiferente;
import Sensibilidad.tipoSensibilidad;
import Telas.Algodon;
import Telas.Cuero;
import TipoPrenda.*;
import Usuario.Usuario;
import Usuario.UsuarioGratuito;
import Usuario.UsuarioPremium;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();
    private Caluroso caluroso = new Caluroso(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
    private Friolento friolento = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Cabeza);
    private Indiferente indiferente = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);


    private Guardarropa guardarropaCompartido = new Guardarropa();
    private Usuario juan = new Usuario(premium,caluroso);
    private Usuario tomas = new Usuario(gratuito,friolento);


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
public void AtuendosSinRepetirRopaDeMismoGuardarropa() throws En2Guardarropas, SuperoLimiteDeGuardarropas {
    // Cargo el guardarropa


    System.out.println("Cantidad de prendas en guardarropa sin utilizar " + guardarropaCompartido.getPrendas().stream().filter(prenda -> prenda.seUtilizaEnUnAtuendo == false).collect(Collectors.toList()).size());
    Atuendo primerAtuendo = juan.generarAtuendo(guardarropaCompartido);
   System.out.println(primerAtuendo);
    System.out.println("Cantidad de prendas en guardarropa sin utilizar " + guardarropaCompartido.getPrendas().stream().filter(prenda -> prenda.seUtilizaEnUnAtuendo == false).collect(Collectors.toList()).size());

    Atuendo segundoAtuendo = tomas.generarAtuendo(guardarropaCompartido);
    System.out.println(segundoAtuendo);

}

@Test
public void parteDelCuerpoCubiertaPorAccesorio() {
    System.out.println(TipoReloj.getParteDelCuerpo());
}

    @Test
    public void tomasConGorroAlSerSensible() {

      Atuendo atuendoCreado = tomas.generarAtuendo(guardarropaCompartido);

      System.out.println(atuendoCreado);

    }


}

