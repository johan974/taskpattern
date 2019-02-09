package nl.deholtmans.tasks;

public class TaskOne extends Task {
    TaskOne(String message) {
        super(message);
    }
    public void executeTask() {
        System.out.println( "Execute/One: " + message);
    }
}
