package Game.Enemies;

public class ForestOfAetheriaEnemies {
    
   
    public static class WildBeast extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
    	
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
            
            this.setEnemyHp(100);
            this.setEnemyAttack(23);
            this.setEnemyDefence(12);
            this.setEnemyExpReward(75);
            
        }
        
        public int getEnemyHp() {
			return enemyHp;
		}

		public void setEnemyHp(int enemyHp) {
			this.enemyHp = enemyHp;
		}
		@Override
		public int getAttack() {
			return enemyAttack;
		}

		public void setEnemyAttack(int enemyAttack) {
			this.enemyAttack = enemyAttack;
		}
		@Override
		public int getDefence() {
			return enemyDefence;
		}

		public void setEnemyDefence(int enemyDefence) {
			this.enemyDefence = enemyDefence;
		}
		@Override
		public int getExpReward() {
			return enemyExpReward;
		}

		public void setEnemyExpReward(int enemyExpReward) {
			this.enemyExpReward = enemyExpReward;
		}
    }
    
    
    public static class ForestGuardian extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;

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
            
            this.setEnemyHp(250);
            this.setEnemyAttack(26);
            this.setEnemyDefence(30);
            this.setEnemyExpReward(300);
            
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.25) {
                return attack + 20; 
            }
            return attack;
        }
        
        public int getEnemyHp() {
			return enemyHp;
		}

		public void setEnemyHp(int enemyHp) {
			this.enemyHp = enemyHp;
		}
		@Override
		public int getAttack() {
			return enemyAttack;
		}

		public void setEnemyAttack(int enemyAttack) {
			this.enemyAttack = enemyAttack;
		}
		@Override
		public int getDefence() {
			return enemyDefence;
		}

		public void setEnemyDefence(int enemyDefence) {
			this.enemyDefence = enemyDefence;
		}
		@Override
		public int getExpReward() {
			return enemyExpReward;
		}

		public void setEnemyExpReward(int enemyExpReward) {
			this.enemyExpReward = enemyExpReward;
		}
    }
    
   
    public static class AncientTreelord extends Enemy {
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
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
            
            this.setEnemyHp(350);
            this.setEnemyAttack(31);
            this.setEnemyDefence(40);
            this.setEnemyExpReward(1500);
            
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
        
        public int getEnemyHp() {
			return enemyHp;
		}

		public void setEnemyHp(int enemyHp) {
			this.enemyHp = enemyHp;
		}
		@Override
		public int getAttack() {
			return enemyAttack;
		}

		public void setEnemyAttack(int enemyAttack) {
			this.enemyAttack = enemyAttack;
		}
		@Override
		public int getDefence() {
			return enemyDefence;
		}

		public void setEnemyDefence(int enemyDefence) {
			this.enemyDefence = enemyDefence;
		}
		@Override
		public int getExpReward() {
			return enemyExpReward;
		}

		public void setEnemyExpReward(int enemyExpReward) {
			this.enemyExpReward = enemyExpReward;
		}
    }
}
