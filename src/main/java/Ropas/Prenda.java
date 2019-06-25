package Ropas;

import Telas.Tela;

public class Prenda {
    private Color colorPrimario;
    private Color colorSecundario;
    private String tipoDePrenda;
    private CategoriaPrenda categoria;
    private Tela tela;
    public Boolean estaEnGuardarropa = false;

    public Prenda(Color colorPrimario, Color colorSecundario, String tipoDePrenda,CategoriaPrenda categoria,Tela unaTela) throws Exception {
        this.colorPrimario = colorPrimario;
        this.tipoDePrenda = tipoDePrenda;
        this.categoria = categoria;
        setColorSecundario(colorSecundario);
        setTela(unaTela);
        //this.tela = unaTela;
    }

    public Color getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(Color colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario)throws Exception {
        if (!colorSecundario.equals(this.colorPrimario)) {
            this.colorSecundario = colorSecundario;
        } else{
            throw new Exception("El color secundario es el mismo que el primario");
        }
    }

    public String getTipoDePrenda() {
        return tipoDePrenda;
    }

    public void setTipoDePrenda(String tipoDePrenda) {
        this.tipoDePrenda = tipoDePrenda;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public void setTela(Tela tela) throws Exceptions.TelaIncompatible{
        if(tela.incompatible(this.tipoDePrenda)){
            throw new Exceptions.TelaIncompatible("La tela es incompatible con el tipo de prenda");
        } else this.tela = tela;
    }

    public Tela getTela() { return tela; }

    public enum Color {Rojo, Verde, Azul, Negro, Blanco, Gris, Amarillo, Marron, Rosa, Violeta, Celeste};

    public enum CategoriaPrenda {ParteSuperior, ParteInferior, Calzado, Accesorio};

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Prenda) {
            Prenda tmpPrenda = (Prenda) obj;
            return (this.tipoDePrenda == tmpPrenda.tipoDePrenda
                    && this.colorPrimario == tmpPrenda.colorPrimario
                    && this.colorSecundario == tmpPrenda.colorSecundario
                    && this.categoria.ordinal() == tmpPrenda.categoria.ordinal());
        }

        return false;
    }

    @Override
    public String toString() {
        return "Ropas.Prenda{" +
                "colorPrimario=" + colorPrimario +
                ", colorSecundario=" + colorSecundario +
                ", tipoDePrenda='" + tipoDePrenda + '\'' +
                ", categoria=" + categoria +
                ", tela=" + tela +
                ", estaEnGuardarropa=" + estaEnGuardarropa +
                '}';
    }
}