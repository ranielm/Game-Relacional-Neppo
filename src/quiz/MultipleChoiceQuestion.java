package quiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Uma questão com múltiplas escolhas.
 */
public class MultipleChoiceQuestion extends Question {

    private ArrayList<String> choices;
    private int correctAnswer;

    /**
     * Constrói uma questão de múltipla escolha sem escolhas.
     */
    public MultipleChoiceQuestion(String vettedness) {
        super(vettedness);
        choices = new ArrayList<String>();
    }

    /**
     * Adiciona uma resposta como opção à essa questão.
     *
     * @param choice a escolha para adicionar
     * @param correct true se a escolha for a correta, false caso contrário
     */
    public void setChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            // Converte choices.size() para string
            String choiceString = "" + choices.size();
            setAnswer(choiceString);
        }
    }

    /**
     * Seta a resposta correta. Um número na string.
     * @param answer Um número em uma string que corresponde ao lugar das respostas nas opções no arrayList
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
//    /**
//     * Pega a resposta do input
//     */
//    public boolean takeAnswer() {
//        String input;
//        System.out.println("Enter the number of the answer");
//        Scanner in = new Scanner(System.in); //Create new scanner for user input
//        input = in.nextLine();
//        return checkAnswer(input);
//    }

    public double checkQuestion(String answer) {
        answer = answer.replaceAll("\\s+","");
        if(this.answer.equals(answer)){
            return 1.0;
        } else {
            return 0.0;
        }
    }

    /**
     * Retorna uma string com uma questão com o enunciado e escolhas
     * @return string com enunciado e a escolha
     */
    public String display() {
        
        String display = text+"\n";
        
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            display = display.concat(choiceNumber + ": " + choices.get(i)+"\n");
        }
        
        return display;
    }
}