
public class Prenda {
    private String colorPrimario;
    public String colorSecundario;
    private String tipoDePrenda;

    public Prenda(String colorPrimario, String tipoDePrenda) {
        this.colorPrimario = colorPrimario;
        this.tipoDePrenda = tipoDePrenda;
    }

                                        // Pruebas //
public boolean sonDistintoTipo(Prenda unaPrenda)
{
return  this.tipoDePrenda != unaPrenda.tipoDePrenda;
}

public void setColorSecundario(String colorSecundario){
        if(colorSecundario != this.colorPrimario) this.colorSecundario = colorSecundario;
}

    public String getColorSecundario() {
        return colorSecundario;
    }
}
                                        // Pruebas //
