package dagger_atm;

import java.util.List;

import javax.inject.Inject;

final class HelloWorldCommand implements Command {

    private final Outputter outputter;
    
    @Inject
    HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
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

        outputter.output("World!");

        return Status.HANDLED;
    }

}