package TipoPrenda;

import javax.swing.*;

public abstract class TipoPrenda {

    private String suTipo;
    private int CapaDePrenda = 1;
    private int nivelDeAbrigo = 0;
    private ImageIcon foto;

    public String getSuTipo() {
        return suTipo;
    }

    public int getCapaDePrenda() {
        return CapaDePrenda;
    }

    public int getNivelDeAbrigo() {
        return nivelDeAbrigo;
    }

    public ImageIcon getFoto() {
        return foto;
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

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public boolean suNivelDeCapaEs(int nivelObjetivo){
        return nivelObjetivo == this.getCapaDePrenda();
    }



}
