import Entities.Eventos.Evento;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Sensibilidad.Caluroso;
import Entities.Sensibilidad.Friolento;
import Entities.Sensibilidad.Indiferente;
import Entities.Telas.*;
import Entities.TipoPrenda.*;
import Entities.Usuario.Usuario;
import Entities.Usuario.UsuarioGratuito;
import Entities.Usuario.UsuarioPremium;
import Models.SensibilidadModel;
import Models.TipoPrendaModel;
import Models.tipoUsuarioModel;
import Repositories.Dao.UsuarioDAO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class DatosBaseEntrega {

    private Prenda remera_cuelloredondo_mangacorta;
    private Prenda remera_cuelloredondo_mangalarga;
    private Prenda remera_escotev_mangacorta;
    private Prenda remera_escotev_mangalarga;
    private Prenda sweaterAlejandro;
    private Prenda sweaterJulieta;
    private Prenda campera;
    private Prenda pantalon_largo;
    private Prenda bermuda;
    private Prenda pollera;
    private Prenda calza;
    private Prenda buzo;
    private Prenda musculosaAlejandro;
    private Prenda musculosaJulieta;
    private Prenda zapatillas;
    private Prenda zapatosAlejandro;
    private Prenda zapatosJulieta;
    private Prenda sandalias;


    private Prenda relojA;
    private Prenda gorroA;
    private Prenda pulseraA;
    private Prenda relojJ;
    private Prenda gorroJ;
    private Prenda pulseraJ;


    private RemeraCuelloRedondoMangaCorta tipoRemeraCuelloRedondoMangaCorta = new RemeraCuelloRedondoMangaCorta();
    private RemeraCuelloRedondoMangaLarga tipoRemeraCuelloRedondoMangaLarga = new RemeraCuelloRedondoMangaLarga();
    private RemeraEscoteVMangaCorta tipoRemeraEscoteVMangaCorta = new RemeraEscoteVMangaCorta();
    private RemeraEscoteVMangaLarga tipoRemeraEscoteVMangaLarga = new RemeraEscoteVMangaLarga();
    private Sweater TipoSweater = new Sweater();
    private Campera TipoCampera = new Campera();
    private PantalonLargo TipoPantalonLargo = new PantalonLargo();
    private Bermuda TipoBermuda = new Bermuda();
    private Pollera TipoPollera = new Pollera();
    private Calza TipoCalza = new Calza();
    private Buzo TipoBuzo = new Buzo();
    private Musculosa TipoMusculosa = new Musculosa();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Zapato TipoZapato = new Zapato();
    private Sandalia TipoSandalia = new Sandalia();

    private PantalonCorto TipoPantalonCorto = new PantalonCorto();
    private Pantufla TipoPantufla = new Pantufla();
    private Camisa TipoCamisa = new Camisa();
    private Reloj TipoReloj = new Reloj();
    private Gorro TipoGorro = new Gorro();



    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();
    private Lycra lycra = new Lycra();
    private Jean jean = new Jean();
    private Nylon nylon = new Nylon();
    private Poliester poliester = new Poliester();
    private Seda seda = new Seda();


    private Caluroso caluroso = new Caluroso(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
    private Friolento friolento = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
    private Friolento friolentoYfriolentoCabeza = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Cabeza);
    private Friolento friolentoYfriolentoManos = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Manos);
    private Indiferente indiferente = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);

    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();
    private Usuario alejandro = new Usuario(gratuito,caluroso);
    private Usuario julieta = new Usuario(premium,friolento);

    private Guardarropa guardarropaAlejandro = new Guardarropa();
    private Guardarropa guardarropaJulieta = new Guardarropa();


    @Before
    public void init() throws Exception {

        remera_cuelloredondo_mangacorta = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, tipoRemeraCuelloRedondoMangaCorta, Prenda.CategoriaPrenda.ParteSuperior,algodon,"remera de cuello redondo y manga corta");
        remera_cuelloredondo_mangalarga = new Prenda(Prenda.Color.Amarillo, Prenda.Color.Blanco, tipoRemeraCuelloRedondoMangaLarga, Prenda.CategoriaPrenda.ParteSuperior,lycra,"remera de cuello redondo y manga larga");
        remera_escotev_mangacorta = new Prenda(Prenda.Color.Blanco, Prenda.Color.Negro, tipoRemeraEscoteVMangaCorta, Prenda.CategoriaPrenda.ParteSuperior,lycra,"remera escote en v y manga corta");
        remera_escotev_mangalarga = new Prenda(Prenda.Color.Blanco, Prenda.Color.Negro, tipoRemeraEscoteVMangaLarga, Prenda.CategoriaPrenda.ParteSuperior,algodon,"remera escote en v y manga larga");
        sweaterAlejandro = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, TipoSweater, Prenda.CategoriaPrenda.ParteSuperior,poliester,"sweater");
        sweaterJulieta = new Prenda(Prenda.Color.Gris, Prenda.Color.Rojo, TipoSweater, Prenda.CategoriaPrenda.ParteSuperior,poliester,"sweater");
        musculosaAlejandro = new Prenda(Prenda.Color.Amarillo, Prenda.Color.Blanco, TipoMusculosa, Prenda.CategoriaPrenda.ParteSuperior,lycra,"musculosa");
        musculosaJulieta = new Prenda(Prenda.Color.Verde, Prenda.Color.Blanco, TipoMusculosa, Prenda.CategoriaPrenda.ParteSuperior,lycra,"musculosa");
        campera = new Prenda(Prenda.Color.Blanco, Prenda.Color.Rojo, TipoCampera, Prenda.CategoriaPrenda.ParteSuperior,cuero,"campera");
        pantalon_largo = new Prenda(Prenda.Color.Gris, Prenda.Color.Rojo, TipoPantalonLargo, Prenda.CategoriaPrenda.ParteInferior,nylon,"pantalon largo");
        bermuda = new Prenda(Prenda.Color.Celeste, Prenda.Color.Blanco, TipoBermuda, Prenda.CategoriaPrenda.ParteInferior,jean,"bermuda");
        pollera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoPollera, Prenda.CategoriaPrenda.ParteInferior,seda,"pollera");
        calza = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, TipoCalza, Prenda.CategoriaPrenda.ParteInferior,nylon,"calza");
        buzo = new Prenda(Prenda.Color.Blanco, Prenda.Color.Negro, TipoBuzo, Prenda.CategoriaPrenda.ParteSuperior,algodon,"buzo");

        zapatillas = new Prenda(Prenda.Color.Bordo, Prenda.Color.Blanco, TipoZapatilla, Prenda.CategoriaPrenda.Calzado,nylon,"zapatillas");
        zapatosAlejandro = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoZapato, Prenda.CategoriaPrenda.Calzado,cuero,"zapatos");
        zapatosJulieta = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoZapato, Prenda.CategoriaPrenda.Calzado,cuero,"zapatos");
        sandalias = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, TipoSandalia, Prenda.CategoriaPrenda.Calzado,cuero,"sandalias");


        relojA = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"reloj");
        gorroA = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoGorro, Prenda.CategoriaPrenda.Accesorio,algodon,"gorro");
        pulseraA = new Prenda(Prenda.Color.Rojo, Prenda.Color.Blanco, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"pulsera");
        relojJ = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"reloj");
        gorroJ = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, TipoGorro, Prenda.CategoriaPrenda.Accesorio,algodon,"gorro");
        pulseraJ = new Prenda(Prenda.Color.Rojo, Prenda.Color.Blanco, TipoReloj, Prenda.CategoriaPrenda.Accesorio,cuero,"pulsera");


        alejandro.agregarUnGuardarropas(guardarropaAlejandro);
        julieta.agregarUnGuardarropas(guardarropaJulieta);


        guardarropaAlejandro.setDescripcion("GuardarropaAlejandro");
        guardarropaAlejandro.agregarPrenda(remera_cuelloredondo_mangacorta);
        guardarropaAlejandro.agregarPrenda(remera_escotev_mangacorta);
        guardarropaAlejandro.agregarPrenda(musculosaAlejandro);
        guardarropaAlejandro.agregarPrenda(sweaterAlejandro);
        guardarropaAlejandro.agregarPrenda(campera);
        guardarropaAlejandro.agregarPrenda(bermuda);
        guardarropaAlejandro.agregarPrenda(pantalon_largo);
        guardarropaAlejandro.agregarPrenda(zapatillas);
        guardarropaAlejandro.agregarPrenda(zapatosAlejandro);
        guardarropaAlejandro.agregarPrenda(relojA);
        guardarropaAlejandro.agregarPrenda(gorroA);
        guardarropaAlejandro.agregarPrenda(pulseraA);


        guardarropaJulieta.setDescripcion("GuardarropaJulieta");
        guardarropaJulieta.agregarPrenda(remera_cuelloredondo_mangalarga);
        guardarropaJulieta.agregarPrenda(remera_escotev_mangalarga);
        guardarropaJulieta.agregarPrenda(musculosaJulieta);
        guardarropaJulieta.agregarPrenda(sweaterJulieta);
        guardarropaJulieta.agregarPrenda(pollera);
        guardarropaJulieta.agregarPrenda(calza);
        guardarropaJulieta.agregarPrenda(buzo);
        guardarropaJulieta.agregarPrenda(zapatosJulieta);
        guardarropaJulieta.agregarPrenda(sandalias);
        guardarropaJulieta.agregarPrenda(relojJ);
        guardarropaJulieta.agregarPrenda(gorroJ);
        guardarropaJulieta.agregarPrenda(pulseraJ);

    }
    
    @Test
 public void persistir() throws Exception {


    UsuarioDAO dao = new UsuarioDAO();
    alejandro.setNombre("Alejandro Roco");
    alejandro.setUser("aroco");
    alejandro.setPassword("123456");
    alejandro.setEmail("ignaciohansen@hotmail.com");
    alejandro.setTelefono(1161906402);

    julieta.setNombre("Julieta Azul");
    julieta.setUser("jazul");
    julieta.setPassword("123456");
    julieta.setEmail("ignaciohansen@hotmail.com");
    julieta.setTelefono(1161906402);
   	dao.agregar(alejandro);
   	dao.agregar(julieta);

 	System.out.println("usuarios persistidos");
  }


    @Test
    public void persistirSensibilidades() throws Exception {


        SensibilidadModel dao = new SensibilidadModel();
        dao.agregar(indiferente);
        dao.agregar(friolentoYfriolentoCabeza);
        dao.agregar(friolentoYfriolentoManos);

        System.out.println("sensibilidades persistidas");
    }

    @Test
    public void persistirTipos() throws Exception {


        TipoPrendaModel dao = new TipoPrendaModel();
        dao.agregar(TipoPantalonCorto);
        dao.agregar(TipoPantufla);
        dao.agregar(TipoCamisa);

        System.out.println("tipos prendas persistidas");
    }
}
