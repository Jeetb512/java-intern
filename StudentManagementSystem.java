public static void main(String[] args) {
    boolean exit = false;

    while (!exit) {
        System.out.println("\n====== Student Record Management System ======");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> viewStudents();
            case 3 -> updateStudent();
            case 4 -> deleteStudent();
            case 5 -> {
                System.out.println("Exiting... Goodbye!");
                exit = true;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void addStudent() {
    System.out.print("Enter Student ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.print("Enter Student Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Marks: ");
    double marks = scanner.nextDouble();

    studentList.add(new Student(id, name, marks));
    System.out.println("Student added successfully.");
}

private static void viewStudents() {
    if (studentList.isEmpty()) {
        System.out.println("No records to show.");
    } else {
        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}

private static void updateStudent() {
    System.out.print("Enter ID of student to update: ");
    int id = scanner.nextInt();

    for (Student s : studentList) {
        if (s.getId() == id) {
            scanner.nextLine(); // consume newline
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double marks = scanner.nextDouble();

            s.setName(name);
            s.setMarks(marks);
            System.out.println("Record updated.");
            return;
        }
    }
    System.out.println("Student not found.");
}

private static void deleteStudent() {
    System.out.print("Enter ID of student to delete: ");
    int id = scanner.nextInt();

    for (Student s : studentList) {
        if (s.getId() == id) {
            studentList.remove(s);
            System.out.println("Student deleted successfully.");
            return;
        }
    }
    System.out.println("Student not found.");
}
