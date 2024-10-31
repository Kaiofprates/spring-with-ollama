package br.kaiofprates.spring_with_ollama;

import java.time.Duration;

import br.kaiofprates.spring_with_ollama.util.BoardUtils;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class LocalOllama {

    private static final String LOCALHOST = "http://localhost:11434";
    private static final String MODEL = "llama3:8b-instruct-q4_1";
 

    public static void main(String[] args) {


        RulloBoard rulloBoard = new RulloBoard(3);

        var model = connectModel(MODEL);
        String prompt = String.format(
            "You are an experienced mathematician with a love for puzzles and challenges. Today, you'll be solving a game called Rullo. " +
            "In Rullo, your objective is to adjust numbers on a grid so that the sum of each row and column exactly matches a given target. " +
            "To do this, change only specific numbers to 0 where needed, ensuring the sum doesn’t exceed the target for any row or column. " +
            "You don’t need to add new numbers; simply toggle existing numbers to 0 as needed.\n\n" +
            "Here’s the puzzle setup:\n\n" +
            "\n%s\n\n" +
            "\n%s\n\n" +
            "Please provide the final board configuration, with selected numbers changed to 0 to meet the target sums in each row and column.",
            BoardUtils.printSums(rulloBoard.getSolution()),
            BoardUtils.printBoard(rulloBoard.getBoard())
        );
        
        
         System.out.println(prompt);

         System.out.println(String.format("Solução: %s", BoardUtils.printBoard(rulloBoard.getSolution())));


        //generateBoard();

        var result = model.generate(prompt);

         System.out.println(result);
    }

    private static ChatLanguageModel connectModel(String modelname) {

        final var timeout = Duration.ofMinutes(3);

        return OllamaChatModel.builder()
                .baseUrl(LOCALHOST)
                .modelName(modelname)
                .timeout(timeout)
                .build();
    }
}
