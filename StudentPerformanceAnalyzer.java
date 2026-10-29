import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    int getTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double getAverage() {
        return (double) getTotal() / marks.length;
    }

    String getGrade() {
        double average = getAverage();

        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }
}

public class StudentPerformanceAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
      System.out.println("================================");
        System.out.println("   STUDENT PERFORMANCE ANALYZER");
        System.out.println("================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                System.out.print(
                    "Enter marks for subject " + (j + 1) + ": "
                );

                marks[j] = sc.nextInt();
            }
          sc.nextLine();

            students[i] = new Student(name, marks);
        }

        Arrays.sort(
            students,
            Comparator.comparingDouble(Student::getAverage)
                      .reversed()
        );

        System.out.println("\n========== LEADERBOARD ==========");

        System.out.printf(
            "%-5s %-15s %-10s %-10s %-10s%n",
            "Rank", "Name", "Total", "Average", "Grade"
        );

        System.out.println("----------------------------------------------");

        for (int i = 0; i < n; i++) {

            Student s = students[i];

            System.out.printf(
                "%-5d %-15s %-10d %-10.2f %-10s%n",
                i + 1,
                s.name,
                s.getTotal(),
                s.getAverage(),
                s.getGrade()
            );
        }

        System.out.println("\n================================");
        System.out.println("Analysis completed successfully!");
        System.out.println("================================");

        sc.close();
    }
}

