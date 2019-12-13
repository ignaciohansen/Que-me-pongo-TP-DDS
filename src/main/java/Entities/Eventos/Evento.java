package Entities.Eventos;
import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.atuendoEnListaNegra;
import Entities.Generador.Generador;
import Api.Mensajeria.Mail;
import Api.Mensajeria.Whatsapp;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
import Entities.Usuario.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="EVENTO")
public class Evento {
	
	@Id
	@GeneratedValue
	@Column(name="evento_id")
	private long id;
	
	@Column(name="evento_fecha")
    private LocalDate fecha;
	
	@Column(name="evento_lugar")
    private String lugar;
	
	@Column(name="evento_dias_repet")
    private int diasEnQueSeRepite;

    @Column(name="evento_eliminado")
    private int eliminado;

    @Column(name="evento_hoy")
    private int esEnElDiaDeHoy;

	public Evento() {}
	
    public Evento(LocalDate fecha, String lugar,int diaRepeticion) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.diasEnQueSeRepite = diaRepeticion;
        this.eliminado = 0;
        actualizarSiElEventoEsHoy();
	}

    public Evento crearSiguienteEvento()  {
        Date date = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        calendario.add(Calendar.DAY_OF_YEAR, diasEnQueSeRepite);
        Date fechaNuevaDate = calendario.getTime();

        LocalDate fechaNuevaLocalDate = fechaNuevaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new Evento(fechaNuevaLocalDate,lugar,diasEnQueSeRepite);
    }

    public Evento crearEvento(LocalDate fecha, String lugar, int diaRepeticion) {
	    return new Evento(fecha, lugar, diaRepeticion);
    }

    public Atuendo generarAtuendo(Guardarropa guardarropa, Usuario usuario) throws ListaRopaVacia, atuendoEnListaNegra {
        Generador generador = new Generador();
        Atuendo atuendo = generador.generarAtuendoGR(guardarropa,usuario);
        return atuendo;
    }

    @Override
    public String toString() {
        return "Evento = [" +
                "fecha=" + fecha +
                ", lugar=" + lugar +
                ", dias en que se repite=" + diasEnQueSeRepite +
                ",Es hoy=" + esEnElDiaDeHoy +
                ']';
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public int getDiasEnQueSeRepite() {
        return diasEnQueSeRepite;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setDiasEnQueSeRepite(int diasEnQueSeRepite) {
		this.diasEnQueSeRepite = diasEnQueSeRepite;
	}

    public void actualizarSiElEventoEsHoy() {
        LocalDate diaDeHoy = LocalDate.now();
	    if(this.getFecha().equals(diaDeHoy)){
	        this.esEnElDiaDeHoy = 1;
        } else
        {
            this.esEnElDiaDeHoy = 0;
        }

    }

    public int getEsEnElDiaDeHoy() {
        return esEnElDiaDeHoy;
    }

    public int getEliminado() { return eliminado; }

    public void Eliminar() { this.eliminado = 1; }
    
}
