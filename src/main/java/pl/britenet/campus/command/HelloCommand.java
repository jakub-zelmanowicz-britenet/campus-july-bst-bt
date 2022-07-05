package pl.britenet.campus.command;

import pl.britenet.campus.Constants;

public class HelloCommand extends Command {

    public HelloCommand() {
        super(Constants.COMMAND_HELLO);
    }

    @Override
    public void execute() {
        System.out.println("Hello World");
    }
}
