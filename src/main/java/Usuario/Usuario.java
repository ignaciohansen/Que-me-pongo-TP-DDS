package Usuario;

import Eventos.Evento;
import Exceptions.MismoGuardarropas;
import Exceptions.SuperoLimiteDeGuardarropas;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Generador.Generador;


import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario{
    private List<Guardarropa> guardarropas;
    private TipoUsuario tipoUsuario;
    private List<Evento> eventos;

    public Usuario(TipoUsuario tipoUsuario){
        this.guardarropas = new ArrayList<Guardarropa>();
        this.eventos = new ArrayList<Evento>();
        this.tipoUsuario = tipoUsuario;
    }

    public void agregarUnGuardarropas(Guardarropa guardarropa) throws MismoGuardarropas, SuperoLimiteDeGuardarropas {

        //VER ESTA IMPLEMENTACION PARA NO REPETIR GUARDARROPAS EN USUARIOS, ES LA MISMA QUE ROPA Y GUARDARROPA

        if(guardarropa.perteneceAUsuario){
        throw new MismoGuardarropas("El guardarropa ya esta asignado a un usuario");
        }else{
        tipoUsuario.agregarGuardarropa(guardarropas,guardarropa);

        //guardarropas.add(guardarropa);
        guardarropa.perteneceAUsuario =  true;
        }

    }

    public int cantidadDeGuardarropas(){
       return guardarropas.size();
    }


    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public Atuendo generarAtuendo(Guardarropa guardarropa) {
        Generador generador = new Generador();
        return generador.generarAtuendoGR(guardarropa);
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
        return generador.generarAtuendos(this.guardarropas);
    }
}