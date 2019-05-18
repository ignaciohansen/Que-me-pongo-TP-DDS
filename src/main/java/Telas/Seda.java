package Telas;

public class Seda extends Tela {

    @Override
    public Boolean incompatible(String tipoDePrenda){
        return ( tipoDePrenda.equals("campera"));
    }
}
