package Eventos;
import Exceptions.ListaRopaVacia;
import Generador.Generador;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Usuario.Usuario;

import java.util.Calendar;
import java.util.Date;

public class Evento {
    private Date fecha;
    private String lugar;
    private int diasEnQueSeRepite;

    public Evento(Date fecha, String lugar,int diaRepeticion) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.diasEnQueSeRepite = diaRepeticion;
    }
    //notificar usuario ()

    public Evento crearSiguienteEvento(){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DAY_OF_YEAR, diasEnQueSeRepite);
        Date fechaNueva = calendario.getTime();

        return new Evento(fechaNueva,lugar,diasEnQueSeRepite);
    }

    public Atuendo generarAtuendo(Guardarropa guardarropa, Usuario usuario) throws ListaRopaVacia{
        Generador generador = new Generador();
        return generador.generarAtuendoGR(guardarropa,usuario);
    }

    @Override
    public String toString() {
        return "Evento = [" +
                "fecha=" + fecha +
                ", lugar=" + lugar +
                ", dias en que se repite=" + diasEnQueSeRepite +
                ']';
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public int getDiasEnQueSeRepite() {
        return diasEnQueSeRepite;
    }
}
