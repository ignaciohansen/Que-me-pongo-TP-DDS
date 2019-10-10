package Entities.Exceptions;

public class TelaIncompatible extends Exception {
    public TelaIncompatible(){
        super("La tela es incompatible con el tipo de prenda");
        System.out.println("La tela es incompatible con el tipo de prenda");
    }
}
