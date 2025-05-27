import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class student {
    private String name;
    private LocalDate dob;

    public student(String name, String dobStr) {
        this.name = name;
        DateTimeFormatter formatter;
        if (dobStr.contains("-") && dobStr.length() == 10 && dobStr.charAt(2) == '-') {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        this.dob = LocalDate.parse(dobStr, formatter);
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        Period age = Period.between(dob, LocalDate.now());
        System.out.println("Age: " + age.getYears() + " years");
    }

    public static void main(String[] args) {
        student s1 = new student("Alice", "2004-08-15"); // or "15-08-2004"
        s1.displayInfo();
    }
}