import java.util.*;

public class Lesson2 {

    public static class PhoneDirectory {
        private Map<String, List<String>> directory;

        public PhoneDirectory() {
            directory = new HashMap<>();
        }

        public void add(String surname, String phoneNumber) {
            List<String> phones = directory.get(surname);
            if (phones == null) {
                phones = new ArrayList<>();
                directory.put(surname, phones);
            }
            phones.add(phoneNumber);
        }

        public List<String> get(String surname) {
            List<String> phones = directory.get(surname);
            if (phones == null) {
                return new ArrayList<>();
            }
            return new ArrayList<>(phones);
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Иванов", "123-45-67");
        phoneBook.add("Петров", "765-43-21");
        phoneBook.add("Сидоров", "111-22-33");
        phoneBook.add("Иванов", "987-65-43");
        phoneBook.add("Иванов", "555-44-33");

        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Телефоны Кузнецова: " + phoneBook.get("Кузнецов"));
    }
}