package dagger_atm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger_atm.Command;
import dagger_atm.Command.Status;

final class CommandRouter {
    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    CommandRouter(Command command) {
        commands.put(command.key(), command);
    }
    
    Status route(String input) {
        List<String> splitInput = split(input);

        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey);

        if (command == null) {
            return invalidCommand(input);
        }

        Status status = command.handleInput(splitInput.subList(1, splitInput.size()));

        if (status == Status.INVALID) {
            System.out.println(commandKey + ": Invalid Arguments");
        }

        return status;
    }
    
    private Status invalidCommand(String input) {
        System.out.println(String.format("Couldn't understand \"%s\". Pleasr Try again.", input));
        return Status.INVALID;
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.trim().split("\\s+"));
    }
}