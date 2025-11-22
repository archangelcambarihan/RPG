package Game;

import java.awt.event.*;
import javax.swing.JButton;
import Game.Characters.Character;
import Game.Enemies.*;

public class Main {
    private GameGUI gui;
    private GameManager gameManager;
    private Character player;
    private Enemy currentEnemy;
    private String currentWorld = "Tera Capital";
    private String currentEnemyType = "normal";
    private boolean[] worldDefeated = new boolean[3];
    private int worldProgress = 0;
    
    public static void main(String[] args) { new Main(); }
    
    public Main() {
        gameManager = new GameManager();
        gui = new GameGUI();
        gui.getStartButton().addActionListener(e -> ShowIntroduction());
        gui.showWindow();
    }
    
    public void ShowIntroduction() {
        gui.getTitleNamePanel().setVisible(false);
        gui.getStartButtonPanel().setVisible(false);
        gui.createMainTextPanel(50, 70, 800, 380);
        gui.getMainTextArea().setText(Story.getIntroduction());
        addSingleButton("Continue", "showCharSelect", 250, 470);
    }
    
    public void CharacterSelection() {
        gui.getMainTextPanel().setBounds(50, 70, 800, 220);
        gui.getMainTextArea().setText(Story.getCharacterSelectionText());
        gui.getMainTextArea().setFont(gui.getNormalFont());
        gui.getMainTextArea().setCaretPosition(0);
        gui.createChoiceButtonPanel(200, 310, 500, 240);
        
        String[] chars = {"Cloud", "Asura", "Arthur", "Lune"};
        JButton[] btns = new JButton[4];
        for (int i = 0; i < 4; i++) {
            btns[i] = createAndAddButton(chars[i], "select" + chars[i]);
        }
        setChoices(btns);
    }
    
    public void ShowCharacterStory(String name) {
        gui.getMainTextArea().setText(Story.getCharacterStory(name));
        gui.getMainTextArea().setFont(gui.getStoryFont());
        gui.getMainTextArea().setCaretPosition(0);
        addSingleButton("Begin Adventure", "startAdventure", 250, 470);
    }
    
    public void MainMenu() {
        setupPlayerPanel();
        String progress = buildProgress();
        gui.getMainTextPanel().setBounds(50, 80, 800, 200);
        gui.getMainTextArea().setText("=== " + currentWorld.toUpperCase() + " ===\n\n" +
                "Progress:\n" + progress + "\nWhat will you do?");
        gui.getMainTextArea().setFont(gui.getNormalFont());
        gui.getMainTextArea().setCaretPosition(0);
        gui.createChoiceButtonPanel(200, 300, 500, 240);
        
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
        gui.getMainTextPanel().setBounds(50, 70, 800, 380);
        gui.getMainTextArea().setText(sb.toString());
        gui.getMainTextArea().setFont(gui.getSmallFont());
        gui.getMainTextArea().setCaretPosition(0);
        addSingleButton("Back", "mainMenu", 250, 470);
    }
    
