package package1;

import java.io.Serializable;

public class PersonalInfo implements Serializable {
    private String name;
    private String roll;
    private String registration;
    private String nameOfFather;
    private String nameOfMother;
    private String dateOfBirth;
    private String result;

    public PersonalInfo(){
        
    }

    public PersonalInfo(String name, String roll, String registration, String nameOfFather, String nameOfMother, String dateOfBirth, String result) {
        this.name = name;
        this.roll = roll;
        this.registration = registration;
        this.nameOfFather = nameOfFather;
        this.nameOfMother = nameOfMother;
        this.dateOfBirth = dateOfBirth;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getRegistration() {
        return registration;
    }

    public String getNameOfFather() {
        return nameOfFather;
    }

    public String getNameOfMother() {
        return nameOfMother;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setRegistration(String Registration) {
        this.registration = Registration;
    }

    public void setNameOfFather(String nameOfFather) {
        this.nameOfFather = nameOfFather;
    }

    public void setNameOfMother(String nameOfMother) {
        this.nameOfMother = nameOfMother;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
