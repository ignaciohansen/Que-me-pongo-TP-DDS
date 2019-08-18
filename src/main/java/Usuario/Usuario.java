package Usuario;

import Eventos.Evento;
import Exceptions.SuperoLimiteDeGuardarropas;
import TipoPrenda.TipoPrenda;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Generador.Generador;
import Sensibilidad.tipoSensibilidad;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario{
    private List<Guardarropa> guardarropas;
    private TipoUsuario tipoUsuario;
    private List<Evento> eventos;
    private tipoSensibilidad sensibilidad;

    public Usuario(TipoUsuario tipoUsuario, tipoSensibilidad suSensibilidad){
        this.guardarropas = new ArrayList<Guardarropa>();
        this.eventos = new ArrayList<Evento>();
        this.tipoUsuario = tipoUsuario;
        this.sensibilidad = suSensibilidad;
    }

    public void agregarUnGuardarropas(Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas {

        //VER ESTA IMPLEMENTACION PARA NO REPETIR GUARDARROPAS EN USUARIOS, ES LA MISMA QUE ROPA Y GUARDARROPA
        // COMENTO CODIGO PORQUE AHORA SE PUEDE COMPARTIR GUARDARROPA ENTRE USUARIOS

        //if(guardarropa.perteneceAUsuario){throw new MismoGuardarropas("El guardarropa ya esta asignado a un usuario"); }else{

        // guardarropa.perteneceAUsuario =  true;
        // }

        tipoUsuario.agregarGuardarropa(guardarropas,guardarropa);

    }

    public int cantidadDeGuardarropas(){
       return guardarropas.size();
    }


    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public Atuendo generarAtuendo(Guardarropa guardarropa) {
        Generador generador = new Generador();
        return generador.generarAtuendoGR(guardarropa,this);
    }

    public Evento generarEvento(Date fecha,String lugar,Evento descripcionEvento){
        descripcionEvento = new Evento(fecha,lugar);
        return  descripcionEvento;
    }

        public void cargarEvento(Evento unEvento) {
        eventos.add(unEvento);
    }

    public List<Atuendo> generarAtuendos(){
        Generador generador = new Generador();
        return generador.generarAtuendos(this.guardarropas,this);
    }

    public int nivelSensibilidad(){
        return sensibilidad.getValor();
    }

    public TipoPrenda.parteDelCuerpoQueAbriga parteSensible(){
        return sensibilidad.getParteCuerpo();
    }
}

/* Asistir a evento ( de mi lista )
PASOS)
1)Ver si de mi lista de eventos tengo uno hoy                                                   (Metodo de usuario) IF( Evento.date() = date() )
2)Si tengo uno, el evento me genera un atuendo                                                  (Metodo de evento)  evento.generarAtuendo
3)Me lo notifica por wpp o mail                                                                 (Metodo de evento)
4)Genera el siguiente evento (segun su variable cada cuantos dias se repite)                    (Metodo de evento)
 */