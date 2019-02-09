package nl.deholtmans.tasks;

public abstract class Task {
    String message;
    private int worklog;

    Task(String message) {
        this.message = message;
    }

    abstract void executeTask();

    private void preparation() {
        System.out.println( "Preparation");
    }
    private void getWorklog() {
        System.out.println( "Get worklog");
    }

    public void execute() {
        preparation();
        getWorklog();
        executeTask();
        finalisation();
    }
    private void finalisation() {
        System.out.println( "Finalization");
    }
}
