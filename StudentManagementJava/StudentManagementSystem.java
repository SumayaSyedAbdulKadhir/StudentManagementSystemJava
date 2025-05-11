import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    studentList.add(new Student(roll, name, dept));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    System.out.println("---- Student List ----");
                    for (Student s : studentList) {
                        s.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.rollNo == searchRoll) {
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student Not Found!");
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int deleteRoll = sc.nextInt();
                    Iterator<Student> iterator = studentList.iterator();
                    boolean removed = false;
                    while (iterator.hasNext()) {
                        Student s = iterator.next();
                        if (s.rollNo == deleteRoll) {
                            iterator.remove();
                            removed = true;
                            System.out.println("Student Deleted.");
                            break;
                        }
                    }
                    if (!removed) System.out.println("Student Not Found!");
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }
}
