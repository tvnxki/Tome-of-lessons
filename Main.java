import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаём коллекцию студентов
        Set<Student> students = new HashSet<>();

        // Добавляем студентов с оценками
        students.add(new Student("Иван Иванов", "ФПиТ-12", 1, Map.of("Математика", 4, "Физика", 5, "Тестирование", 4)));
        students.add(new Student("Андрей Никитин", "ФПиТ-12", 1, Map.of("Математика", 3, "Физика", 3, "Тестирование", 2)));
        students.add(new Student("Алексей Сидоров", "ФПиТ-12", 2, Map.of("Математика", 5, "Физика", 4, "Тестирование", 5)));
        students.add(new Student("Анна Козлова", "ФПиТ-12", 2, Map.of("Математика", 2, "Физика", 2, "Тестирование", 3)));
        students.add(new Student("Сергей Новиков", "ФПиТ-12", 3, Map.of("Математика", 4, "Физика", 4, "Тестирование", 4)));
        students.add(new Student("Никита Никитин", "ФПиТ-12", 3, Map.of("Математика", 5, "Физика", 5, "Тестирование", 5)));

        System.out.println("\nсписок студентов");
        printAllStudents(students);

        System.out.println("\nср. балл студентов");
        printAverageGrades(students);

        System.out.println("\nотчисление студентов со ср. баллом < 3");
        removePoorStudents(students);

        System.out.println("\nперевод студентов со ср. баллом>= 3");
        promoteStudents(students);

        System.out.println("\nфинальный список студентов");
        printAllStudents(students);

        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);
    }

    public static void removePoorStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
                count++;
                System.out.println("отчислен: " + student.getName() + " (ср.балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }

        if (count == 0) {
            System.out.println("  cтудентов с баллом < 3 нет");
        }
    }

    public static void promoteStudents(Set<Student> students) {
        int count = 0;

        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                count++;
                System.out.println("*" + student.getName() + ": " + oldCourse + " курс → " + student.getCourse() + " курс" + " (ср.балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }

        if (count == 0) {
            System.out.println("  Нет студентов для перевода");
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("студенты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  • " + student.getName() +
                        " (группа: " + student.getGroup() +
                        ", ср.балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("  студентов на " + course + " курсе нет");
        }
    }

    public static void printAllStudents(Set<Student> students) {
        if (students.isEmpty()) {
            System.out.println("  список студентов пуст");
            return;
        }

        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparingInt(Student::getCourse));

        for (Student student : sortedList) {
            System.out.println("  • " + student);
        }
    }

    public static void printAverageGrades(Set<Student> students) {
        for (Student student : students) {
            System.out.printf("  %s: %.2f%n",
                    student.getName(), student.getAverageGrade());
        }
    }
}

class Student {

    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getGrades() {
        return new HashMap<>(grades);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String toString() {
        return String.format("%s (гр.%s, %d курс, ср.балл: %.2f)",
                name, group, course, getAverageGrade());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}