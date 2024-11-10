package Model;

import Exceptions.HeightException;
import Exceptions.ShoeSizeException;
import Exceptions.WrongBirthdatException;

import java.time.LocalDate;

public class EmployeeWithSizes extends Employee{
    int height;
    int shoeSize;

    public EmployeeWithSizes(int id, Department department, String name, LocalDate birthdate,
                             int height, int shoeSize)
            throws WrongBirthdatException, HeightException, ShoeSizeException {
        super(id, department, name, birthdate);
        if(height > 300 || height < 20){
            throw new HeightException("Height is wrong");
        }
        if(shoeSize > 50 || shoeSize < 10){
            throw new ShoeSizeException("ShoeSize is wrong");
        }
    }
}
