package Entities.Exceptions;

public class atuendoEnListaNegra extends Exception {
    public atuendoEnListaNegra(String mensaje){
        super(mensaje);
    }
    public atuendoEnListaNegra(){
        super("El atuendo no le gusta al usuario y ya se le fue ofrecido una vez, se rechaza");
        System.out.println("El atuendo no le gusta al usuario y ya se le fue ofrecido una vez, se rechaza");
    }
}
