package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import quiz.FillBlankQuestion;
import quiz.MultipleAnswerQuestion;
import quiz.MultipleChoiceQuestion;
import quiz.Question;

public class Quiz02 {

    private ArrayList<Question> questions;

    private double score = 0.0;
    private double vettedScore = 0.0;
    private double trialScore = 0.0;
    
    private int totalVetted = 0;
    private int totalTrial = 0;
    
    private int totalCorrectVetted = 0;
    private int totalIncorrectVetted = 0;
    
    private int totalCorrectTrial = 0;
    private int totalIncorrectTrial = 0;

    public Quiz02() {
        questions = new ArrayList<Question>();
    }

    /**
     * Cria as questões do quiz. Com um total de 07 questões.
     */
    public void createQuestions() {

        //Questão 1.
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion("vetted");
        question1.setText("Múltipla escolha: Qual o nível que sua equipe acredita que a boa relação entre as pessoas do grupo interfere no trabalho?");
        question1.setChoice("Alto", true);
        question1.setChoice("Baixo", false);
        question1.setChoice("Médio", false);
        question1.setChoice("Muito alto", false);
        questions.add(question1);

        //Questão 2. 
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion("trial");
        question2.setText("Múltipla escolha: O que sua equipe acredita ser um bom meio de interação entre si?");
        question2.setChoice("Reuniões.", false);
        question2.setChoice("Jogos.", false);
        question2.setChoice("Bate-papo de mesa redonda.", true);
        questions.add(question2);

        //Questão 3.
        MultipleAnswerQuestion question3 = new MultipleAnswerQuestion("vetted");
        question3.setText("Respostas múltiplas (mais de uma são possíveis): Das redes sociais abaixo, quais são as mais usadas pela sua equipe?");
        question3.setChoice("Pinterest.", false);
        question3.setChoice("Facebook.", true);
        question3.setChoice("Instagram.", false);
        question3.setChoice("Linkedin.", false);
        question3.setChoice("WhatsApp.", true);
        question3.setChoice("Skype.", false);
        question3.setChoice("Telegram.", true);
        questions.add(question3);

        //Questão 4.
        MultipleAnswerQuestion question4 = new MultipleAnswerQuestion("vetted");
        question4.setText("Respostas múltiplas (mais de uma são possíveis): Dos assunstos abaixo, quais a maioria da sua equipe selecionou como não sendo agradável para conversar no ambiente de trabalho?");
        question4.setChoice("Futebol.", true);
        question4.setChoice("Política.", false);
        question4.setChoice("Religião.", false);
        question4.setChoice("Melhores IDE's.", true);
        question4.setChoice("Melhores SO's.", true);
        question4.setChoice("Filosofia.", false);
        questions.add(question4);

        //Questão 5. 
        FillBlankQuestion question5 = new FillBlankQuestion("vetted");
        question5.setText("Preencha o espaço em branco: Trocar ___ é uma maneira de comparar ideias, ___ o outro e combinar ações a serem realizadas; em suma, ___ é um meio de aprender. Sugestões: entender - informacoes - participar");
        question5.setAnswer("informacoes");
        question5.setAnswer("entender");
        question5.setAnswer("participar");
        questions.add(question5);

        //Questão 6.
        FillBlankQuestion question6 = new FillBlankQuestion("vetted");
        question6.setText("Preencha o espaço em branco: Tem-se como ideia básica o fato de que as pessoas são mais ___ quanto mais satisfeitas e ___ com o próprio ___. Sugestões: trabalho - produtivas - envolvidas");
        question6.setAnswer("produtivas");
        question6.setAnswer("envolvidas");
        question6.setAnswer("trabalho");
        questions.add(question6);

        //Questão 7.
        FillBlankQuestion question7 = new FillBlankQuestion("vetted");
        question7.setText("Entre os muitos fatores que implicam a melhoria na qualidade de vida no trabalho, cita-se a interação social, tendo como base a ausência de ___, criação de áreas comuns para ___ dos servidores, promoção dos relacionamentos ___ e senso ___. Sugestões: comunitário - integração - preconceitos - interpessoais");
        question7.setAnswer("preconceitos");
        question7.setAnswer("integração");
        question7.setAnswer("interpessoais");
        question7.setAnswer("comunitário");
        questions.add(question7);

    }

