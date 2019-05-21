import Exceptions.MismoGuardarropas;

import java.util.ArrayList;
import java.util.List;

public class Usuario{
    private List<Guardarropa> guardarropas;

    public Usuario(){
        this.guardarropas = new ArrayList<Guardarropa>();
    }

    public Usuario(List<Guardarropa> guardarropas) {
        this.guardarropas = new ArrayList<Guardarropa>();
        this.guardarropas = guardarropas;
    }

    public void agregarMuchosGuardarropas(List<Guardarropa> guardarropas) {
        this.guardarropas = guardarropas;
    }

    public void agregarUnGuardarropas(Guardarropa guardarropa) throws Exceptions.MismoGuardarropas {



        //VER ESTA IMPLEMENTACION PARA NO REPETIR GUARDARROPAS EN USUARIOS, ES LA MISMA QUE ROPA Y GUARDARROPA

        if(guardarropa.perteneceAUsuario){
        throw new Exceptions.MismoGuardarropas("El guardarropa ya esta asignado a un usuario");
        }else{
        guardarropas.add(guardarropa);
        guardarropa.perteneceAUsuario = true;
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

    public List<Atuendo> generarAtuendos(){
        Generador generador = new Generador();
        return generador.generarAtuendos(this.guardarropas);
    }
}