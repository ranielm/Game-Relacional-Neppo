package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleAnswerQuestion extends MultipleChoiceQuestion {

    private ArrayList<String> choices;
    private ArrayList<String> correctAnswers;

    /**
     * Contrói uma questão de escolha sem escolhas.
     */
    public MultipleAnswerQuestion(String vettedness) {
        super(vettedness);
        choices = new ArrayList<String>();
        correctAnswers = new ArrayList<String>();
    }

    /**
     * Adiciona uma resposta como escolha a essa questão.
     *
     * @param choice a escolha para adicionar
     * @param correct true se essa for a resposta correta, false caso contrário
     */
    public void setChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            // Converte choices.size() para string
            String choiceString = "" + choices.size();
            setAnswer(choiceString);
        }
    }
    
    public void setAnswer(String answer) {
        correctAnswers.add(answer);
    }
    
    public double checkQuestion(String answer) {
        
        String delims = "[ ]+";
        String[] tokens = answer.split(delims);
        
        ArrayList<String> answers = new ArrayList<String>(tokens.length);
        for (String s : tokens) {
            answers.add(s);
        }
        
        double totRightAnswers = correctAnswers.size();
        double totAnswers = tokens.length;
        double wrongAnswers = tokens.length;
        double grade = 0.0;
        
        for (int i = 0; i < answers.size(); i++) {
            for (int j = 0; j < correctAnswers.size(); j++) {
                if (answers.get(i).equals(correctAnswers.get(j))) {
                    grade += (1.0/totRightAnswers);
                    wrongAnswers -= 1.0;
                    
                }
            }
        }
        
        //Pontos para respostas que não eram corretas
        grade -= wrongAnswers*(1.0/totRightAnswers);
        
        /**
         * Se mais respostas estavam erradas do que corretas causando
         * uma grade negativa, o valor setado será 0.
         */
        if (grade<0.0){
            grade = 0.0;
        }
        
        return grade;
    }
    
    public String display(){

        String display = text+"\n";
        
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            display = display.concat(choiceNumber + ": " + choices.get(i)+"\n");
        }
        
        return display;
        
    }
}