    public void StartBattle(String type) {
        currentEnemyType = type;
        currentEnemy = gameManager.createEnemy(currentWorld, type);
        gameManager.setCurrentEnemy(currentEnemy);
        
        gui.getMainTextPanel().setBounds(50, 70, 800, 270);
        gui.getMainTextArea().setText(Story.getBattleIntro(currentEnemy.getName(), type.equals("boss")) +
                "Enemy: " + currentEnemy.getName() + "\nHP: " + currentEnemy.getCurrentHP() + "/" + 
                currentEnemy.getMaxHP() + "\nATK: " + currentEnemy.getAttack() + " | DEF: " + 
                currentEnemy.getDefence() + "\n\nBattle Start!");
        gui.getMainTextArea().setFont(gui.getNormalFont());
        gui.getMainTextArea().setCaretPosition(0);
        gui.createChoiceButtonPanel(200, 340, 500, 240);
        
        JButton[] btns = new JButton[4];
        for (int i = 0; i < 3; i++) {
            String skillName;
            if (player.getSkill(i) != null) {
                skillName = player.getSkill(i).getName();
            } else {
                skillName = "Skill " + (i+1);
            }
            btns[i] = createAndAddButton(skillName, "skill" + i, gui.getSmallFont());
        }
        btns[3] = createAndAddButton("Normal Attack", "normalAttack", gui.getSmallFont());
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
                gui.getMainTextArea().setText(Story.getSkillErrorMessage(
                    player.getSkillCooldown(idx) > 0, player.getSkillCooldown(idx),
                    player.getSkill(idx).getMpCost(), player.getCurrentMP()));
                gui.getMainTextArea().setCaretPosition(0);
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
        gui.getMainTextArea().setText(battleLog);
        gui.getMainTextArea().setCaretPosition(0);
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
        
        gui.getMainTextPanel().setBounds(50, 90, 800, 310);
        gui.getMainTextArea().setText(msg);
        gui.getMainTextArea().setFont(gui.getNormalFont());
        gui.getMainTextArea().setCaretPosition(0);
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
        gui.getMainTextPanel().setBounds(50, 80, 820, 380);
        gui.getMainTextArea().setText(Story.getDefeatMessage(currentEnemy.getName()));
        gui.getMainTextArea().setFont(gui.getNormalFont());
        gui.getMainTextArea().setCaretPosition(0);
        addSingleButton("Return to Title", "gameOver", 250, 500);
    }
    
    public void FinalVictory() {
        gui.getMainTextPanel().setBounds(50, 70, 800, 380);
        gui.getMainTextArea().setText(Story.getFinalVictoryMessage(
                player.getName(), player.getClassName(), player.getLevel()));
        gui.getMainTextArea().setFont(gui.getStoryFont());
        gui.getMainTextArea().setCaretPosition(0);
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
        gui.createPlayerPanel();
        gui.getPlayerPanel().setVisible(true);
        gui.getLevelLabel().setText("Lv." + player.getLevel());
        gui.getClassLabel().setText(player.getClassName());
        updatePlayerStats();
    }
    
    private void updatePlayerStats() {
        if (gui.getHpLabelNumber() != null) 
            gui.getHpLabelNumber().setText(player.getCurrentHP() + "/" + player.getMaxHP());
        if (gui.getMpLabelNumber() != null) 
            gui.getMpLabelNumber().setText(player.getCurrentMP() + "/" + player.getMaxMP());
        if (gui.getLevelLabel() != null) 
            gui.getLevelLabel().setText("Lv." + player.getLevel());
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
        if (gui.getPlayerPanel() != null) gui.getPlayerPanel().setVisible(false);
        if (gui.getMainTextPanel() != null) gui.getMainTextPanel().setVisible(false);
        if (gui.getChoiceButtonPanel() != null) gui.getChoiceButtonPanel().setVisible(false);
        gui.getTitleNamePanel().setVisible(true);
        gui.getStartButtonPanel().setVisible(true);
    }
    
    private JButton createAndAddButton(String text, String cmd) {
        return createAndAddButton(text, cmd, gui.getNormalFont());
    }
    
    private JButton createAndAddButton(String text, String cmd, java.awt.Font font) {
        JButton btn = gui.createButton(text, cmd, font);
        btn.addActionListener(new ChoiceHandler());
        gui.getChoiceButtonPanel().add(btn);
        return btn;
    }
    
    private void addSingleButton(String text, String cmd, int x, int y) {
        gui.createSingleButtonPanel(x, y, 400, 80);
        JButton btn = gui.createButton(text, cmd, gui.getNormalFont());
        btn.addActionListener(new ChoiceHandler());
        gui.getChoiceButtonPanel().add(btn);
        gui.setChoice1(btn);
    }
    
    private void setChoices(JButton[] btns) {
        gui.setChoice1(btns[0]);
        if (btns.length > 1) gui.setChoice2(btns[1]);
        if (btns.length > 2) gui.setChoice3(btns[2]);
        if (btns.length > 3) gui.setChoice4(btns[3]);
        gui.getChoiceButtonPanel().revalidate();
        gui.getChoiceButtonPanel().repaint();
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
}
