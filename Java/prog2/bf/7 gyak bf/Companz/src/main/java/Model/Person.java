package Model;

import Exceptions.WrongBirthdatException;

import java.time.LocalDate;

public class Person {
    String name;
    LocalDate birthDate;
    String nickname;

    public Person(String name, LocalDate birthDate) throws WrongBirthdatException {
        if(birthDate.isBefore(LocalDate.of(1965,1,1)) ||
            birthDate.isAfter(LocalDate.of(2018, 12, 31))){
            throw new WrongBirthdatException("Birthdate shall be between 1965 and 2018");
        }

        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name, LocalDate birthDate, String nickname) throws WrongBirthdatException {
        this(name, birthDate);
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
