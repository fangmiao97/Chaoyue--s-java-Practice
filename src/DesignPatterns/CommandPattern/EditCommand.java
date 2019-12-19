package DesignPatterns.CommandPattern;

public class EditCommand extends AbstractCommand {

    private BoardScreen boardScreen;

    public EditCommand() {
        boardScreen = new BoardScreen();
    }

    @Override
    public void execute() {
        boardScreen.edit();
    }
}
