import java.util.Set;

public class Usuario{
    private Set<Guardarropa> guardarropas;

    public Usuario(Set<Guardarropa> guardarropas) {
        this.guardarropas = guardarropas;
    }

    public void setGuardarropas(Set<Guardarropa> guardarropas) {
        this.guardarropas = guardarropas;
    }

    public Set<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public void generarAtuendo(Guardarropa guardarropa,Generador generador) {
        generador.generarAtuendoGR(guardarropa);
    }
}