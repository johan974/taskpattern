package nl.deholtmans.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskOne extends Task {
    TaskOne(String message) {
        super(message);
        sqlString = "TaskOne SQL string";
    }
    public void executeTask() {
        System.out.println( "Execute/One: " + message);
    }

    @Override
    List<String> regels() {
        return Arrays.asList("One:1", "One:2", "One:3");
    }
}
