package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;

import Game.Characters.Character;
import Game.Enemies.*;

public class Game {
	
	JFrame Window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, MpLabel, MpLabelNumber, classLabel, levelLabel;
	
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 58);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
	Font smallFont = new Font("Times New Roman", Font.PLAIN, 18);
	Font storyFont = new Font("Times New Roman", Font.PLAIN, 20);
	
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	
	
	GameManager gameManager;
	Character selectedCharacter;
	Enemy currentEnemy;
	
	String currentWorld = "Tera Capital";
	String currentEnemyType = "normal"; 
	boolean normalDefeated = false;
	boolean generalDefeated = false;
	boolean bossDefeated = false;
	int worldProgress = 0; 
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		gameManager = new GameManager();
		
		Window = new JFrame();
		Window.setSize(900, 650);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.getContentPane().setBackground(Color.black);
		Window.setLayout(null);
		con = Window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(50, 100, 800, 100);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Legend Of Aetheria");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 300, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);

		Window.setVisible(true);
	}
	
	public void ShowIntroduction() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 70, 800, 380);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("It was once a peaceful world of Aetheria...\n\n"
				+ "People lived in prosperity. The Kingdom of Tera was in celebration of their grand festival.\n\n"
				+ "Until...\n\n"
				+ "The seal of the Underworld was finally broken!\n\n"
				+ "Monsters attacked the world, spreading chaos and destruction.\n\n"
				+ "There is one person who is willing to do whatever it takes to restore the seal and save Aetheria...");
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(storyFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(mainTextArea);
		scrollPane.setPreferredSize(new java.awt.Dimension(780, 370));
		scrollPane.setBackground(Color.black);
		scrollPane.getViewport().setBackground(Color.black);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		mainTextPanel.add(scrollPane);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 470, 400, 80);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		con.add(choiceButtonPanel);
		
		choice1 = createButton("Continue", "showCharSelect");
		choiceButtonPanel.add(choice1);
	}
	
	public void CharacterSelection() {
		mainTextPanel.setBounds(50, 70, 800, 220);
		
		mainTextArea.setText("Choose your hero:\n\n"
				+ "Cloud - Swordsman\n"
				+ "Asura - Brawler\n"
				+ "Arthur - Marksman\n"
				+ "Lune - Mage");
		mainTextArea.setFont(normalFont);
		mainTextArea.setCaretPosition(0);
		
		choiceButtonPanel.setBounds(200, 310, 500, 240);
		choiceButtonPanel.setLayout(new GridLayout(4,1,0,10));
		choiceButtonPanel.removeAll();
		
		choice1 = createButton("Cloud", "selectCloud");
		choice2 = createButton("Asura", "selectAsura");
		choice3 = createButton("Arthur", "selectArthur");
		choice4 = createButton("Lune", "selectLune");
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
	}
	
	public void ShowCharacterStory(String characterName) {
		String story = "";
		
		switch(characterName.toLowerCase()) {
			case "cloud":
				story = "=== CLOUD ===\n\n"
						+ "A wandering swordsman with a mysterious past.\n\n"
						+ "Calm but determined, he wields his blade with precision.\n\n"
						+ "When darkness threatens Aetheria, Cloud draws his sword to protect the innocent.";
				break;
			case "asura":
				story = "=== ASURA ===\n\n"
						+ "A street fighter from the slums who seeks stronger opponents.\n\n"
						+ "Trying to prove that he can be on top.\n\n"
						+ "The broken seal has unleashed powerful foes - the perfect challenge for Asura!";
				break;
			case "arthur":
				story = "=== ARTHUR ===\n\n"
						+ "A hunter from the northern Forest of Aetheria.\n\n"
						+ "When monsters began to invade, he vowed to use his bow to defend the innocent.\n\n"
						+ "His arrows never miss their mark.";
				break;
			case "lune":
				story = "=== LUNE ===\n\n"
						+ "A top graduate at the Magic Academy.\n\n"
						+ "In thirst for knowledge, she travels the kingdom until the seal broke.\n\n"
						+ "This phenomenon has piqued her interest and she wants to explore it with her magic.";
				break;
		}
		
		mainTextArea.setText(story);
		mainTextArea.setFont(storyFont);
		mainTextArea.setCaretPosition(0);
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(250, 470, 400, 80);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		
		choice1 = createButton("Begin Adventure", "startAdventure");
		choiceButtonPanel.add(choice1);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
	}
	
	public void MainMenu() {
		setupPlayerPanel();
		
		String worldName = getWorldName();
		
		String progress = "";
		if (normalDefeated) progress += "[/] Normal Enemy\n";
		else progress += "[ ] Normal Enemy\n";
		if (generalDefeated) progress += "[/] General\n";
		else progress += "[ ] General\n";
		if (bossDefeated) progress += "[/] Boss\n";
		else progress += "[ ] Boss\n";
		
		mainTextPanel.setBounds(50, 80, 800, 200);
		
		mainTextArea.setText("=== " + worldName.toUpperCase() + " ===\n\n"
				+ "Progress:\n" + progress + "\n"
				+ "What will you do?");
		mainTextArea.setFont(normalFont);
		mainTextArea.setCaretPosition(0);
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(200, 300, 500, 240);
		choiceButtonPanel.setLayout(new GridLayout(4,1,0,10));
		
		choice1 = createButton("Fight Normal", "fightNormal");
		choice2 = createButton("Fight General", "fightGeneral");
		choice3 = createButton("Fight Boss", "fightBoss");
		choice4 = createButton("View Status", "viewStatus");
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
		updatePlayerStats();
	}
	
	public void ViewStatus() {
		String status = "=== CHARACTER STATUS ===\n\n";
		status += "Name: " + selectedCharacter.getName() + "\n";
		status += "Class: " + selectedCharacter.getClassName() + "\n";
		status += "Level: " + selectedCharacter.getLevel() + "\n";
		status += "EXP: " + selectedCharacter.getCurrentExp() + " / " + selectedCharacter.getExpToNextLevel() + "\n\n";
		status += "HP: " + selectedCharacter.getCurrentHP() + " / " + selectedCharacter.getMaxHP() + "\n";
		status += "MP: " + selectedCharacter.getCurrentMP() + " / " + selectedCharacter.getMaxMP() + "\n";
		status += "Attack: " + selectedCharacter.getAttack() + "\n";
		status += "Defence: " + selectedCharacter.getDefence() + "\n\n";
		
		status += "=== SKILLS ===\n";
		for (int i = 0; i < 3; i++) {
			if (selectedCharacter.getSkill(i) != null) {
				status += (i + 1) + ". " + selectedCharacter.getSkill(i).getName() + "\n";
				status += "   DMG: " + selectedCharacter.getSkill(i).getDamage();
				status += " | MP: " + selectedCharacter.getSkill(i).getMpCost();
				status += " | CD: " + selectedCharacter.getSkill(i).getCooldown() + "\n";
			}
		}
		
		status += "\n=== PROGRESS ===\n";
		status += "Current World: " + getWorldName() + "\n";
		if (normalDefeated) {
			status += "[/] Normal\n";
		} else {
			status += "[ ] Normal\n";
		}
		if (generalDefeated) {
			status += "[/] General\n";
		} else {
			status += "[ ] General\n";
		}
		if (bossDefeated) {
			status += "[/] Boss";
		} else {
			status += "[ ] Boss";
		}
		
		mainTextPanel.setBounds(50, 70, 800, 380);
		
		mainTextArea.setText(status);
		mainTextArea.setFont(smallFont);
		mainTextArea.setCaretPosition(0);
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(250, 470, 400, 70);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		
		choice1 = createButton("Back", "mainMenu");
		choiceButtonPanel.add(choice1);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
	}
	
	public void StartBattle(String type) {
		currentEnemyType = type;
		currentEnemy = gameManager.createEnemy(currentWorld, type);
		gameManager.setCurrentEnemy(currentEnemy);
		
		String intro = "";
		
		if (type.equals("boss")) {
			intro = "=== BOSS BATTLE ===\n\n";
			intro += currentEnemy.getName() + " appears!\n\n";
		} else {
			intro = "A " + currentEnemy.getName() + " appears!\n\n";
		}
		
		mainTextPanel.setBounds(50, 70, 800, 270);
		
		mainTextArea.setText(intro + 
				"Enemy: " + currentEnemy.getName() + "\n"
				+ "HP: " + currentEnemy.getCurrentHP() + "/" + currentEnemy.getMaxHP() + "\n"
				+ "ATK: " + currentEnemy.getAttack() + " | DEF: " + currentEnemy.getDefence() + "\n\n"
				+ "Battle Start!");
		mainTextArea.setFont(normalFont);
		mainTextArea.setCaretPosition(0); 
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(200, 340, 500, 240);
		choiceButtonPanel.setLayout(new GridLayout(4,1,0,10));
		
		
		if (selectedCharacter.getSkill(0) != null) {
			choice1 = createButton(selectedCharacter.getSkill(0).getName(), "skill0", smallFont);
		} else {
			choice1 = createButton("Skill 1", "skill0", smallFont);
		}
		
		if (selectedCharacter.getSkill(1) != null) {
			choice2 = createButton(selectedCharacter.getSkill(1).getName(), "skill1", smallFont);
		} else {
			choice2 = createButton("Skill 2", "skill1", smallFont);
		}
		
		if (selectedCharacter.getSkill(2) != null) {
			choice3 = createButton(selectedCharacter.getSkill(2).getName(), "skill2", smallFont);
		} else {
			choice3 = createButton("Skill 3", "skill2", smallFont);
		}
		
		choice4 = createButton("Normal Attack", "normalAttack", smallFont);
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
		updatePlayerStats();
	}
	
	public void PlayerTurn(String action) {
		String battleLog = "";
		
		
		selectedCharacter.restoreMP(10);
		
		if (action.equals("normalAttack")) {
			int damage = selectedCharacter.getAttack();
			currentEnemy.takeDamage(damage);
			
			battleLog = selectedCharacter.getName() + " performs a Normal Attack!\n"
					+ "Dealt " + damage + " damage!\n\n";
			
			if (!currentEnemy.isAlive()) {
				BattleVictory();
				return;
			}
			
			selectedCharacter.reduceCooldowns();
			battleLog += EnemyTurn();
			
		} else if (action.startsWith("skill")) {
			int skillIndex = Integer.parseInt(action.substring(5));
			
			if (!selectedCharacter.canUseSkill(skillIndex)) {
				int cooldown = selectedCharacter.getSkillCooldown(skillIndex);
				String errorMessage = "Cannot use this skill!\n\n";
				
				if (cooldown > 0) {
					errorMessage += "Cooldown: " + cooldown + " turns\n";
				} else {
					errorMessage += "Not enough MP!\n";
				}
				
				errorMessage += "MP Cost: " + selectedCharacter.getSkill(skillIndex).getMpCost() + "\n";
				errorMessage += "Current MP: " + selectedCharacter.getCurrentMP();
				
				mainTextArea.setText(errorMessage);
				mainTextArea.setCaretPosition(0);
				return;
			}
			
			int damage = selectedCharacter.useSkill(skillIndex);
			currentEnemy.takeDamage(damage);
			
			battleLog = "You used " + selectedCharacter.getSkill(skillIndex).getName() + "!\n"
					+ "Dealt " + damage + " damage!\n\n";
			
			if (!currentEnemy.isAlive()) {
				BattleVictory();
				return;
			}
			
			selectedCharacter.reduceCooldowns();
			battleLog += EnemyTurn();
		}
		
		if (!selectedCharacter.isAlive()) {
			BattleDefeat();
			return;
		}
		
		battleLog += "\n--- Your Turn ---\n"
				+ "Enemy HP: " + currentEnemy.getCurrentHP() + "/" + currentEnemy.getMaxHP()
				+ "\nRecovered 10 MP!";
		
		mainTextArea.setText(battleLog);
		mainTextArea.setCaretPosition(0);
		updatePlayerStats();
	}
	
	public String EnemyTurn() {
		int damage = currentEnemy.attackPlayer();
		selectedCharacter.takeDamage(damage);
		
		return currentEnemy.getName() + " attacks!\n"
				+ "You take " + damage + " damage!\n";
	}
	
	public void BattleVictory() {
		String message = currentEnemy.getName() + " has been defeated!\n\n";
		
		int expGained = currentEnemy.getExpReward();
		message += "Victory! You gained " + expGained + " EXP!\n";
		
		
		boolean leveledUp = selectedCharacter.addExp(expGained);
		
		if (leveledUp) {
			message += "\n= LEVEL UP! =\n";
			message += "You are now Level " + selectedCharacter.getLevel() + "!\n";
			message += "HP +20  |  MP +15  |  ATK +5  |  DEF +2\n";
		}
		
		message += "\n";
		
		selectedCharacter.heal(50);
		selectedCharacter.restoreMP(30);
		message += "Restored 50 HP and 30 MP!\n\n";
		
		if (currentEnemyType.equals("normal")) {
			normalDefeated = true;
		} else if (currentEnemyType.equals("general")) {
			generalDefeated = true;
		} else if (currentEnemyType.equals("boss")) {
			bossDefeated = true;
			
			if (normalDefeated && generalDefeated && bossDefeated) {
				if (worldProgress == 0) {
					message += "Tera Capital has been saved!\n";
					message += "The path to the Forest opens!";
				} else if (worldProgress == 1) {
					message += "The Forest is safe!\n";
					message += "The Underworld awaits!";
				} else if (worldProgress == 2) {
					FinalVictory();
					return;
				}
			}
		}
		
		mainTextPanel.setBounds(50, 90, 800, 280);
		
		mainTextArea.setText(message);
		mainTextArea.setFont(normalFont);
		mainTextArea.setCaretPosition(0); 
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(250, 400, 400, 80);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		
		String command;
		if (normalDefeated && generalDefeated && bossDefeated && worldProgress < 2) {
			command = "nextWorld";
		} else {
			command = "mainMenu";
		}
		choice1 = createButton("Continue", command);
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
		updatePlayerStats();
	}
	
	public void NextWorld() {
		worldProgress++;
		normalDefeated = false;
		generalDefeated = false;
		bossDefeated = false;
		
		if (worldProgress == 1) {
			currentWorld = "Forest of Aetheria";
		} else if (worldProgress == 2) {
			currentWorld = "Underworld";
		}
		
		MainMenu();
	}
	
	public void BattleDefeat() {
		mainTextPanel.setBounds(50, 80, 800, 385);
		
		mainTextArea.setText("=== DEFEAT ===\n\n"
				+ "YOU HAVE BEEN DEFEATED!\n\n"
				+ currentEnemy.getName() + " has bested you.\n\n"
				+ "The darkness spreads across Aetheria...\n"
				+ "The world falls into despair.\n"
				+ "Hope fades as evil triumphs.\n\n"
				+ "GAME OVER\n\n"
				+ "Do not give up, hero!\n"
				+ "Return and save Aetheria!");
		mainTextArea.setFont(normalFont);
		mainTextArea.setCaretPosition(0); 
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(250, 450, 400, 80);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		
		choice1 = createButton("Return to Title", "gameOver");
		choiceButtonPanel.add(choice1);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
	}
	
	public void FinalVictory() {
		mainTextPanel.setBounds(50, 70, 800, 380);
		
		mainTextArea.setText("=== ULTIMATE VICTORY ===\n\n"
				+ "Dark Lord Azrael falls, his dark powers fading into nothingness!\n\n"
				+ "The Underworld seal is restored!\n"
				+ "Light returns to all of Aetheria!\n\n"
				+ "You have conquered:\n"
				+ "[/] Tera Capital\n"
				+ "[/] Forest of Aetheria\n"
				+ "[/] Underworld\n\n"
				+ "Peace returns to the kingdom!\n"
				+ "Your legend will live forever!\n\n"
				+ selectedCharacter.getName() + " the " 
				+ selectedCharacter.getClassName() + "\n"
				+ "Level " + selectedCharacter.getLevel() + " Hero\n"
				+ "HERO OF AETHERIA!\n\n"
				+ "= CONGRATULATIONS =");
		mainTextArea.setFont(storyFont);
		mainTextArea.setCaretPosition(0);
		
		choiceButtonPanel.removeAll();
		choiceButtonPanel.setBounds(250, 470, 400, 70);
		choiceButtonPanel.setLayout(new GridLayout(1,1));
		
		choice1 = createButton("Return to Title", "gameOver");
		choiceButtonPanel.add(choice1);
		
		choiceButtonPanel.revalidate();
		choiceButtonPanel.repaint();
	}
	
	public String getWorldName() {
		return currentWorld;
	}
	
	public void setupPlayerPanel() {
		if (playerPanel == null) {
			playerPanel = new JPanel();
			playerPanel.setBounds(50, 15, 800, 50);
			playerPanel.setBackground(Color.black);
			playerPanel.setLayout(new GridLayout(1,6));
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
			
			MpLabel = new JLabel("MP:");
			MpLabel.setFont(smallFont);
			MpLabel.setForeground(Color.white);
			playerPanel.add(MpLabel);
			
			MpLabelNumber = new JLabel();
			MpLabelNumber.setFont(smallFont);
			MpLabelNumber.setForeground(Color.white);
			playerPanel.add(MpLabelNumber);
		}
		
		playerPanel.setVisible(true);
		levelLabel.setText("Lv." + selectedCharacter.getLevel());
		classLabel.setText(selectedCharacter.getClassName());
		updatePlayerStats();
	}
	
	public void updatePlayerStats() {
		if (hpLabelNumber != null && MpLabelNumber != null) {
			hpLabelNumber.setText(selectedCharacter.getCurrentHP() + 
					"/" + selectedCharacter.getMaxHP());
			MpLabelNumber.setText(selectedCharacter.getCurrentMP() + 
					"/" + selectedCharacter.getMaxMP());
		}
		if (levelLabel != null) {
			levelLabel.setText("Lv." + selectedCharacter.getLevel());
		}
	}
	
	public void selectCharacter(String characterName) {
		selectedCharacter = gameManager.createCharacter(characterName);
		gameManager.setPlayer(selectedCharacter);
	}
	
	public void resetGame() {
		worldProgress = 0;
		currentWorld = "Tera Capital";
		currentEnemyType = "normal";
		normalDefeated = false;
		generalDefeated = false;
		bossDefeated = false;
		currentEnemy = null;
		selectedCharacter = null;
		
		if (playerPanel != null) playerPanel.setVisible(false);
		if (mainTextPanel != null) mainTextPanel.setVisible(false);
		if (choiceButtonPanel != null) choiceButtonPanel.setVisible(false);
		
		titleNamePanel.setVisible(true);
		startButtonPanel.setVisible(true);
	}
	
	
	private JButton createButton(String text, String command) {
		return createButton(text, command, normalFont);
	}
	
	
	private JButton createButton(String text, String command, Font font) {
		JButton button = new JButton(text);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFocusPainted(false);
		button.setFont(font);
		button.addActionListener(choiceHandler);
		button.setActionCommand(command);
		return button;
	}
	
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ShowIntroduction();
		}
	}
	
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String choice = event.getActionCommand();
			
			if (choice.equals("showCharSelect")) {
				CharacterSelection();
			}
			else if (choice.equals("selectCloud")) {
				selectCharacter("Cloud");
				ShowCharacterStory("Cloud");
			} else if (choice.equals("selectAsura")) {
				selectCharacter("Asura");
				ShowCharacterStory("Asura");
			} else if (choice.equals("selectArthur")) {
				selectCharacter("Arthur");
				ShowCharacterStory("Arthur");
			} else if (choice.equals("selectLune")) {
				selectCharacter("Lune");
				ShowCharacterStory("Lune");
			}
			else if (choice.equals("startAdventure")) {
				MainMenu();
			}
			else if (choice.equals("mainMenu")) {
				MainMenu();
			} else if (choice.equals("viewStatus")) {
				ViewStatus();
			}
			else if (choice.equals("fightNormal")) {
				StartBattle("normal");
			} else if (choice.equals("fightGeneral")) {
				StartBattle("general");
			} else if (choice.equals("fightBoss")) {
				StartBattle("boss");
			}
			else if (choice.startsWith("skill") || choice.equals("normalAttack")) {
				PlayerTurn(choice);
			}
			else if (choice.equals("nextWorld")) {
				NextWorld();
			}
			else if (choice.equals("gameOver")) {
				resetGame();
			}
		}
	}

}
