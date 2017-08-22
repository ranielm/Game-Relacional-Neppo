package quiz;

interface Gradable{
    public boolean gradeQuestion();
}

abstract public class Question {
    
    protected String text;
    protected String answer;
    protected String vettedOrTrial;
    
    /**
     * Constrói a questão com o enunciado e a resposta vazia
     */
    public Question(String vettedness){
        text = "";
        answer = "";
        vettedOrTrial = vettedness;
    }
    
    
    /**
     * Seta o enunciado da questão.
     * @param questionText o enunciado dessa questão
     */
    public void setText(String questionText){
        text = questionText;
    }
    
    /**
     * Seta a(s) resposta(s) correta(s)
     */
    public abstract void setAnswer(String answer);
    
//    /**
//     * Checa as resposta(s)
//     * @return true para correta, false caso contrário
//     */
//    public abstract double checkAnswer(String answer);
    
    /**
     * Retorna o enunciado da questão
     */
    public String display() {
        return text;
    }
    
    public boolean gradeQuestion(){
        if (vettedOrTrial.equals("vetted")){
            return true;
        } else {
            return false;
        }
    }
    
    public abstract double checkQuestion(String answer);  
}