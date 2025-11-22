package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;


public class GameGUI {
    
    private JFrame window;
    private Container con;
    
    private JPanel titleNamePanel;
    private JPanel startButtonPanel;
    private JPanel mainTextPanel;
    private JPanel choiceButtonPanel;
    private JPanel playerPanel;
    
    private JLabel titleNameLabel;
    private JLabel hpLabel;
    private JLabel hpLabelNumber;
    private JLabel mpLabel;
    private JLabel mpLabelNumber;
    private JLabel classLabel;
    private JLabel levelLabel;
    
    private Font titleFont = new Font("Monospaced", Font.PLAIN, 58);
    private Font normalFont = new Font("Monospaced", Font.PLAIN, 24);
    private Font smallFont = new Font("Monospaced", Font.PLAIN, 18);
    private Font storyFont = new Font("Monospaced", Font.PLAIN, 20);
    
    private JButton startButton;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    
    private JTextArea mainTextArea;
    
    public GameGUI() {
        initializeWindow();
        createTitleScreen();
    }
    
    private void initializeWindow() {
        window = new JFrame();
        window.setSize(900, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();
    }
    
    
    private void createTitleScreen() {
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(50, 50, 800, 100);
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setOpaque(false);
        titleNameLabel = new JLabel("Legend Of Aetheria");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 500, 300, 100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setOpaque(false);
        
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }
    
    public void showWindow() {
        window.setVisible(true);
    }
    
    public void createMainTextPanel(int x, int y, int width, int height) {
        if (mainTextPanel != null) {
            con.remove(mainTextPanel);
        }
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(x, y, width, height);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        
        mainTextArea = new JTextArea();
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(storyFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(mainTextArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(width - 20, height - 12));
        scrollPane.setBackground(Color.black);
        scrollPane.getViewport().setBackground(Color.black);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        mainTextPanel.add(scrollPane);
        
        mainTextPanel.revalidate();
        mainTextPanel.repaint();
    }
    
    
    public void createChoiceButtonPanel(int x, int y, int width, int height) {
        if (choiceButtonPanel != null) {
        	choiceButtonPanel.setVisible(false);
        	choiceButtonPanel.removeAll();
            con.remove(choiceButtonPanel);
            choiceButtonPanel = null;
        }
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(x, y, width, height);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1, 0, 10));
        con.add(choiceButtonPanel);
        choiceButtonPanel.setVisible(true);
        
        
        con.revalidate();
        con.repaint();
    }
    
    public void createSingleButtonPanel(int x, int y, int width, int height) {
    	if (choiceButtonPanel != null) {
    		choiceButtonPanel.setVisible(false);
    		choiceButtonPanel.removeAll();
            con.remove(choiceButtonPanel);
            choiceButtonPanel = null;
        }
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(x, y, width, height);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(1, 1));
        con.add(choiceButtonPanel);
        choiceButtonPanel.setVisible(true);
        
        
        con.revalidate();
        con.repaint();
    }
    
    public void createPlayerPanel() {
        if (playerPanel == null) {
            playerPanel = new JPanel();
            playerPanel.setBounds(50, 15, 800, 50);
            playerPanel.setBackground(Color.black);
            playerPanel.setLayout(new GridLayout(1, 6));
            con.add(playerPanel);
            
            levelLabel = new JLabel();
            levelLabel.setFont(smallFont);
            levelLabel.setForeground(Color.white);
            playerPanel.add(levelLabel);
            
            classLabel = new JLabel();
            classLabel.setFont(smallFont);
            classLabel.setForeground(Color.white);
            playerPanel.add(classLabel);
            
            hpLabel = new JLabel("HP:");
            hpLabel.setFont(smallFont);
            hpLabel.setForeground(Color.white);
            playerPanel.add(hpLabel);
            
            hpLabelNumber = new JLabel();
            hpLabelNumber.setFont(smallFont);
            hpLabelNumber.setForeground(Color.white);
            playerPanel.add(hpLabelNumber);
            
            mpLabel = new JLabel("MP:");
            mpLabel.setFont(smallFont);
            mpLabel.setForeground(Color.white);
            playerPanel.add(mpLabel);
            
            mpLabelNumber = new JLabel();
            mpLabelNumber.setFont(smallFont);
            mpLabelNumber.setForeground(Color.white);
            playerPanel.add(mpLabelNumber);
        }
        playerPanel.setVisible(true);
    }
    
    public JButton createButton(String text, String command, Font font) {
        JButton button = new JButton(text);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setFont(font);
        button.setActionCommand(command);
        return button;
    }
    
   
    public JFrame getWindow() { return window; }
    public Container getContainer() { return con; }
    public JPanel getTitleNamePanel() { return titleNamePanel; }
    public JPanel getStartButtonPanel() { return startButtonPanel; }
    public JPanel getMainTextPanel() { return mainTextPanel; }
    public JPanel getChoiceButtonPanel() { return choiceButtonPanel; }
    public JPanel getPlayerPanel() { return playerPanel; }
    public JButton getStartButton() { return startButton; }
    public JButton getChoice1() { return choice1; }
    public JButton getChoice2() { return choice2; }
    public JButton getChoice3() { return choice3; }
    public JButton getChoice4() { return choice4; }
    public JTextArea getMainTextArea() { return mainTextArea; }
    public JLabel getHpLabelNumber() { return hpLabelNumber; }
    public JLabel getMpLabelNumber() { return mpLabelNumber; }
    public JLabel getLevelLabel() { return levelLabel; }
    public JLabel getClassLabel() { return classLabel; }
    
    public Font getTitleFont() { return titleFont; }
    public Font getNormalFont() { return normalFont; }
    public Font getSmallFont() { return smallFont; }
    public Font getStoryFont() { return storyFont; }
    
   
    public void setChoice1(JButton btn) { choice1 = btn; }
    public void setChoice2(JButton btn) { choice2 = btn; }
    public void setChoice3(JButton btn) { choice3 = btn; }
    public void setChoice4(JButton btn) { choice4 = btn; }

}