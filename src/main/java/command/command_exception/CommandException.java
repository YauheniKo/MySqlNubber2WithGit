package command.command_exception;

public class CommandException extends Exception {


    public CommandException(){

    }
    public CommandException(Exception e){
        super(e);

    }
    public CommandException(String message){
        super(message);

    }
    public CommandException(String message, Exception e){
        super(message,e);

    }
}
