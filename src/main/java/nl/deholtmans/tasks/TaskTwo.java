package nl.deholtmans.tasks;

public class TaskTwo extends Task {
    TaskTwo(String message) {
        super(message);
    }
    public void executeTask() {
        System.out.println( "Execute/Two: " + message);
    }
}
