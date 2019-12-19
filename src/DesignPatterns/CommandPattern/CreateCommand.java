package DesignPatterns.CommandPattern;

/**
 * 具体命令类
 */
public class CreateCommand extends AbstractCommand{

    private BoardScreen boardScreen;

    public CreateCommand() {
        boardScreen = new BoardScreen();
    }

    @Override
    public void execute() {
        boardScreen.create();
    }
}
