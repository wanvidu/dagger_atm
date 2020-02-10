package dagger_atm;

import java.util.List;

import javax.inject.Inject;

final class HelloWorldCommand implements Command {

    @Inject
    HelloWorldCommand() {
    }

    @Override
    public String key() {
        return "Hello";
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }

        System.out.println("World");

        return Status.HANDLED;
    }

}