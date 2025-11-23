package Game.Characters;

public class Asura extends Character {
    
	private static final int HP = 180;
	private static final int MP = 60;
	private static final int ATK = 50;
	private static final int DEF = 20;
	
    public Asura() {
        super("Asura", "Brawler", HP, MP, ATK, DEF);
        loadSkills(CharacterSkills.getAsuraSkills());
    }
}
