package pl.britenet.campus;

import pl.britenet.campus.command.Command;
import pl.britenet.campus.command.CommandService;
import pl.britenet.campus.command.HelloCommand;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelloCommand());

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Wprowadź komendę...");
            String command = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(command);
            oCommand.orElseThrow().execute();
        }
    }
}
