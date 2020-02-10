package dagger_atm;

import dagger.Component;

@Component
public interface CommandRouterFactory {
    CommandRouter router();
}