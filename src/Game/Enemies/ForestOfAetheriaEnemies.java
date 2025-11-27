package Game.Enemies;

public class ForestOfAetheriaEnemies {
   
    public static class WildBeast extends Enemy {
    	private static final int HP = 100;
    	private static final int ATK = 30;
    	private static final int DEF = 12;
    	private static final int EXP = 75;
    	
        public WildBeast() {
            super("Wild Beast", "Normal", HP, ATK, DEF, EXP, "Forest of Aetheria");
        }
    }
    
    
    public static class ForestGuardian extends Enemy {
    	private static final int HP = 250;
    	private static final int ATK = 35;
    	private static final int DEF = 23;
    	private static final int EXP = 500;
    	
        public ForestGuardian() {
            super("Forest Guardian", "General", HP, ATK, DEF, EXP, "Forest of Aetheria");
        }
    }
    
   
    public static class AncientTreelord extends Enemy {
    	private static final int HP = 350;
    	private static final int ATK = 40;
    	private static final int DEF = 26;
    	private static final int EXP = 2500;
        
        public AncientTreelord() {
            super("Ancient Treelord", "Boss",HP, ATK, DEF, EXP, "Forest of Aetheria");
        }
    }
}