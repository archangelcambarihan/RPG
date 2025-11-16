package Game.Enemies;

public class UnderworldEnemies {
    
   
    public static class DemonImps extends Enemy {
        public DemonImps() {
            super(
                "Demon Imps",
                "Normal",
                120, 
                31,   
                15,  
                100,  
                "Underworld"
            );
        }
    }
    
    
    public static class InfernalKnight extends Enemy {
        public InfernalKnight() {
            super(
                "Infernal Knight",
                "General",
                300, 
                35,   
                35, 
                400,  
                "Underworld"
            );
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.35) {
                return attack + 25; 
            }
            return attack;
        }
    }
    
    
    public static class DarkLordAzrael extends Enemy {
        private int phase = 1;
        private boolean hasUsedDarkRitual = false;
        
        public DarkLordAzrael() {
            super(
                "Dark Lord Azrael",
                "Boss",
                400,  
                40,   
                45,  
                2500, 
                "Underworld"
            );
        }
        
        @Override
        public int attackPlayer() {
            
            if (currentHP < maxHP * 0.5 && phase == 1) {
                phase = 2;
                attack += 15;
                defence += 10;
            }
            
           
            if (currentHP < maxHP * 0.2 && !hasUsedDarkRitual) {
                hasUsedDarkRitual = true;
                currentHP += 200; // Heal
                attack += 20;
            }
            
            
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
    }
}