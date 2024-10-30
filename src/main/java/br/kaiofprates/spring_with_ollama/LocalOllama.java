package br.kaiofprates.spring_with_ollama;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class LocalOllama {

    private static final String LOCALHOST = "http://localhost:11434";
    private static final String MODEL = "llama3:8b-instruct-q4_1";

    public static void main(String[] args) {

        RulloBoard rulloBoard = new RulloBoard(4);

        var model = connectModel(MODEL);
        String prompt = String.format("Resolva esse quebra cabeças matematico chamado Rullo, \r\n" + //
                "voce deve escolher os numeros que somados componham a seguinte regra:\r\n" + //
                " %s \r\n" + //
                " \r\n" + //
                " \r\n" + //
                " esse é o tabuleiro \n%s", rulloBoard.printSums(rulloBoard.getSolution()),
                rulloBoard.printBoard(rulloBoard.getBoard()));

        System.out.println(prompt);
        System.out.println(rulloBoard.printBoard(rulloBoard.getSolution()));

        var result = model.generate(prompt);

        System.out.println(result);

    }

    private static ChatLanguageModel connectModel(String modelname) {
        return OllamaChatModel.builder()
                .baseUrl(LOCALHOST)
                .modelName(modelname)
                .build();
    }

}
