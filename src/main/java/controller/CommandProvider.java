package controller;

import command.command_class.*;
import command.command_inerf.Command;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    final private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put("CREATE", new Create());
        commands.put("DELETE", new Delete());
        commands.put("GET_ALL", new GetAll());
        commands.put("SEARCH_ID", new SearchID());
        commands.put("SEARCH_TWO_PARAM", new SearchTwoParam());
        commands.put("REGISTRATION", new RegistrationUser());
        commands.put("INPUT", new InputUser());
        commands.put("GET_ALL_USER", new GetAllUser());
        commands.put("DELETE_USER", new DeleteUser());
        commands.put("SEARCH_USER_ID", new SearchIDUser());
        commands.put("ALL_USER", new GetAllUser());
        commands.put("CHANGER_CAR", new ChangeCar());
        commands.put("CHANGER_USER_PASS", new ChangePassUser());

    }

    Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
