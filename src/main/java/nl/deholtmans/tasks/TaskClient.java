package nl.deholtmans.tasks;

public class TaskClient {
    public static void main(String[] args) {
        String message = "one";
        Task task = TaskFactory.determineFactory( message);
        task.execute();
        message = "two";
        task = TaskFactory.determineFactory( message);
        task.execute();
    }
}
