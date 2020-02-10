package dagger_atm;

import dagger.Binds;
import dagger.Module;

@Module
abstract class HelloWorldModule {
    @Binds
    abstract Command helloWorlCommand(HelloWorldCommand command);
}