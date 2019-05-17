public interface Tela {
    Boolean incompatible(String tipoDePrenda);
}

class Cuero implements Tela{

    public Boolean incompatible(String tipoDePrenda){
        return ( tipoDePrenda.equals("remera") || tipoDePrenda.equals("pantalon"));
    }
}

class Seda implements Tela{

    public Boolean incompatible(String tipoDePrenda){
        return ( tipoDePrenda.equals("campera"));
    }
}