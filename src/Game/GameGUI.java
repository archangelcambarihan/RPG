package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import Game.Characters.Character;
import Game.Enemies.*;

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
    
    private JTextArea mainTextArea;
    
    private GameManager gameManager;
    private Character player;
    private Enemy currentEnemy;
    private String currentWorld = "Tera Capital";
    private String currentEnemyType = "normal";
    private boolean[] worldDefeated = new boolean[3];
    private int worldProgress = 0;
    
    public GameGUI() {
        gameManager = new GameManager();
        initializeWindow();
        createTitleScreen();
        startButton.addActionListener(e -> ShowIntroduction());
        showWindow();
    }
    
    private void initializeWindow() {
        window = new JFrame();
        window.setSize(900, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setResizable(false);
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
    
    private void showWindow() {
        window.setVisible(true);
    }
    
    
    public void ShowIntroduction() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        createMainTextPanel(50, 70, 800, 380);
        mainTextArea.setText(Story.getIntroduction());
        addSingleButton("Continue", "showCharSelect", 250, 470);
    }
    
    public void CharacterSelection() {
        mainTextPanel.setBounds(50, 70, 800, 220);
        mainTextArea.setText(Story.getCharacterSelectionText());
        mainTextArea.setFont(normalFont);
        mainTextArea.setCaretPosition(0);
        createChoiceButtonPanel(200, 310, 500, 240);
        
        String[] chars = {"Cloud", "Asura", "Arthur", "Lune"};
        JButton[] btns = new JButton[4];
        for (int i = 0; i < 4; i++) {
            btns[i] = createAndAddButton(chars[i], "select" + chars[i]);
        }
        setChoices(btns);
    }
    
    public void ShowCharacterStory(String name) {
        mainTextArea.setText(Story.getCharacterStory(name));
        mainTextArea.setFont(storyFont);
        mainTextArea.setCaretPosition(0);
        createChoiceButtonPanel(200, 470, 500, 160);
        
        JButton beginBtn = createAndAddButton("Begin Adventure", "startAdventure");
        JButton backBtn = createAndAddButton("Back", "showCharSelect");
        setChoices(new JButton[]{beginBtn, backBtn});
    }
    
    
    public void MainMenu() {
        setupPlayerPanel();
        String progress = buildProgress();
        mainTextPanel.setBounds(50, 80, 800, 200);
        mainTextArea.setText("=== " + currentWorld.toUpperCase() + " ===\n\n" +
                "Progress:\n" + progress + "\nWhat will you do?");
        mainTextArea.setFont(normalFont);
        mainTextArea.setCaretPosition(0);
        createChoiceButtonPanel(200, 300, 500, 240);
        
        String[] actions = {"Fight Normal", "Fight General", "Fight Boss", "View Status"};
        String[] cmds = {"fightNormal", "fightGeneral", "fightBoss", "viewStatus"};
        JButton[] btns = new JButton[4];
        for (int i = 0; i < 4; i++) btns[i] = createAndAddButton(actions[i], cmds[i]);
        setChoices(btns);
        updatePlayerStats();
    }
    
    public void ViewStatus() {
        StringBuilder sb = new StringBuilder("=== CHARACTER STATUS ===\n\n");
        sb.append("Name: ").append(player.getName()).append("\n");
        sb.append("Class: ").append(player.getClassName()).append("\n");
        sb.append("Level: ").append(player.getLevel()).append("\n");
        sb.append("EXP: ").append(player.getCurrentExp()).
        append(" / ").append(player.getExpToNextLevel()).append("\n\n");
        sb.append("HP: ").append(player.getCurrentHP()).append(" / ").append(player.getMaxHP()).append("\n");
        sb.append("MP: ").append(player.getCurrentMP()).append(" / ").append(player.getMaxMP()).append("\n");
        sb.append("Attack: ").append(player.getAttack()).append("\n");
        sb.append("Defence: ").append(player.getDefence()).append("\n\n=== SKILLS ===\n");
        
        for (int i = 0; i < 3; i++) {
            if (player.getSkill(i) != null) {
                sb.append(i + 1).append(". ").append(player.getSkill(i).getName()).append("\n");
                sb.append("   DMG: ").append(player.getSkill(i).getDamage());
                sb.append(" | MP: ").append(player.getSkill(i).getMpCost());
                sb.append(" | CD: ").append(player.getSkill(i).getCooldown()).append("\n");
            }
        }
        
        sb.append("\n=== PROGRESS ===\nCurrent World: ").append(currentWorld).append("\n").append(buildProgress());
        mainTextPanel.setBounds(50, 70, 800, 380);
        mainTextArea.setText(sb.toString());
        mainTextArea.setFont(smallFont);
        mainTextArea.setCaretPosition(0);
        addSingleButton("Back", "mainMenu", 250, 470);
    }
    
    public void StartBattle(String type) {
        currentEnemyType = type;
        currentEnemy = gameManager.createEnemy(currentWorld, type);
        gameManager.setCurrentEnemy(currentEnemy);
        
        mainTextPanel.setBounds(50, 70, 800, 270);
        mainTextArea.setText(Story.getBattleIntro(currentEnemy.getName(), type.equals("boss")) +
                "Enemy: " + currentEnemy.getName() + "\nHP: " + currentEnemy.getCurrentHP() + "/" + 
                currentEnemy.getMaxHP() + "\nATK: " + currentEnemy.getAttack() + " | DEF: " + 
                currentEnemy.getDefence() + "\n\nBattle Start!");
        mainTextArea.setFont(normalFont);
        mainTextArea.setCaretPosition(0);
        createChoiceButtonPanel(200, 340, 500, 240);
        
        JButton[] btns = new JButton[4];
        for (int i = 0; i < 3; i++) {
            String skillName;
            if (player.getSkill(i) != null) {
                skillName = player.getSkill(i).getName();
            } else {
                skillName = "Skill " + (i+1);
            }
            btns[i] = createAndAddButton(skillName, "skill" + i, smallFont);
        }
        btns[3] = createAndAddButton("Normal Attack", "normalAttack", smallFont);
        setChoices(btns);
        updatePlayerStats();
    }
    
    public void PlayerTurn(String action) {
        String battleLog = "";
        player.restoreMP(20);
        player.restoreHP(5);
        
        if (action.equals("normalAttack")) {
            int dmg = player.getAttack();
            currentEnemy.takeDamage(dmg);
            battleLog = Story.getNormalAttackMessage(player.getName(), dmg);
        } else if (action.startsWith("skill")) {
            int idx = Integer.parseInt(action.substring(5));
            if (!player.canUseSkill(idx)) {
                mainTextArea.setText(Story.getSkillErrorMessage(
                    player.getSkillCooldown(idx) > 0, player.getSkillCooldown(idx),
                    player.getSkill(idx).getMpCost(), player.getCurrentMP()));
                mainTextArea.setCaretPosition(0);
                return;
            }
            int dmg = player.useSkill(idx);
            currentEnemy.takeDamage(dmg);
            battleLog = Story.getSkillUsedMessage(player.getSkill(idx).getName(), dmg);
        }
        
        if (!currentEnemy.isAlive()) { BattleVictory(); return; }
        
        player.reduceCooldowns();
        battleLog += EnemyTurn();
        
        if (!player.isAlive()) { BattleDefeat(); return; }
        
        battleLog += "\n--- Your Turn ---\nEnemy HP: " + currentEnemy.getCurrentHP() + "/" + 
                currentEnemy.getMaxHP() + "\nRecovered 10 MP!";
        mainTextArea.setText(battleLog);
        mainTextArea.setCaretPosition(0);
        updatePlayerStats();
    }
    
    public String EnemyTurn() {
        int dmg = currentEnemy.attackPlayer();
        player.takeDamage(dmg);
        return Story.getEnemyAttackMessage(currentEnemy.getName(), dmg);
    }
    
    public void BattleVictory() {
        int exp = currentEnemy.getExpReward();
        String msg = Story.getVictoryMessage(currentEnemy.getName(), exp);
        if (player.addExp(exp)) msg += Story.getLevelUpMessage(player.getLevel());
        
        player.heal(50);
        player.restoreMP(30);
        msg += "\n" + Story.getRestoreMessage();
        
        int typeIdx;
        if (currentEnemyType.equals("normal")) {
            typeIdx = 0;
        } else if (currentEnemyType.equals("general")) {
            typeIdx = 1;
        } else {
            typeIdx = 2;
        }
        worldDefeated[typeIdx] = true;
        
        if (typeIdx == 2 && worldDefeated[0] && worldDefeated[1]) {
            if (worldProgress < 2) {
                msg += Story.getWorldCompletionMessage(worldProgress);
            } else {
                FinalVictory();
                return;
            }
        }
        
        mainTextPanel.setBounds(50, 90, 800, 310);
        mainTextArea.setText(msg);
        mainTextArea.setFont(normalFont);
        mainTextArea.setCaretPosition(0);
        
        String command;
        if (worldDefeated[0] && worldDefeated[1] && worldDefeated[2] && worldProgress < 2) {
            command = "nextWorld";
        } else {
            command = "mainMenu";
        }
        addSingleButton("Continue", command, 250, 500);
        updatePlayerStats();
    }
    
    public void NextWorld() {
        worldProgress++;
        worldDefeated = new boolean[3];
        if (worldProgress == 1) {
            currentWorld = "Forest of Aetheria";
        } else {
            currentWorld = "Underworld";
        }
        MainMenu();
    }
    
    public void BattleDefeat() {
        mainTextPanel.setBounds(50, 80, 820, 380);
        mainTextArea.setText(Story.getDefeatMessage(currentEnemy.getName()));
        mainTextArea.setFont(normalFont);
        mainTextArea.setCaretPosition(0);
        addSingleButton("Return to Title", "gameOver", 250, 500);
    }
    
    public void FinalVictory() {
        mainTextPanel.setBounds(50, 70, 800, 380);
        mainTextArea.setText(Story.getFinalVictoryMessage(
                player.getName(), player.getClassName(), player.getLevel()));
        mainTextArea.setFont(storyFont);
        mainTextArea.setCaretPosition(0);
        addSingleButton("Return to Title", "gameOver", 250, 470);
    }
    
    private String buildProgress() {
        String[] labels = {"Normal Enemy", "General", "Boss"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (worldDefeated[i]) {
                sb.append("[/] ");
            } else {
                sb.append("[ ] ");
            }
            sb.append(labels[i]).append("\n");
        }
        return sb.toString();
    }
    
    private void setupPlayerPanel() {
        createPlayerPanel();
        playerPanel.setVisible(true);
        levelLabel.setText("Lv." + player.getLevel());
        classLabel.setText(player.getClassName());
        updatePlayerStats();
    }
    
    private void updatePlayerStats() {
        if (hpLabelNumber != null) 
            hpLabelNumber.setText(player.getCurrentHP() + "/" + player.getMaxHP());
        if (mpLabelNumber != null) 
            mpLabelNumber.setText(player.getCurrentMP() + "/" + player.getMaxMP());
        if (levelLabel != null) 
            levelLabel.setText("Lv." + player.getLevel());
    }
    
    private void selectCharacter(String name) {
        player = gameManager.createCharacter(name);
        gameManager.setPlayer(player);
    }
    
    private void resetGame() {
        worldProgress = 0;
        currentWorld = "Tera Capital";
        worldDefeated = new boolean[3];
        currentEnemy = null;
        player = null;
        if (playerPanel != null) playerPanel.setVisible(false);
        if (mainTextPanel != null) mainTextPanel.setVisible(false);
        if (choiceButtonPanel != null) choiceButtonPanel.setVisible(false);
        titleNamePanel.setVisible(true);
        startButtonPanel.setVisible(true);
    }
    
    private JButton createAndAddButton(String text, String cmd) {
        return createAndAddButton(text, cmd, normalFont);
    }
    
    private JButton createAndAddButton(String text, String cmd, Font font) {
        JButton btn = createButton(text, cmd, font);
        btn.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(btn);
        return btn;
    }
    
    private void addSingleButton(String text, String cmd, int x, int y) {
        createSingleButtonPanel(x, y, 400, 80);
        JButton btn = createButton(text, cmd, normalFont);
        btn.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(btn);
    }
    
    private void setChoices(JButton[] btns) {
        choiceButtonPanel.revalidate();
        choiceButtonPanel.repaint();
    }
    
    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("showCharSelect")) CharacterSelection();
            else if (cmd.startsWith("select")) {
                String name = cmd.substring(6);
                selectCharacter(name);
                ShowCharacterStory(name);
            }
            else if (cmd.equals("startAdventure") || cmd.equals("mainMenu")) MainMenu();
            else if (cmd.equals("viewStatus")) ViewStatus();
            else if (cmd.equals("fightNormal")) StartBattle("normal");
            else if (cmd.equals("fightGeneral")) StartBattle("general");
            else if (cmd.equals("fightBoss")) StartBattle("boss");
            else if (cmd.equals("normalAttack") || cmd.startsWith("skill")) PlayerTurn(cmd);
            else if (cmd.equals("nextWorld")) NextWorld();
            else if (cmd.equals("gameOver")) resetGame();
        }
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
}