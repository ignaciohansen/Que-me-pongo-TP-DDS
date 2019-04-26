
public class Prenda {
    private color colorPrimario;
    private color colorSecundario;
    private String tipoDePrenda;
    private categoriaPrenda categoria;

    public Prenda(color colorPrimario, color colorSecundario, String tipoDePrenda,categoriaPrenda categoria) throws Exception {
        this.colorPrimario = colorPrimario;
        this.tipoDePrenda = tipoDePrenda;
        this.categoria = categoria;
        if (colorPrimario.equals(colorSecundario)) {
            throw new Exception("El color secundario es el mismo que el primario");
        } else {
            this.colorSecundario = colorSecundario;
        }
    }

    public color getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(color colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public String getTipoDePrenda() {
        return tipoDePrenda;
    }

    public void setTipoDePrenda(String tipoDePrenda) {
        this.tipoDePrenda = tipoDePrenda;
    }

    public categoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(categoriaPrenda categoria) {
        this.categoria = categoria;
    }

    enum color {Rojo, Verde, Azul, Negro, Blanco, Gris, Amarillo, Marron, Rosa, Violeta, Celeste}

    ;

    enum categoriaPrenda {ParteSuperior, ParteInferior, Calzado, Accesorio}

    ;
}




