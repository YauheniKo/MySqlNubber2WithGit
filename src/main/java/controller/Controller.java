package controller;


import command.command_exception.CommandException;
import command.command_inerf.Command;

import javax.servlet.http.HttpServlet;

public class Controller  {

    private final CommandProvider provider = new CommandProvider();

    public String doAction(String request) {
        String commandName;
        String[] mas = request.split(", ");
        commandName = mas[0];

        String response=null;
        try {
            Command command = provider.getCommand(commandName);
            response = command.execute(request);

        } catch (CommandException | NullPointerException e) {

            response="Ошибка";
        }
        return response;

    }
}
