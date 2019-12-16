import Entities.Eventos.Evento;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Sensibilidad.Caluroso;
import Entities.Sensibilidad.Friolento;
import Entities.Sensibilidad.Indiferente;
import Entities.Telas.Algodon;
import Entities.Telas.Cuero;
import Entities.TipoPrenda.*;
import Entities.Usuario.Usuario;
import Entities.Usuario.UsuarioGratuito;
import Entities.Usuario.UsuarioPremium;
import Models.*;
import Repositories.Dao.UsuarioDAO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class DatosBase {
	
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
    private RemeraCuelloRedondoMangaCorta tipoRemera = new RemeraCuelloRedondoMangaCorta();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Pantufla TipoPantufla = new Pantufla();
    private PantalonLargo TipoPantalon = new PantalonLargo();
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
    private Usuario nacho = new Usuario(premium,caluroso);
    private Usuario tomas = new Usuario(gratuito,friolentoYfriolentoCabeza);
    private Usuario ana = new Usuario(premium,friolentoYfriolentoManos);
    
    private Guardarropa guardarropaCompartido = new Guardarropa();
    private Guardarropa guardarropaCasiVacio = new Guardarropa();

    private Evento eventoDiaDeHoy = new Evento(LocalDate.now(),"CABA",1);


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

        nacho.agregarUnGuardarropas(guardarropaCompartido);
        tomas.agregarUnGuardarropas(guardarropaCompartido);
        ana.agregarUnGuardarropas(guardarropaCasiVacio);

        guardarropaCompartido.setDescripcion("GuardarropaTestEntrega4");
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
    
    @Test
 public void persistir() throws Exception {


    UsuarioDAO dao = new UsuarioDAO();
  	nacho.setNombre("nacho");
  	nacho.setUser("nacho");
  	nacho.setPassword("1234");
  	nacho.setEmail("ignaciohansen@hotmail.com");
  	nacho.setTelefono(1161906402);
   	dao.agregar(nacho);

 	System.out.println("usuario persistido");
  }

    @Test
    public void persistirTiposUsuario() throws Exception {


        tipoUsuarioModel dao = new tipoUsuarioModel();
        dao.agregar(gratuito);
        System.out.println("tipos de usuarios persistidos");

    }

    @Test
    public void persistirSensibilidades() throws Exception {


        SensibilidadModel dao = new SensibilidadModel();
        dao.agregar(indiferente);
        dao.agregar(friolento);
        dao.agregar(friolentoYfriolentoCabeza);
        dao.agregar(friolentoYfriolentoManos);

        System.out.println("sensibilidades persistidas");
    }
}
