package src.usecases.ui.menu;

import src.usecases.book.AddBookUseCase;
import src.usecases.interfaces.IUseCase;
import src.usecases.ui.prompt.PromptForStringInputUseCase;

import java.util.Scanner;

public class ShowAddBookMenuUseCase implements IUseCase<Object, Object> {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        new AddBookUseCase().execute();
        new PromptForStringInputUseCase().execute("Ingrese cualquier valor para continuar: ", scanner);
        System.out.println();
    }
    @Override
    public Object execute(Object firstValue, Object secondValue) {
        return null;
    }

    @Override
    public Object execute(Object value) {
        return null;
    }
}
