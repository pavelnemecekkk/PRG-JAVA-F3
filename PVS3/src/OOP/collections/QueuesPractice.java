package OOP.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueuesPractice {
    public static void main(String[] args) {
        Queue<Employee> employees = new LinkedList<>();
        //pridani prvku do fronty:
        employees.add(new Employee("Jarmil", 600,42));
        employees.add(new Employee("Boris", 480,42));
        employees.add(new Employee("Lukáš", 450,42));
        employees.poll(); //dequeue , odstřelení
        //employees.offer(); enqueue, přidaní

        Queue<Task> tasks = new LinkedList<>();
        tasks.add(new Task("Exchange cables", 60));
        tasks.add(new Task("Update OS", 45));
        tasks.add(new Task("Install antivirus", 30));
        tasks.add(new Task("Replace hard drive", 120));
        tasks.add(new Task("Clean workstation", 20));
        tasks.add(new Task("Configure network", 90));
        tasks.add(new Task("Test hardware", 50));
        tasks.add(new Task("Set up printer", 25));
        tasks.add(new Task("Troubleshoot Wi-Fi", 35));
        tasks.add(new Task("Backup files", 75));
        tasks.add(new Task("Assemble PC", 150));
        tasks.add(new Task("Optimize performance", 40));
        tasks.add(new Task("Create user accounts", 15));
        tasks.add(new Task("Train new staff", 180));
        tasks.add(new Task("Remove malware", 55));
        tasks.add(new Task("Upgrade RAM", 25));
        tasks.add(new Task("Set up email client", 20));
        tasks.add(new Task("Reset passwords", 10));
        tasks.add(new Task("Patch security vulnerabilities", 80));
        tasks.add(new Task("Calibrate display", 30));

        while (!tasks.isEmpty() && !employees.isEmpty()) {
            Employee top = employees.peek();
            Task current = tasks.peek();

            System.out.println(top);
            System.out.println("Doing task: " + current.taskName + ", duration: " + current.taskCompleteTime);
            if (top.freeTime >= current.taskCompleteTime){
                // splní úkol za cas
                top.freeTime -= current.taskCompleteTime;
                //splní úkol, úkol jde ven z fronty úkolů
                tasks.poll();
                System.out.println(top.name + "did task, " + current.taskName);
            } else{
                employees.poll();
            }

        }
    }
}

class Employee{
    String name;
    int freeTime;
    int shoeSize;
    public Employee(String name, int freeTime, int shoeSize) {
        this.name = name;
        this.freeTime = freeTime;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return name + ", Free time left: " + freeTime;
    }
}

class Task{
    String taskName;
    int taskCompleteTime;

    public Task(String taskName, int taskCompleteTime) {
        this.taskName = taskName;
        this.taskCompleteTime = taskCompleteTime;
    }

}
