package Game.Enemies;

public class AetheriaCapitalEnemies {
    
    public static class CapitalGuard extends Enemy {
    	private static final int HP = 80;
    	private static final int ATK = 27;
    	private static final int DEF = 12;
    	private static final int EXP = 12;
    	
        public CapitalGuard() {
            super("Capital Guard","Normal", HP, ATK, DEF, EXP, "Aetheria Capital");
        }
    }
    
 
    public static class CaptainCommander extends Enemy {
    	private static final int HP = 200;
    	private static final int ATK = 32;
    	private static final int DEF = 25;
    	private static final int EXP = 200;
    	
        public CaptainCommander() {
            super("Captain Commander", "General", HP, ATK, DEF, EXP, "Aetheria Capital");
        } 
    }
    
   
    public static class KingOfAetheria extends Enemy {
    	private static final int HP = 300;
    	private static final int ATK = 38;
    	private static final int DEF = 25;
    	private static final int EXP = 1000;
        
        public KingOfAetheria() {
            super("King of Aetheria", "Boss", HP, ATK, DEF, EXP, "Aetheria Capital");
        }
    }
}
