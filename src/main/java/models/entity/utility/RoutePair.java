package models.entity.utility;

import java.util.Objects;

public class RoutePair {
    private int route0;
    private int route1;

    public RoutePair(int route0, int route1) {
        this.route0 = route0;
        this.route1 = route1;
    }

    @Override
    public String toString() {
        return "RoutePair{" +
                "route0=" + route0 +
                ", route1=" + route1 +
                '}';
    }

    //отредактированные equals and hashCode
    // чтобы можно было сравнивать/искать элементы, заданные в порядке 'задом-наперед'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutePair routePair = (RoutePair) o;
        return (route0 == routePair.route0 && route1 == routePair.route1)
                || (route1 == routePair.route0 && route0 == routePair.route1);
    }

    //переопределили хэш, чтобы вне зависимости от порядка
    //элементов в паре, хэш всегда быд одинаковым
    @Override
    public int hashCode() {
        return (Objects.hash(route0, route1) + Objects.hash(route1, route0)) / 2;
    }

    public int getRoute0() {
        return route0;
    }

    public void setRoute0(int route0) {
        this.route0 = route0;
    }

    public int getRoute1() {
        return route1;
    }

    public void setRoute1(int route1) {
        this.route1 = route1;
    }
}
