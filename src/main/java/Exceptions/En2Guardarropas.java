package Exceptions;

public class En2Guardarropas extends Exception {
    public En2Guardarropas(String mensaje){
        super(mensaje);
    }
    public En2Guardarropas(){
        super("La prenda ya esta en un guardarropas");
        System.out.println("La prenda ya esta en un guardarropas");
    }
}
