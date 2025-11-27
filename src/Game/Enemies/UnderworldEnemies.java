package Game.Enemies;

public class UnderworldEnemies {
    
    public static class DemonImps extends Enemy {
    	private static final int HP = 120;
    	private static final int ATK = 35;
    	private static final int DEF = 15;
    	private static final int EXP = 300;
    	
        public DemonImps() {
            super("Demon Imps", "Normal", HP, ATK, DEF, EXP, "Underworld");
        }
    }
    
    public static class InfernalKnight extends Enemy {
    	private static final int HP = 300;
    	private static final int ATK = 38;
    	private static final int DEF = 24;
    	private static final int EXP = 400;
    	
        public InfernalKnight() {
            super("Infernal Knight", "General", HP, ATK, DEF, EXP, "Underworld");
        }
    }
    
    public static class DarkLordAzrael extends Enemy {
    	private static final int DEFLT_HP = 400;
    	private static final int DEFLT_ATK = 47;
    	private static final int DEFLT_DEF = 31;
    	private static final int DEFLT_EXP = 3500;
        private int phase = 1;
        private boolean hasUsedDarkRitual = false;
        
        public DarkLordAzrael() {
            super("Dark Lord Azrael", "Boss", DEFLT_HP, DEFLT_ATK, DEFLT_DEF, DEFLT_EXP, "Underworld");
        }
        @Override
        public int attackPlayer() {
            BossAttackHandler.PhaseUpdate update = 
            		BossAttackHandler.checkPhaseTransition(this, phase, hasUsedDarkRitual);
            
            if (update.phase != phase) {
                phase = update.phase;
                attack += update.attackBonus;
                defence += update.defenceBonus;
            }
            
            if (update.healAmount > 0) {
                currentHP += update.healAmount;
                attack += update.attackBonus;
            }
            
            hasUsedDarkRitual = update.hasUsedDarkRitual;
            return BossAttackHandler.calculateDarkLordAttack(this, phase, hasUsedDarkRitual);
        }
    }
}