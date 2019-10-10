package Api.Clima.Weatherbit.Current;

import java.util.List;

public class HeaderWeatherbit {
    private List<ClassData> data;
    private int count;

    public List<ClassData> getData() {
        return data;
    }

    public void setData(List<ClassData> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
