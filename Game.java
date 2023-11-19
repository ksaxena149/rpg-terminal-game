import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

  JFrame window;
  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, statsPanel;
  JLabel titleNameLabel, hpLabel, hpNumberLabel, weapLabel, weapNameLabel;
  JButton startButton, choice1Button, choice2Button, choice3Button, choice4Button;
  JTextArea mainTextArea;

  int playerHP;
  String playerWeapon, position;

  Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
  Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

  TitleScreenHandler tsHandler = new TitleScreenHandler();
  ChoiceHandler choiceHandler = new ChoiceHandler();
  public static void main(String[] args){
    new Game();
  }
  public Game(){
    window = new JFrame();
    window.setSize(800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.BLACK);
    window.setLayout(null); // disables default layout and uses custom layout
    
    titleNamePanel = new JPanel();
    titleNamePanel.setBounds(100,100,600,150);
    titleNamePanel.setBackground(Color.BLACK);
    
    titleNameLabel = new JLabel("Adventure");
    titleNameLabel.setForeground(Color.WHITE);
    titleNameLabel.setFont(titleFont);
    
    titleNamePanel.add(titleNameLabel);
    
    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(300, 400, 200, 100);
    startButtonPanel.setBackground(Color.BLACK);
    
    startButton = new JButton("START");
    startButton.setBackground(Color.BLACK);
    startButton.setForeground(Color.WHITE);
    startButton.setFont(normalFont);
    startButton.setFocusPainted(false); 
    startButton.addActionListener(tsHandler);
    
    
    startButtonPanel.add(startButton);
    
    window.add(titleNamePanel);
    window.add(startButtonPanel);
    window.setVisible(true); // this makes screen appear
  }
  public void createGameScreen(){
    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    statsPanel = new JPanel();
    statsPanel.setBounds(100, 15, 600, 50);
    statsPanel.setBackground(Color.BLACK);
    statsPanel.setLayout(new GridLayout(1,4));
    window.add(statsPanel);

    hpLabel = new JLabel("HP:");
    hpLabel.setFont(normalFont);
    hpLabel.setForeground(Color.WHITE);
    hpLabel.setBackground(Color.BLACK);
    statsPanel.add(hpLabel);

    hpNumberLabel = new JLabel();
    hpNumberLabel.setFont(normalFont);
    hpNumberLabel.setForeground(Color.WHITE);
    hpNumberLabel.setBackground(Color.BLACK);
    statsPanel.add(hpNumberLabel);

    weapLabel = new JLabel("Weapon:");
    weapLabel.setFont(normalFont);
    weapLabel.setForeground(Color.WHITE);
    weapLabel.setBackground(Color.BLACK);
    statsPanel.add(weapLabel);

    weapNameLabel = new JLabel();
    weapNameLabel.setFont(normalFont);
    weapNameLabel.setForeground(Color.WHITE);
    weapNameLabel.setBackground(Color.BLACK);
    statsPanel.add(weapNameLabel);

    
    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100,100,600,250);
    mainTextPanel.setBackground(Color.BLACK);
    window.add(mainTextPanel);
    
    mainTextArea = new JTextArea("This is the main text area");
    mainTextArea.setBounds(150,100,400,250);
    mainTextArea.setBackground(Color.BLACK);
    mainTextArea.setForeground(Color.WHITE);
    mainTextArea.setFont(normalFont);
    mainTextArea.setLineWrap(true);
    mainTextArea.setEditable(false); 
    mainTextArea.setWrapStyleWord(true);
    
    mainTextPanel.add(mainTextArea);
    
    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(250, 350, 300, 150);
    choiceButtonPanel.setBackground(Color.BLACK);
    choiceButtonPanel.setLayout(new GridLayout(4,1));
    window.add(choiceButtonPanel);
    
    choice1Button = new JButton("Choice 1");
    choice1Button.setBackground(Color.BLACK);
    choice1Button.setForeground(Color.WHITE);
    choice1Button.setFont(normalFont);
    choice1Button.setFocusPainted(false);
    choice1Button.addActionListener(choiceHandler); 
    choice1Button.setActionCommand("c1");
    choiceButtonPanel.add(choice1Button);
    
    choice2Button = new JButton("Choice 2");
    choice2Button.setBackground(Color.BLACK);
    choice2Button.setForeground(Color.WHITE);
    choice2Button.setFont(normalFont);
    choice2Button.setFocusPainted(false); 
    choice2Button.addActionListener(choiceHandler);
    choice2Button.setActionCommand("c2");
    choiceButtonPanel.add(choice2Button);
    
    choice3Button = new JButton("Choice 3");
    choice3Button.setBackground(Color.BLACK);
    choice3Button.setForeground(Color.WHITE);
    choice3Button.setFont(normalFont);
    choice3Button.setFocusPainted(false); 
    choice3Button.addActionListener(choiceHandler);
    choice3Button.setActionCommand("c3");
    choiceButtonPanel.add(choice3Button);
    
    choice4Button = new JButton("Choice 4");
    choice4Button.setBackground(Color.BLACK);
    choice4Button.setForeground(Color.WHITE);
    choice4Button.setFont(normalFont);
    choice4Button.setFocusPainted(false); 
    choice4Button.addActionListener(choiceHandler);
    choice4Button.setActionCommand("c4");
    choiceButtonPanel.add(choice4Button);
    playerSetup();
    
  }

  public void playerSetup(){ //done
    playerHP = 15;
    playerWeapon = "Knife";
    weapNameLabel.setText(playerWeapon);
    hpNumberLabel.setText(""+playerHP);
    townGate();
  }

  public void gameOver(){ //done
    mainTextArea.setText("You Died :(");
    choice1Button.setText("Play Again");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void townGate(){ //done
    position = "townGate";
    mainTextArea.setText("You are at the gate of the town and a guard is standing in front of you.\nWhat do you do?");
    choice1Button.setText("Talk to the Guard");
    choice2Button.setText("Attack the Guard");
    choice3Button.setText("Go Left");
    choice4Button.setText("Go Right");
  }

  public void townGateFinal(){ //done
    position = "townGateFinal";
    mainTextArea.setText("You are at the gate of the town and a guard is standing in front of you.\nWhat do you do?");
    choice1Button.setText("Talk to the Guard");
    choice2Button.setText("Attack the Guard");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void talkGuard(){ //done
    position = "talkGuard";
    mainTextArea.setText("SHOOO!!!");
    choice1Button.setText("Go Back");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

    public void talkGuardFinal(){ //done
      position = "talkGuardFinal";
      mainTextArea.setText("Wow! You came back even stronger, with a sword, Let's Fight!");
      choice1Button.setText("Attack Guard!");
      choice2Button.setText("");
      choice3Button.setText("");
      choice4Button.setText("");
  }

  public void attackGuard() { //done
    position = "attackGuard";
    mainTextArea.setText("Guard: That did nothing to me, my turn!\nThe guard fights back and hits you with his sword and deals 3 damage.");
    playerHP -= 3;
    hpNumberLabel.setText(""+playerHP);
    choice1Button.setText("Go Back");
    choice2Button.setText("Attack Guard");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void attackGuardFinal(){ //done
    position = "attackGuardFinal";
    mainTextArea.setText("Guard: Ohh no!!!\nYou killed the guard, you won!");
    choice1Button.setText("Finish");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void rightFromTown(){ //done
    position = "rightFromTown";
    mainTextArea.setText("Dead End Here");
    choice1Button.setText("Go Back");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void leftFromTown(){ //done
    position = "leftFromTown";
    mainTextArea.setText("You are at the crossroad. Where do you go?");
    choice1Button.setText("Go Left");
    choice2Button.setText("Go Right");
    choice3Button.setText("Go Forward");
    choice4Button.setText("Go Back");
  }

  public void leftFFromTown(){ // done
    position = "leftFFromTown";
    mainTextArea.setText("Dead End");
    choice1Button.setText("Go Back");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void leftLFromTown(){ // done
    position = "leftLFromTown";
    mainTextArea.setText("Dead End");
    choice1Button.setText("Go Back");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void leftRFromTown(){ // done
    position = "leftRFromTown";
    mainTextArea.setText("You see someone with a sword, \nWhat do you want to do?");
    choice1Button.setText("Talk to Him");
    choice2Button.setText("Attack Him");
    choice3Button.setText("Go Back");
    choice4Button.setText("");
  }

  public void talkPerson(){
    position = "talkPerson";
    mainTextArea.setText("Kushagra: Hello, I am the creater of the game, you can have my sword in exchange for full marks for this game\n What do you do?");
    choice1Button.setText("Give him full marks");
    choice2Button.setText("Cut few marks");
    choice3Button.setText("Go Back");
    choice4Button.setText("");
  }

  public void attackPerson(){
  position = "attackPerson";
  mainTextArea.setText("You tried to attack the creator of the game, but he's way too strong, he attacks you with his sword, deals 100 damage, and you die.");
  playerHP -= 100;
  hpNumberLabel.setText(""+playerHP);
  choice1Button.setText("Play Again");
  choice2Button.setText("");
  choice3Button.setText("");
  choice4Button.setText("");
  }

  public void giveFullMarks(){
    position = "giveFullMarks";
    mainTextArea.setText("Kushagra: Thank you for giving me full marks, here's my sword, you can have it.");
    playerWeapon = "Sword";
    weapNameLabel.setText(playerWeapon);
    choice1Button.setText("Go Back to Town");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void cutFewMarks(){
    position = "cutFewMarks";
    mainTextArea.setText("Kushagra: Unacceptable! you shall die for this.\n Kushagra attacks you with his sword and deals 100 damage, you die.");
    playerHP -= 100;
    choice1Button.setText("Go Back");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void winningScreen(){
    position = "winningScreen";
    mainTextArea.setText("You won the game, congratulations! (Thank you for full marks)");
    choice1Button.setText("Quit");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public class TitleScreenHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
      createGameScreen();
    }
  }

  public class ChoiceHandler implements ActionListener {
    public void actionPerformed(ActionEvent event){
      String choice = event.getActionCommand();
      if(playerHP>0){
        switch (position) {
          case "townGate":
            switch (choice) {
              case "c1":
                talkGuard();
                break;
              case "c2":
                attackGuard();
                break;
              case "c3":
                leftFromTown();
                break;
              case "c4":
                rightFromTown();
                break;
              default:
                break;
            }
            break;
          case "talkGuard":
            switch (choice) {
              case "c1":
                townGate();
                break;
            
              default:
                break;
            }
            break;
          case "attackGuard":
            switch (choice) {
              case "c1":
                townGate();
                break;
              case "c2":
                attackGuard();
                break;

              default:
                break;
            }
            break;
          case "leftFromTown":
            switch (choice) {
              case "c1":
                leftLFromTown();
                break;
              case "c2":
                leftRFromTown();
                break;
              case "c3":
                leftFFromTown();
                break;
              case "c4":
                townGate();
                break;
              default:
                break;
            }
            break;
          case "rightFromTown":
            switch (choice) {
              case "c1":
                townGate();
                break;
              default:
                break;
            }
            break;
          case "leftFFromTown":
            switch (choice) {
              case "c1":
                leftFromTown();
                break;
            
              default:
                break;
            }
            break;
          case "leftLFromTown":
            switch (choice) {
              case "c1":
                leftFromTown();
                break;
            
              default:
                break;
            }
            break;
          case "leftRFromTown":
            switch (choice) {
              case "c1":
                talkPerson();
                break;
              case "c2":
                attackPerson();
                break;
              case "c3":
                leftFromTown();
                break;
              default:
                break;
            }
            break;
          
          case "talkPerson":
            switch (choice) {
              case "c1":
                giveFullMarks();
                break;
              case "c2":
                cutFewMarks();
                break;
              case "c3":
                leftRFromTown();
                break;
              default:
                break;
            }
            break;
          case "attackPerson":
            switch (choice) {
              case "c1":
                townGate();
                break;
            
              default:
                break;
            }
            break;
          case "giveFullMarks":
            switch (choice) {
              case "c1":
                townGateFinal();
                break;
            
              default:
                break;
            }
            break;
          case "townGateFinal":
            switch (choice) {
              case "c1":
                talkGuardFinal();
                break;
              case "c2":
                attackGuardFinal();
                break;
              case "c3":
                
                break;
              case "c4":
                
                break;
              default:
                break;
            }
            break;
          case "attackGuardFinal":
            switch (choice) {
              case "c1":
                winningScreen();
                break;
            
              default:
                break;
            }
            break;
          case "talkGuardFinal":
            switch (choice) {
              case "c1":
                winningScreen();
                break;
            
              default:
                break;
            }
            break;
          case "winningScreen":
            switch (choice) {
              case "c1":
                System.exit(0);
                break;
            
              default:
                break;
            }
            break;
          default:
            break;
        }
      } else {
        gameOver();
        switch (choice) {
          case "c1":
            playerSetup();
            break;
          default:
            break;
        }
      }
      
    }
  }

}