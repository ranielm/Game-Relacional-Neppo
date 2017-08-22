package quiz;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class  Quiz01 extends JFrame implements ActionListener{
            JPanel panel;
            JPanel panelresult;
            JRadioButton choice1;
            JRadioButton choice2;
            JRadioButton choice3;
            JRadioButton choice4;
            ButtonGroup bg;
            JLabel lblmess;
            JButton btnext;
            String[][] qpa;
            String[][] qca;
            int qaid;
            HashMap<Integer, String> map;

            Quiz01(){
                      initializedata();
                      setTitle("Game Relacional Neppo");
                      //setDefaultCloseOperation(EXIT_ON_CLOSE);  
                      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                      setSize(430,350);
                      setLocation(300,100);
                      setResizable(false);
                      Container cont=getContentPane();
                      cont.setLayout(null);          
                      cont.setBackground(Color.GRAY);
                    bg=new ButtonGroup();     
                    choice1=new JRadioButton("Choice1",true);
                    choice2=new JRadioButton("Choice2",false);
                    choice3=new JRadioButton("Choice3",false);
                    choice4=new JRadioButton("Choice4",false);
                    bg.add(choice1);
                    bg.add(choice2);
                    bg.add(choice3);
                    bg.add(choice4);
                    lblmess=new JLabel("Escolha a resposta correta");
                    lblmess.setForeground(Color.BLUE);
                    lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                    btnext=new JButton("Próximo");
                    btnext.setForeground(Color.GREEN);                
                    btnext.addActionListener(this);
                    panel=new JPanel();
                    panel.setBackground(Color.LIGHT_GRAY);
                    panel.setLocation(10,10);
                    panel.setSize(400,300);
                    panel.setLayout(new GridLayout(6,2));
                    panel.add(lblmess);
                    panel.add(choice1);
                    panel.add(choice2);
                    panel.add(choice3);
                    panel.add(choice4);
                    panel.add(btnext);
                    cont.add(panel);
                    setVisible(true);
                    qaid=0;
                    readqa(qaid);
            }
           
        public void actionPerformed(ActionEvent e){
           
                        if(btnext.getText().equals("Próximo")){
                                    if(qaid<9){
                                               
                                                map.put(qaid,getSelection());
                                                qaid++;
                                                readqa(qaid);
                                                }
                                    else {
                                                map.put(qaid,getSelection());
                                                btnext.setText("Mostrar respostas");
                                               
                                             }
                                    }
                        else if(btnext.getText().equals("Mostrar respostas"))
                                    new Report();
                       
                       
            }
        
        public void initializedata(){
                        //Armazena as questões e suas possíveis respostas
                        qpa=new String[10][5];

                        qpa[0][0]="Quantos membros da sua equipe jogam algum jogo online?";
                        qpa[0][1]="2";
                        qpa[0][2]="5";
                        qpa[0][3]="3";
                        qpa[0][4]="0";

                        qpa[1][0]="Qual é a área de maior afinidade entre os membros?";
                        qpa[1][1]="Front-end/Back-end.";
                        qpa[1][2]="BI.";
                        qpa[1][3]="Banco de dados.";
                        qpa[1][4]="Testes.";
                       
                        qpa[2][0]="Qual dia da semana a maioria prefere sair com os amigos?";
                        qpa[2][1]="Quinta.";
                        qpa[2][2]="Sexta.";
                        qpa[2][3]="Sábado.";
                        qpa[2][4]="Domingo.";

                        qpa[3][0]="Quantos membros jogam futebol toda quinta?";
                        qpa[3][1]="1";
                        qpa[3][2]="2";
                        qpa[3][3]="0";
                        qpa[3][4]="4";

                        qpa[4][0]="O que a maioria da sua equipe gosta menos?";
                        qpa[4][1]="Falta de disposição.";
                        qpa[4][2]="Trabalho não terminado no prazo.";
                        qpa[4][3]="Conclusão mal feita de tarefas.";
                        qpa[4][4]="Discussões desnecessárias.";

                        qpa[5][0]="O que a maioria acredita ser fundamental no trabalho?";
                        qpa[5][1]="Harmonia.";
                        qpa[5][2]="Coletividade.";
                        qpa[5][3]="Organização.";
                        qpa[5][4]="Disciplina.";

                        qpa[6][0]="Qual filme foi marcado como uma boa opção pela maioria?";
                        qpa[6][1]="Star Wars.";
                        qpa[6][2]="Clube da Luta.";
                        qpa[6][3]="Velozes e Furiosos.";
                        qpa[6][4]="Como eu era antes de você.";

                        qpa[7][0]="Qual o nível de diálogo que deve haver entre as pessoas?";
                        qpa[7][1]="Só o necessário.";
                        qpa[7][2]="Conversar sobre projeto e áreas pessoais.";
                        qpa[7][3]="Conversas somente via Skype.";
                        qpa[7][4]="Sobre o que se sentir à vontade.";

                        qpa[8][0]="Qual o nível de satisfação da equipe em relação ao trabalho?";
                        qpa[8][1]="Muito alto.";
                        qpa[8][2]="Baixo";
                        qpa[8][3]="Médio";
                        qpa[8][4]="Alto";

                        qpa[9][0]="O que é considerado como algo positivo entre a equipe?";
                        qpa[9][1]="A união do grupo.";
                        qpa[9][2]="A dedicação ao trabalho.";
                        qpa[9][3]="A organização.";
                        qpa[9][4]="A qualidade do serviço.";

                        //Armazena o enunciado das questões e sua resposta correta
                        qca=new String[10][2];
                       
                        qca[0][0]="Quantos membros da sua equipe jogam algum jogo online?";
                        qca[0][1]="3";

                        qca[1][0]="Qual é a área de maior afinidade entre os membros?";
                        qca[1][1]="Front-end/Back-end.";

                        qca[2][0]="Qual dia da semana a maioria prefere sair com os amigos?";
                        qca[2][1]="Sexta.";

                        qca[3][0]="Quantos membros jogam futebol toda quinta?";
                        qca[3][1]="4";

                        qca[4][0]="O que a maioria da sua equipe gosta menos?";
                        qca[4][1]="Falta de disposição";

                        qca[5][0]="O que a maioria acredita ser fundamental no trabalho?";
                        qca[5][1]="Disciplina";

                        qca[6][0]="Qual filme foi marcado como uma boa opção pela maioria?";
                        qca[6][1]="Clube da Luta";
                       
                        qca[7][0]="Qual o nível de diálogo que deve haver entre as pessoas?";
                        qca[7][1]="Conversar sobre projeto e áreas pessoais.";
                       
                        qca[8][0]="Qual o nível de satisfação da equipe em relação ao trabalho?";
                        qca[8][1]="Alto";

                        qca[9][0]="O que é considerado como algo positivo entre a equipe?";
                        qca[9][1]="A dedicação ao trabalho.";
                       
                        //Cria um objeto "map" para armazenar as questões e selecionar as respostas
                        map=new HashMap<Integer, String>();
                       
                        }
        public String getSelection(){
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=bg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }

        public void readqa(int qid){
                        lblmess.setText("  "+qpa[qid][0]);
                        choice1.setText(qpa[qid][1]);
                        choice2.setText(qpa[qid][2]);
                        choice3.setText(qpa[qid][3]);
                        choice4.setText(qpa[qid][4]);
                        choice1.setSelected(true);
            }
        public void reset(){
                        qaid=0;
                        map.clear();
                        readqa(qaid);
                        btnext.setText("Próximo");
                        }
        public int calCorrectAnswer(){
                        int qnum=10;
                        int count=0;
                        for(int qid=0;qid<qnum;qid++)
                                    if(qca[qid][1].equals(map.get(qid))) count++;
                        return count;
            }
        public class Report extends JFrame{
                        Report(){
                                    setTitle("Respostas");
                                    setSize(850,550);
                                    setBackground(Color.WHITE);
                                    addWindowListener(new WindowAdapter(){
                                                            public void windowClosing(WindowEvent e){
                                                                        dispose();
                                                                        reset();
                                                            }
                                                });
                                    Draw d=new Draw();                                  
                                    add(d);
                                    setVisible(true);
                                    }
}
        
        class Draw extends Canvas{
                                    public void paint(Graphics g){
                                                int qnum=10;
                                                int x=10;
                                                int y=20;
                                                for(int i=0;i<qnum;i++){
                                                            //exibe a 1ª coluna
                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         
                                                            g.drawString(i+1+". "+qca[i][0], x,y);
                                                            y+=30;           
                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             
                                                            g.drawString("      Resposta correta: "+qca[i][1], x,y);
                                                            y+=30;
                                                            g.drawString("      Sua resposta: "+map.get(i), x,y);
                                                            y+=30;
                                                            //exibe a 2ª coluna
                                                            if(y>400)
                                                            {y=20;
                                                              x=450;
                                                            }
                                                           
                                                }
                                                //Exibe o número de respostas corretas
                                                int numc=calCorrectAnswer();
                                                g.setColor(Color.BLUE);
                                                g.setFont(new Font("Arial",Font.BOLD,14));
                                                int pont = (numc*5);
                                                g.drawString("Sua pontuação: "+pont,300,480);
                                                g.drawString("Número de respostas corretas: "+numc,300,500);
                                               
                                    }
                        }
}