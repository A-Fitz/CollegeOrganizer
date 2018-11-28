package app.collegeorganizer.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SleepDataCategory {
    private String name;
    private List<Stat> statList = new ArrayList<Stat>();
    private int color;

    public SleepDataCategory(String name, List<Stat> statList, int color) {
        this.name = name;
        this.statList = statList;
        this.color = color;
    }

    public SleepDataCategory(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stat> getStatList() {
        return statList;
    }

    public void setStatList(List<Stat> statList) {
        this.statList = statList;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleepDataCategory that = (SleepDataCategory) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(statList, that.statList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, statList);
    }
}
