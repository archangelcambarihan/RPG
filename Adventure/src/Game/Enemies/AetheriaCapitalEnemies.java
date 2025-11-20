package Game.Enemies;

public class AetheriaCapitalEnemies {
    
    
    public static class CapitalGuard extends Enemy {
    	
    	 private int enemyHp;
         private int enemyAttack;
         private int enemyDefence;
         private int enemyExpReward;
    	
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
            
            this.setEnemyHp(80);
            this.setEnemyAttack(12);
            this.setEnemyDefence(10);
            this.setEnemyExpReward(50);
            
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
    
 
    public static class CaptainCommander extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
    	
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
            
            this.setEnemyHp(200);
            this.setEnemyAttack(22);
            this.setEnemyDefence(25);
            this.setEnemyExpReward(200);
            
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.3) {
                return attack + 15; 
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
    
   
    public static class KingOfAetheria extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
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
            
            this.setEnemyHp(300);
            this.setEnemyAttack(25);
            this.setEnemyDefence(35);
            this.setEnemyExpReward(1000);
            
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
