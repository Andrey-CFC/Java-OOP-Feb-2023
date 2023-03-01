package L03Encapsulation.P03ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
                this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age<1){
            throw new IllegalArgumentException("Age must not be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary(double bonus) {
        double realBonus = bonus;
        if (age < 30) {
            setSalary(getSalary() + (getSalary() * bonus / 200));
        } else {
            setSalary(getSalary() + (getSalary() * bonus / 100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", this.firstName, this.lastName, this.salary);
    }
}
