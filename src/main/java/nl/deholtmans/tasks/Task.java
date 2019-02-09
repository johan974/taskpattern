package nl.deholtmans.tasks;

abstract class Task {
    String message;
    private int worklog = 1;

    Task(String message) {
        this.message = message;
    }

    abstract void executeTask();

    private void preparation() {
        System.out.println( "Preparation");
    }
    private void getWorklog() {
        System.out.println( "Get worklog: " + worklog);
    }

    void execute() {
        preparation();
        getWorklog();
        executeTask();
        finalisation();
    }
    private void finalisation() {
        System.out.println( "Finalization");
    }
}
