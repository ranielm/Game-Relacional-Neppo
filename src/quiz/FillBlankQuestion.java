package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class FillBlankQuestion extends Question {

    private ArrayList<String> correctAnswers;

    public FillBlankQuestion(String vettedness) {
        super(vettedness);
        correctAnswers = new ArrayList<String>();
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
        double grade = 0.0;

        for (int i = 0; i < answers.size(); i++) {
            if (i < correctAnswers.size()) {
                if (answers.get(i).equals(correctAnswers.get(i))) {
                    grade += (1.0 / totRightAnswers);
                }
            }

        }

        return grade;
    }
    
    public String display() {
        return text;
    }

}