package dagger_atm;

import java.util.List;

public interface Command {
    String key();

    Status handleInput(List<String> input);

    enum Status {
        INVALID,
        HANDLED
    }
}