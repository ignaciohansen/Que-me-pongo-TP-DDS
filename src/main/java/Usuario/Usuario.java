package Usuario;

import Eventos.Evento;
import Exceptions.ListaRopaVacia;
import Exceptions.SuperoLimiteDeGuardarropas;
import Exceptions.atuendoEnListaNegra;
import TipoPrenda.TipoPrenda;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Generador.Generador;
import Sensibilidad.tipoSensibilidad;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario{
    private List<Guardarropa> guardarropas;
    private TipoUsuario tipoUsuario;

    public List<Atuendo> getListaNegraAtuendos() {
        return listaNegraAtuendos;
    }

    private List<Atuendo> listaNegraAtuendos;
    private List<Evento> eventos;

    public void setSensibilidad(tipoSensibilidad sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    private tipoSensibilidad sensibilidad;

    public Usuario(TipoUsuario suTipoUsuario, tipoSensibilidad suSensibilidad){
        guardarropas = new ArrayList<Guardarropa>();
        eventos = new ArrayList<Evento>();
        listaNegraAtuendos = new ArrayList<Atuendo>();
        tipoUsuario = suTipoUsuario;
        sensibilidad = suSensibilidad;
    }

    public void agregarUnGuardarropas(Guardarropa guardarropa) throws SuperoLimiteDeGuardarropas {

        tipoUsuario.agregarGuardarropa(guardarropas,guardarropa);
    }

    public int cantidadDeGuardarropas(){
       return guardarropas.size();
    }

    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public Atuendo generarAtuendo(Guardarropa guardarropa) throws ListaRopaVacia, atuendoEnListaNegra {
        Generador generador = new Generador();
        return generador.generarAtuendoGR(guardarropa,this);
    }
    public void agregarAListaNegra(Atuendo atuendo){
        listaNegraAtuendos.add(atuendo);
    }


// SENSIBILIDAD

    public int nivelSensibilidad(){
        return sensibilidad.getValor();
    }

    public TipoPrenda.parteDelCuerpoQueAbriga parteSensible(){
        return sensibilidad.getParteCuerpo();
    }

// EVENTOS

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento generarEvento(Date fecha,String lugar,Evento descripcionEvento,int diaRepeticion){
        descripcionEvento = new Evento(fecha,lugar,diaRepeticion);
        return  descripcionEvento;
    }

    public void cargarEvento(Evento unEvento) {eventos.add(unEvento); }
    public void sacarEvento(Evento unEvento) {eventos.remove(unEvento);}
    public void sacarEventoAsistidoYCargarSiguiente(Evento eventoViejo,Evento eventoNuevo){
        this.sacarEvento(eventoViejo);
        this.cargarEvento(eventoNuevo);
    }

    public Evento tomarUnEventoDeHoy(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaHoy = sdf.format(new Date());

        List<Evento> eventosDeHoy = eventos.stream().filter(evento -> sdf.format(evento.getFecha()).equals(fechaHoy)).collect(Collectors.toList());
        System.out.println("Eventos de hoy : " + eventosDeHoy);
        int random = (int)(Math.random()*eventosDeHoy.size());

        return eventosDeHoy.get(random);
    }

    public void asistirAEvento(Guardarropa guardarropa) throws ListaRopaVacia, atuendoEnListaNegra {
        Evento eventoAlAzar = this.tomarUnEventoDeHoy();
        eventoAlAzar.generarAtuendo(guardarropa,this);
        Evento eventoSiguiente = eventoAlAzar.crearSiguienteEvento();
        this.sacarEventoAsistidoYCargarSiguiente(eventoAlAzar,eventoSiguiente);
        System.out.println("Eventos actualizados : " + this.getEventos());
    }

}

/* Asistir a evento ( de mi lista )
PASOS)
1)Ver si de mi lista de eventos tengo uno hoy                                          PARA HACER        (Metodo de usuario) IF( Evento.date() = date() )
2)Si tengo uno, el evento me genera un atuendo                                         EVENTO GENERA         (Metodo de evento)  evento.generarAtuendo
3)Me lo notifica por wpp o mail                                                        PARA HACER         (Metodo de evento)
4)Genera el siguiente evento (segun su variable cada cuantos dias se repite)           OK         (Metodo de evento)
 */