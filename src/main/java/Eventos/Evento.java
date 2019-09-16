package Eventos;
import Exceptions.ListaRopaVacia;
import Exceptions.atuendoEnListaNegra;
import Generador.Generador;
import Mensajeria.Mail;
import Mensajeria.Whatsapp;
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

    public Atuendo generarAtuendo(Guardarropa guardarropa, Usuario usuario) throws ListaRopaVacia, atuendoEnListaNegra {
        Generador generador = new Generador();
        Atuendo atuendo = generador.generarAtuendoGR(guardarropa,usuario);
     Mail mail = new Mail();
     mail.enviarEmail("Un atuendo fue generado para el evento del dia: " + this.fecha + " en " + this.lugar ,""+atuendo);
        Whatsapp whatsapp = new Whatsapp();
        whatsapp.recibirMensajeAtuendo(atuendo);
        return atuendo;
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
