import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    //...
    private int age;
    private String address;

    public Person(String name, String surname) {
        //...
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {
        //...
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


//методы
    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    //Добавьте метод для получения полузаполненного билдера для ребёнка в класс Person
    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(surname);
        personBuilder.setAddress(address);
        return personBuilder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "}");

        if (age != 0) {
            sb.append(", age=" + age +
                    "}");
        }
        if (address != null) {
            sb.append(", address='" + address + '\'' +
                    "}");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Person.class)) {
            return false;
        }
        Person person = (Person) obj;
        return name.equals(person.name) && surname.equals(person.surname);
    }
}