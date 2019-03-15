package nl.deholtmans.tasks;

import java.util.List;

abstract class Task {
    String message;
    private int worklog = 1;
    String sqlString = "";
    String sqlStatement = "";

    Task(String message) {
        this.message = message;
    }

    abstract void executeTask();
    abstract List<String> regels();

    private void preparation() {
        System.out.println( "Preparation");
    }
    private void getWorklog() {
        System.out.println( "Get worklog: " + worklog);
    }

    void execute() {
        preparation();
        sqlStatement = "Parsed SQL statement: " + sqlString;
        getWorklog();
        executeTask();
        finalisation();
    }
    private void finalisation() {
        System.out.println( "Finalization");
    }
}
