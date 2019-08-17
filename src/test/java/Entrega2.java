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

public class Entrega2 {
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


    @Test(expected = Exceptions.MismoGuardarropas.class)
    public void mismoGuardarropaADosUsuarios() throws Exception{
        tomas.agregarUnGuardarropas(guardarropaPruebaJuan);

    }

    @Test(expected = Exceptions.En2Guardarropas.class)
    public void MismaPrendaEnDosGuardarropas() throws Exception {
            guardarropaPruebaJuan.agregarPrenda(reloj);
            guardarropaConRelojError.agregarPrenda(reloj);

        }


    @Test(expected = Exceptions.TelaIncompatible.class)
    public void remeraCueroError() throws Exception {
        Prenda remeraDeCuero;
        remeraDeCuero = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,cuero);
    }

    @Test
    public void prendasIncompatiblesCuero() {
        Assert.assertEquals(2, cuero.cantidadPrendasIncompatibles());
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

    @Test
    public void consultarClima() throws Exception {
        ApiClima clima = new ApiClima();

        int temperatura = clima.obtenerHttp();
        System.out.println("Temperatura que devuelve la api:" + temperatura);

        Assert.assertTrue(temperatura>-10);
    }

}






