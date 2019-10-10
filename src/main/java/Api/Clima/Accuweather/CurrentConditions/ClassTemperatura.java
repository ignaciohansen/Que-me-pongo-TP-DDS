package Api.Clima.Accuweather.CurrentConditions;

public class ClassTemperatura {
    private ClassSistemaUnidades Metric;
    private ClassSistemaUnidades Imperial;

    public ClassSistemaUnidades getMetric() {
        return Metric;
    }

    public void setMetric(ClassSistemaUnidades metric) {
        Metric = metric;
    }

    public ClassSistemaUnidades getImperial() {
        return Imperial;
    }

    public void setImperial(ClassSistemaUnidades imperial) {
        Imperial = imperial;
    }
}
