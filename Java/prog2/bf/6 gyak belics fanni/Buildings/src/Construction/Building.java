package Construction;

import java.util.Objects;

public class Building {
    String name;
    String address;

    public Building(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Building{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return Objects.equals(name, building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
