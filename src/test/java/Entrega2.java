import Clima.ApiClima;
import Imagenes.pruebaImagen;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;
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

public class Entrega2 {
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
    private Remera tipoRemera = new Remera();
    private Zapatilla TipoZapatilla = new Zapatilla();
    private Pantufla TipoPantufla = new Pantufla();
    private Pantalon TipoPantalon = new Pantalon();
    private Campera TipoCampera = new Campera();


    private Cuero cuero = new Cuero();
    private Algodon algodon = new Algodon();
    private UsuarioPremium premium  = new UsuarioPremium();
    private UsuarioGratuito gratuito = new UsuarioGratuito();
    private Indiferente indiferente = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);


    private Guardarropa guardarropaPruebaJuan = new Guardarropa();
    private Guardarropa guardarropaConRelojError = new Guardarropa();
    private Guardarropa guardarropaPruebaTomas = new Guardarropa();
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

/*
    @Test(expected = Exceptions.MismoGuardarropas.class)
    public void mismoGuardarropaADosUsuarios() throws Exception{
        tomas.agregarUnGuardarropas(guardarropaPruebaJuan); }
*/

    @Test(expected = Exceptions.En2Guardarropas.class)
    public void MismaPrendaEnDosGuardarropas() throws Exception {
            guardarropaPruebaJuan.agregarPrenda(reloj);
            guardarropaConRelojError.agregarPrenda(reloj);

        }


    @Test(expected = Exceptions.TelaIncompatible.class)
    public void remeraCueroError() throws Exception {
        Prenda remeraDeCuero;
        remeraDeCuero = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, tipoRemera, Prenda.CategoriaPrenda.ParteSuperior,cuero,"remera de cuero");
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






