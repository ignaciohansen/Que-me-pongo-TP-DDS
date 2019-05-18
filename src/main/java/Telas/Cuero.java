package Telas;

public class Cuero extends Tela {

    public Cuero() {
    }
   @Override
    public Boolean incompatible(String tipoDePrenda){
        return ( tipoDePrenda.equals("remera"));
    }
}

