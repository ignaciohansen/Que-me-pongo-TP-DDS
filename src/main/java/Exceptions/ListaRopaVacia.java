package Exceptions;

public class ListaRopaVacia extends Exception {
    public ListaRopaVacia(String mensaje){
        super(mensaje);
    }
    public ListaRopaVacia(){
        super("El guardarropa no puede completar un atuendo por falta de una prenda");
        System.out.println("El guardarropa no puede completar un atuendo porque falta alguna prenda");
    }
}
