package Exceptions;

public class SuperoLimiteDeGuardarropas extends Exception {

        public SuperoLimiteDeGuardarropas(){
            super("El usuario supero su limite de guardarropas, no es posible agregarlo");
            System.out.println("El usuario supero su limite de guardarropas, no es posible agregarlo");
        }
    }


