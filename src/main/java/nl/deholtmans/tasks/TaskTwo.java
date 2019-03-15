package nl.deholtmans.tasks;

import java.util.Arrays;
import java.util.List;

public class TaskTwo extends Task {
    TaskTwo(String message) {
        super(message);
        sqlString = "TaskTwo SQL string";
    }
    public void executeTask() {
        System.out.println( "Execute/Two: " + message);
    }
    @Override
    List<String> regels() {
        return Arrays.asList("One:1", "One:2", "One:3");
    }
}
