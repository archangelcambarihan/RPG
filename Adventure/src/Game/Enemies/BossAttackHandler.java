package Game.Enemies;

public class BossAttackHandler {
    
    public static int calculateDarkLordAttack(Enemy boss, int phase, boolean hasUsedDarkRitual) {
        int attack = boss.getAttack();
        
        double rand = Math.random();
        if (phase >= 2) {
            if (rand < 0.4) {
                return attack + 40;
            } else if (rand < 0.6) {
                return attack + 25;
            }
        } else {
            if (rand < 0.3) {
                return attack + 20;
            }
        }
        return attack;
    }
    
    public static PhaseUpdate checkPhaseTransition(Enemy boss, int currentPhase, boolean hasUsedDarkRitual) {
        int currentHP = boss.getCurrentHP();
        int maxHP = boss.getMaxHP();
        int newPhase = currentPhase;
        boolean ritualUsed = hasUsedDarkRitual;
        int attackBonus = 0;
        int defenceBonus = 0;
        int healAmount = 0;
        
        if (currentHP < maxHP * 0.5 && currentPhase == 1) {
            newPhase = 2;
            attackBonus = 15;
            defenceBonus = 10;
        }
        
        if (currentHP < maxHP * 0.2 && !hasUsedDarkRitual) {
            ritualUsed = true;
            healAmount = 200;
            attackBonus += 20;
        }
        
        return new PhaseUpdate(newPhase, ritualUsed, attackBonus, defenceBonus, healAmount);
    }
    
    public static class PhaseUpdate {
        public int phase;
        public boolean hasUsedDarkRitual;
        public int attackBonus;
        public int defenceBonus;
        public int healAmount;
        
        public PhaseUpdate(int phase, boolean hasUsedDarkRitual, int attackBonus, int defenceBonus, int healAmount) {
            this.phase = phase;
            this.hasUsedDarkRitual = hasUsedDarkRitual;
            this.attackBonus = attackBonus;
            this.defenceBonus = defenceBonus;
            this.healAmount = healAmount;
        }
    }
}