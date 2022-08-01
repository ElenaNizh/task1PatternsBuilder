public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(5)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        Person personWithoutAge = new PersonBuilder()
                .setName("Ольга")
                .setSurname("Сидорова")
                .setAddress("Казань")
                .build();
        System.out.println("У " + personWithoutAge.getName() + " есть адрес? - " +
                personWithoutAge.hasAddress());
        System.out.println(personWithoutAge);

        Person personWithoutAddress = new PersonBuilder()
                .setName("Андрей")
                .setSurname("Козлов")
                .setAge(35)
                .build();
        personWithoutAddress.happyBirthday();
        System.out.println("У " + personWithoutAddress.getName() + " есть адрес? - " +
                personWithoutAddress.hasAddress());
        System.out.println(personWithoutAddress);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}