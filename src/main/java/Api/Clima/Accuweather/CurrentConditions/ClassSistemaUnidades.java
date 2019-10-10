package Api.Clima.Accuweather.CurrentConditions;

public class ClassSistemaUnidades {
    private double Value;
    private String Unit;
    private int UnitType;


    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public String getUnit() { return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }

}
