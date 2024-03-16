package src.usecases.ui.menu;

import src.usecases.interfaces.IUseCase;
import src.usecases.ui.*;
import src.usecases.ui.prompt.AskForOptionMenuUseCase;
import src.usecases.ui.prompt.PromptForStringInputUseCase;
import src.validations.Option;

import java.util.HashMap;
import java.util.Scanner;

public class ShowDeleteBookOrNovelMenuUseCase implements IUseCase<Object, Object>{
    @Override
    public Object execute(Object value) {
        return null;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, IUseCase<Object, Object>> updateBookOrNovelUseCases = new HashMap<>();
        updateBookOrNovelUseCases.put(1, new ShowDeleteBookMenuUseCase());
        updateBookOrNovelUseCases.put(2, new ShowDeleteNovelMenuUseCase());
        updateBookOrNovelUseCases.put(3, new ShowAdministratorMenuUseCase());
        updateBookOrNovelUseCases.put(0, new ExitProgramUseCase());
        do {
            String option = new AskForOptionMenuUseCase().execute("""
                     _______________________________________________________________

                    Eliminar libro o novela
                                
                    ¿Qué deseas eliminar?
                                
                    1 Eliminar libro
                    2 Eliminar novela
                                
                    3 Ir al menú de atrás
                    0 Terminar programa
                     
                     """);
            if (Option.isValid(option, 3)) {
                int validatedOption = Integer.parseInt(option);
                updateBookOrNovelUseCases.get(validatedOption).execute();
            } else {
                new PromptForStringInputUseCase().execute("""
                        _______________________________________________________________


                        Ha ingreso un valor incorrecto. El valor debe estar entre las
                        opciones mostradas.
                                       
                        """, scanner);
            }
        } while (true);
    }

    @Override
    public Object execute(Object firstValue, Object secondValue) {
        return null;
    }
}

