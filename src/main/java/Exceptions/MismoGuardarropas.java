package Exceptions;

public class MismoGuardarropas extends Exception {
    public MismoGuardarropas(String mensaje){
        super(mensaje);
    }
    public MismoGuardarropas(){
        super("El guardarropas ya esta asigando");
        System.out.println("El guardarropas ya esta asigando");
    }
}
