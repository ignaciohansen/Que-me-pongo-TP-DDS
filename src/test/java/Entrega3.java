import Clima.ApiClima;
import Imagenes.pruebaImagen;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;
import Telas.Algodon;
import Telas.Cuero;
import TipoPrenda.*;
import Usuario.Usuario;
import Usuario.UsuarioGratuito;
import Usuario.UsuarioPremium;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega3 {
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

}

