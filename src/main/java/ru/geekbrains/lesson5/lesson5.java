package ru.geekbrains.lesson5;

public class lesson5 {
    public static void main(String[] args) {
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Ivanov Ivan", "Engineer","ivivan@mailbox.com", "892312311", 150000, 30);
        staff[1] = new Employee("Petrov Petr", "Cleaner","petr@mailbox.com", "892312312", 30000, 18);
        staff[2] = new Employee("Dmitriev Dmitry", "Manager","dmitry@mailbox.com", "892312313", 150000, 30);
        staff[3] = new Employee("Fedorov Fedr", "CEO","fedr@mailbox.com", "892312314", 1000000, 50);
        staff[4] = new Employee("Antonov Anton", "CAO","anton@mailbox.com", "892312315", 100000, 45);

        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40) staff[i].printInfo();
        }
        // или через toString()
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40) System.out.println(staff[i]);
        }
    }
}
