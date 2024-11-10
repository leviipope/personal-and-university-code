package org.types;

public class Bicycle extends Vehicle{
    int size;

    public Bicycle(String registrationNumber){
        super(registrationNumber, 2);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bicycle{");
        sb.append("size=").append(size);
        sb.append(", id='").append(id).append('\'');
        sb.append(", numberOfWheels=").append(numberOfWheels);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
