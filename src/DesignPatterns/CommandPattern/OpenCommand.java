package DesignPatterns.CommandPattern;

/**
 * 具体命令类
 */
public class OpenCommand extends AbstractCommand {

    private BoardScreen boardScreen;

    public OpenCommand() {
        boardScreen = new BoardScreen();
    }

    @Override
    public void execute() {
        boardScreen.open();
    }
}