    /**
     * Exibe uma mensagem. Exibe as questões. Pega a entrada. Checa se 
     * está correto e notifica o usuário os pontos ganhados.
     */
    public void displayAndCheckQuestions() {

        //Exibe uma mensagem
        String message
                = "Para questões de múltipla escolha, insira o número da "
                + "sua escolha.\nPara questões de múltiplas respostas, insira o(s) número(s) "
                + "de sua(s) escolha(s) separado(s) por espaço.\nPara questões de preencha o espaço em branco"
                + " insira sua(s) resposta(s) separada(s) por espaços.\n";

        System.out.println(message);

        //Para cada questão em questões
        for (int i = 0; i < questions.size(); i++) {

            //Exibe a questão
            System.out.println(questions.get(i).display());

            //Pega a entrada
            String input;
            System.out.println("Insira suas respostas em ordem separadas por espaços.");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            
            //Printa uma linha
            System.out.println();
            
            //Mostra os pontos ganhados pelo usuário na questão
            System.out.println("Você ganhou " + questions.get(i).checkQuestion(input) + " pontos.");
            
            //Adiciona os pontos ganhos na questão ao total de pontos
            score += questions.get(i).checkQuestion(input);
            
            //Mostra o total de pontos ganhos pelo usuário
            System.out.println("Total de pontos: "+score+"\n");
            
            //Foi uma resposta examinada/tentada e correta, parcialmente correta ou incorreta?
            int compare;
            
            if (questions.get(i).gradeQuestion()) { //Questão foi examinada
                
                //Conta o número de questões examinadas
                totalVetted++;
                
                //Adiciona ao score das examinadas
                vettedScore += questions.get(i).checkQuestion(input);
                
                //Foi uma questão correta, parcialmente correta ou incorreta?
                compare = Double.compare(questions.get(i).checkQuestion(input), 0.0);
                if (compare > 0) {
                    //Conta as examinadas corretas/parcialmente
                    totalCorrectVetted++;
                } else {
                    //Conta as examinadas incorretas
                    totalIncorrectVetted++;
                }

            } else { //Questão é de tentativa
                
                //Conta as questões de tentativas
                totalTrial++;
                
                //Adiciona ao score de tentativas
                trialScore += questions.get(i).checkQuestion(input);
                
                //Foi uma questão correta, parcialmente correta ou incorreta?
                compare = Double.compare(questions.get(i).checkQuestion(input), 0.0);
                if (compare > 0) {
                    //Conta as questões de tentativas corretas/parcialmente
                    totalCorrectTrial++;
                } else {
                    //Conta as questões de tentativas incorretas
                    totalIncorrectTrial++;
                }

            }

        }

    }
    
    /**
     * Relatório total das questões.
     * Relatório de pontos ganhados por cada tipo de questão.
     * Relatório de questões respondidas corretamente ou parcialmente correta por cada tipo de questão.
     * Relatório de questões respondidas incorretamente por cada tipo de questão.
     */
    
    public void summarizeResults() {
        int totalCorrect = totalCorrectVetted+totalCorrectTrial;
        int totalIncorrect = totalIncorrectVetted+totalIncorrectTrial;
        
        System.out.println("Havia um total de "+questions.size()+" questões.");
        System.out.println("Você ganhou um total de "+score+" pontos.");
        System.out.println("Respondeu "+totalCorrect+" questões corretamente ou parcialmente corretas.");
        System.out.println("Respondeu " +totalIncorrect+" questões incorretamente.");
        System.out.println();
        
        /*System.out.println("Havia "+totalVetted+" questões examinadas");
        System.out.println("Você ganhou um total"+vettedScore+" points on them.");
        System.out.println("Respondeu "+totalCorrectVetted+" questões corretamente ou parcialmente corretas");
        System.out.println("Respondeu " +totalIncorrectVetted+" for no credit");
        System.out.println();
        
        System.out.println("Havia "+totalTrial+" trial questões");
        System.out.println("Você ganhou um total"+trialScore+" points on them.");
        System.out.println("Respondeu "+totalCorrectTrial+" questões corretamente ou parcialmente corretas");
        System.out.println("Respondeu " +totalIncorrectTrial+" for no credit");*/
        
        System.out.println("Tenha um excelente dia.");
    }

}