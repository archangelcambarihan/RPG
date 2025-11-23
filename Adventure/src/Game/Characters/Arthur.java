package Game.Characters;

public class Arthur extends Character {
	
	private static final int HP = 120;
	private static final int MP = 90;
	private static final int ATK = 55;
	private static final int DEF = 20;
    
    public Arthur() {
        super("Arthur", "Marksman", HP, MP, ATK, DEF);
        loadSkills(CharacterSkills.getArthurSkills());
    }
}
