public class PersonBuilder {
    //...
    private String name;
    private String surname;
    private int age = 0;
    private String address;

    private Person person;

    public PersonBuilder() {

    }


    public PersonBuilder setName(String name) {
        if (name != null) {
            this.name = name;
            return this;
        } else {
            throw new IllegalStateException("Имя отсутствует");
        }
    }


    public PersonBuilder setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
            return this;
        } else {
            throw new IllegalStateException("Фамилия отсутствует");
        }

    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalStateException("Такой возраст не существует");
        }
    }

    public PersonBuilder setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || surname == null) {
            throw new IllegalStateException("Недостаточное количество данных");
        } else if (age >= 0 || address != null) {
            person = new Person(name, surname, age);
            person.setAddress(this.address);
            return person;
        } else {
            return person = new Person(name, surname);
        }
    }
}