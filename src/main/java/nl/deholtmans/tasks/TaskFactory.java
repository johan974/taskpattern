package nl.deholtmans.tasks;

class TaskFactory {
    static Task determineFactory( String message) {
        switch( message) {
            case "one":
                return new TaskOne( message);
            case "two":
                return new TaskTwo( message);
            default:
                throw new RuntimeException( "Invalid message: " + message);
        }
    }
}
