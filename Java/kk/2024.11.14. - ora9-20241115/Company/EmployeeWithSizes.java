import java.time.LocalDate;

public class EmployeeWithSizes extends Employee{

    private int shoeSize;
    private int heightInCm;

    public EmployeeWithSizes(int id, String name, LocalDate birtDate) throws WrongBirthDateException{
        super(id, name, birtDate);
    }

    public EmployeeWithSizes(int id, String name, LocalDate birtDate, String nickName) throws WrongBirthDateException{
        super(id, name, birtDate, nickName);
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) throws ShoeSizeException {
        if(shoeSize > 50 || shoeSize < 10){
            throw new ShoeSizeException("The shoe size should be between 10 and 50: " + shoeSize);
        }
        this.shoeSize = shoeSize;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) throws HeightException {
        if(heightInCm > 300 || heightInCm < 20){
            throw new HeightException("The height should be between 20 and 300: " + heightInCm);
        }
        this.heightInCm = heightInCm;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeWithSizes [shoeSize=");
        builder.append(shoeSize);
        builder.append(", heightInCm=");
        builder.append(heightInCm);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
