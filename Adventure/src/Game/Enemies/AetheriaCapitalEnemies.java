package Game.Enemies;

public class AetheriaCapitalEnemies {
    
    
    public static class CapitalGuard extends Enemy {
        public CapitalGuard() {
            super(
                "Capital Guard",
                "Normal",
                80,   
                12,   
                10,   
                50,  
                "Aetheria Capital"
            );
        }
    }
    
 
    public static class CaptainCommander extends Enemy {
        public CaptainCommander() {
            super(
                "Captain Commander",
                "General",
                200, 
                22,  
                25,  
                200, 
                "Aetheria Capital"
            );
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.3) {
                return attack + 15; 
            }
            return attack;
        }
    }
    
   
    public static class KingOfAetheria extends Enemy {
        private boolean enraged = false;
        
        public KingOfAetheria() {
            super(
                "King of Aetheria",
                "Boss",
                300,  
                25,   
                35,  
                1000, 
                "Aetheria Capital"
            );
        }
        
        @Override
        public int attackPlayer() {
            
            if (currentHP < maxHP * 0.3 && !enraged) {
                enraged = true;
                attack += 20;
            }
            
            
            double rand = Math.random();
            if (rand < 0.2) {
                return attack + 30;
            } else if (rand < 0.4) {
                return attack + 15; 
            }
            return attack;
        }
    }
}