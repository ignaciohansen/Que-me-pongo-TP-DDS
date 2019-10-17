package Entities.Usuario;

import Entities.Eventos.Evento;

import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.SuperoLimiteDeGuardarropas;
import Entities.Exceptions.atuendoEnListaNegra;
import Entities.TipoPrenda.TipoPrenda;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
import Entities.Generador.Generador;
import Entities.Sensibilidad.tipoSensibilidad;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario{
	
	@Id
	@GeneratedValue
	@Column(name="usuario_id")
	private long id;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    private List<Guardarropa> guardarropas;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private TipoUsuario tipoUsuario;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Atuendo> listaNegraAtuendos;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Evento> eventos;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private tipoSensibilidad sensibilidad;
    
    @Column(name="usuario_nombre")
    private String nombre;
    
    @Column(name="usuario_user")
    private String user;
    
    @Column(name="usuario_password")
    private String password;

    public Usuario() {}
    
    public Usuario(TipoUsuario suTipoUsuario, tipoSensibilidad suSensibilidad){
        guardarropas = new ArrayList<Guardarropa>();
        eventos = new ArrayList<Evento>();
        listaNegraAtuendos = new ArrayList<Atuendo>();
        tipoUsuario = suTipoUsuario;
        sensibilidad = suSensibilidad;
    }

    public List<Atuendo> getListaNegraAtuendos() {
    	return listaNegraAtuendos;
    }
    
    
    public void setSensibilidad(tipoSensibilidad sensibilidad) {
    	this.sensibilidad = sensibilidad;
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
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public tipoSensibilidad getSensibilidad() {
    	return sensibilidad;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void setGuardarropas(List<Guardarropa> guardarropas) {
    	this.guardarropas = guardarropas;
    }
    
    public void setListaNegraAtuendos(List<Atuendo> listaNegraAtuendos) {
    	this.listaNegraAtuendos = listaNegraAtuendos;
    }
    
    public void setEventos(List<Evento> eventos) {
    	this.eventos = eventos;
    }
    
    public TipoUsuario getTipoUsuario() {
    	return tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
    	this.tipoUsuario = tipoUsuario;
    }
    
    public List<Evento> getEventos() {
    	return eventos;
    }
    
// EVENTOS

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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", guardarropas=" + guardarropas + ", tipoUsuario=" + tipoUsuario
				+ ", listaNegraAtuendos=" + listaNegraAtuendos + ", eventos=" + eventos + ", sensibilidad="
				+ sensibilidad + ", nombre=" + nombre + "]";
	}
    
}

/* Asistir a evento ( de mi lista )
PASOS)
1)Ver si de mi lista de eventos tengo uno hoy                                          PARA HACER        (Metodo de usuario) IF( Evento.date() = date() )
2)Si tengo uno, el evento me genera un atuendo                                         EVENTO GENERA         (Metodo de evento)  evento.generarAtuendo
3)Me lo notifica por wpp o mail                                                        PARA HACER         (Metodo de evento)
4)Genera el siguiente evento (segun su variable cada cuantos dias se repite)           OK         (Metodo de evento)
 */