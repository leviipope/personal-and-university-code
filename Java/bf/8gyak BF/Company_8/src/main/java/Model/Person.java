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
        StringBuilder builder = new StringBuilder();
        builder.append("Person [name=");
        builder.append(name);
        builder.append("; nickname=");
        if(nickname==null){
            builder.append("null");
        }else{
            builder.append(nickname);
        }
        builder.append("; birthDate=");
        builder.append(birthDate);
        builder.append("]");

        return builder.toString();
    }
}
