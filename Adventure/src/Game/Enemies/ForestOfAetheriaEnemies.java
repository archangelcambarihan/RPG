package Game.Enemies;

public class ForestOfAetheriaEnemies {
    
   
    public static class WildBeast extends Enemy {
        public WildBeast() {
            super(
                "Wild Beast",
                "Normal",
                100, 
                23,   
                12,   
                75,  
                "Forest of Aetheria"
            );
        }
    }
    
    
    public static class ForestGuardian extends Enemy {
        public ForestGuardian() {
            super(
                "Forest Guardian",
                "General",
                250,  
                26,   
                30,  
                300,  
                "Forest of Aetheria"
            );
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.25) {
                return attack + 20; 
            }
            return attack;
        }
    }
    
   
    public static class AncientTreelord extends Enemy {
        private int turnCounter = 0;
        
        public AncientTreelord() {
            super(
                "Ancient Treelord",
                "Boss",
                350,  
                31,   
                40,   
                1500, 
                "Forest of Aetheria"
            );
        }
        
        @Override
        public int attackPlayer() {
            turnCounter++;
            
           
            if (turnCounter % 3 == 0) {
                int healAmount = 50;
                currentHP += healAmount;
                if (currentHP > maxHP) currentHP = maxHP;
            }
            
            
            double rand = Math.random();
            if (rand < 0.3) {
                return attack + 25; 
            } else if (rand < 0.5) {
                return attack + 10; 
            }
            return attack;
        }
    }
}