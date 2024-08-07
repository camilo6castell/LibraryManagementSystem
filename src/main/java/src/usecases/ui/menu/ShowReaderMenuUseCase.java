package src.usecases.ui.menu;

import src.usecases.interfaces.IUseCase;
import src.usecases.ui.*;
import src.usecases.ui.prompt.PromptForIntegerInputUseCase;
import src.usecases.ui.prompt.PromptForStringInputUseCase;
import src.validations.IsValidMenuOption;

import java.util.HashMap;
import java.util.Scanner;

public class ShowReaderMenuUseCase implements IUseCase<Object, Object> {
    @Override
    public Object execute(Object value) {
        return null;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, IUseCase<Object, Object>> assistantMenuUseCases = new HashMap<>();
        assistantMenuUseCases.put(1, new ShowBooksOrNovelsAvailableToBorrowMenuUseCase());
        assistantMenuUseCases.put(2, new ShowByAuthorAllAvailableTextsInTheLibraryMenuUseCase());
        assistantMenuUseCases.put(3, new ShowTextLoanHistoryMenuUseCase());
        assistantMenuUseCases.put(4, new ShowMainMenuUseCase());
        assistantMenuUseCases.put(0, new ExitProgramUseCase());
        do {
            Integer choseOption = new PromptForIntegerInputUseCase().execute("""
                    _______________________________________________________________

                    Bienvenido lector
                                                        
                    ¿Qué deseas hacer?
                                                        
                    1 Listar libros o novelas disponibles para prestar
                    2 Listar por autor todos los textos en la biblioteca
                    
                    3 Ver historial de peticiones de textos
                                                     
                    4 Cerrar sesión
                    0 Terminar programa
                    
                    Digite el número de la opción deseada:\s""", scanner);
            if (IsValidMenuOption.execute(choseOption, 4)) {
                assistantMenuUseCases.get(choseOption).execute();
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
