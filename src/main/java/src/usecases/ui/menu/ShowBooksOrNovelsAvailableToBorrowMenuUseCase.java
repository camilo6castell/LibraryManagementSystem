package src.usecases.ui.menu;

import src.usecases.interfaces.IUseCase;
import src.usecases.ui.ExitProgramUseCase;
import src.usecases.ui.prompt.PromptForIntegerInputUseCase;
import src.usecases.ui.prompt.PromptForStringInputUseCase;
import src.validations.IsValidMenuOption;

import java.util.HashMap;
import java.util.Scanner;

public class ShowBooksOrNovelsAvailableToBorrowMenuUseCase implements IUseCase<Object, Object> {
    @Override
    public Object execute(Object value) {
        return null;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, IUseCase<Object, Object>> addBookOrNovelUseCases = new HashMap<>();
        addBookOrNovelUseCases.put(1, new ShowBooksAvailableToBorrowMenuUseCase());
        addBookOrNovelUseCases.put(2, new ShowNovelsAvailableToBorrowMenuUseCase());
        addBookOrNovelUseCases.put(3, new ShowReaderMenuUseCase());
        addBookOrNovelUseCases.put(0, new ExitProgramUseCase());
        do {
            Integer chosenOption = new PromptForIntegerInputUseCase().execute("""
                    _______________________________________________________________

                    Libros o novelas disponibles
                                     
                    ¿Qué deseas listar?
                                     
                    1 listar libros diponibles
                    2 listar novelas disponibles
                                   
                    3 Ir al menú de atrás
                    0 Terminar programa
                     
                    Digite el número de la opción deseada:\s""", scanner);
            if (IsValidMenuOption.execute(chosenOption, 3)) {
                addBookOrNovelUseCases.get(chosenOption).execute();
            } else {
                new PromptForStringInputUseCase().execute("""
                        _______________________________________________________________


                        Ha ingreso un valor incorrecto. El valor debe estar entre las
                        opciones mostradas.
                                       
                        Ingresa cualquier valor para volver a intentarlo:\s""", scanner);
            }
        } while (true);
    }
    @Override
    public Object execute(Object firstValue, Object secondValue) {
        return null;
    }
}
