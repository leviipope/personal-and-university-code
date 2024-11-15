import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birtDate;
    private String nickName;

    public Person(String name, LocalDate birtDate) throws WrongBirthDateException {
        this.name = name;
        LocalDate lowerBirthDateBound = LocalDate.now().minusYears(65);
        LocalDate upperBirthDateBound = LocalDate.now().minusYears(18);
        if (birtDate.isAfter(lowerBirthDateBound) && birtDate.isBefore(upperBirthDateBound)){
            this.birtDate = birtDate;
        }
        else {
            throw new WrongBirthDateException("The age should be between 18 and 65: " + birtDate);
        }
    }

    public Person(String name, LocalDate birtDate, String nickName) throws WrongBirthDateException{
        this(name, birtDate);
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [name=");
        builder.append(name);
        builder.append(", birthDate=");
        builder.append(birtDate);
        builder.append(", nickName=");
        builder.append(nickName);
        builder.append("]");
        return builder.toString();
    }
}
