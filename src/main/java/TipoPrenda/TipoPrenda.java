package TipoPrenda;

public abstract class TipoPrenda {

    private String suTipo;
    private int CapaDePrenda = 1;
    private int nivelDeAbrigo = 0;

    public String getSuTipo() {
        return suTipo;
    }

    public int getCapaDePrenda() {
        return CapaDePrenda;
    }

    public int getNivelDeAbrigo() {
        return nivelDeAbrigo;
    }

}
