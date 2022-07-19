package pl.britenet.campus;

import pl.britenet.campus.command.Command;
import pl.britenet.campus.command.CommandService;
import pl.britenet.campus.command.HelloCommand;
import pl.britenet.campus.command.RetrieveProductsCommand;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.service.ProductService;
import pl.britenet.campus.service.UserService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        UserService userService = new UserService(databaseService);

        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelloCommand());
        commandService.registerCommand(new RetrieveProductsCommand(productService));

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Wprowadź komendę...");
            String command = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(command);
            oCommand.orElseThrow().execute();
        }
    }
}
