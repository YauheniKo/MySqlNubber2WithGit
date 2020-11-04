package command.command_inerf;

import command.command_exception.CommandException;

public interface Command {

    String execute(String request) throws CommandException;

}
