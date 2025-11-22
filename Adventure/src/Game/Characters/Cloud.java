package Game.Characters;

public class Cloud extends Character {
    
	private static final int HP = 150;
	private static final int MP = 80;
	private static final int ATK = 45;
	private static final int DEF = 20;
	
    public Cloud() {
        super("Cloud", "Swordsman", HP, MP, ATK, DEF);
        loadSkills(CharacterSkills.getCloudSkills());
    } 
}