package Game.Characters;

public class Lune extends Character {
    
	private static final int HP = 100;
	private static final int MP = 150;
	private static final int ATK = 40;
	private static final int DEF = 10;
	
    public Lune() {
        super("Lune", "Mage", HP, MP, ATK, DEF);
        loadSkills(CharacterSkills.getLuneSkills());
    }
}
