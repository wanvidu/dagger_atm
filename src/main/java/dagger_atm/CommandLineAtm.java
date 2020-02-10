/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dagger_atm;

import java.util.Scanner;

import dagger_atm.CommandRouter;

public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouterFactory commandRouterFactory= DaggerCommandRouterFactory.create();
        CommandRouter commandRouter = new CommandRouter();

        while (scanner.hasNextLine()) {
            commandRouter.route(scanner.nextLine());
        }

        scanner.close();
    }
}
