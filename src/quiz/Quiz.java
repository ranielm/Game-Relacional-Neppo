package quiz;
import java.util.Scanner;

public class Quiz {
        public static void menu(){
        System.out.println("\tEscolha uma das aplicações:");
        System.out.println("0. Fim");
        System.out.println("1. Quiz 01 - 10 questões usando interface gráfica");
        System.out.println("2. Quiz 02 - Tipos diferentes de questões");
        System.out.println("Opcao:");
    }

    public static void quiz01(){
        System.out.println("Você entrou no Quiz 01.");
        new Quiz01();
    }
    
    public static void quiz02(){
        System.out.println("Você entrou no Quiz 02.");
        //Cria um novo quiz
        Quiz02 doom = new Quiz02();

        //Cria as questões do quiz
        doom.createQuestions();

        //Exibe as questões ao usuário, recebe e checa a resposta
        doom.displayAndCheckQuestions();

        //Cria um sumário para os resultados
        doom.summarizeResults();
    }
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                quiz01();
                break;
                
            case 2:
                quiz02();
                break;
                
            case 0:
                System.out.println("Até mais!");
                System.exit(0);
                break;
                
            default:
                
            }
        } while(opcao != 0);
    }
}