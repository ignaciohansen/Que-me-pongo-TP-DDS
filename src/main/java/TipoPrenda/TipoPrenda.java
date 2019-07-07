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

    public void setSuTipo(String suTipo) {
        this.suTipo = suTipo;
    }

    public void setCapaDePrenda(int capaDePrenda) {
        CapaDePrenda = capaDePrenda;
    }

    public void setNivelDeAbrigo(int nivelDeAbrigo) {
        this.nivelDeAbrigo = nivelDeAbrigo;
    }

    public boolean suNivelDeCapaEs(int nivelObjetivo){
        return nivelObjetivo == this.getCapaDePrenda();
    }
}
