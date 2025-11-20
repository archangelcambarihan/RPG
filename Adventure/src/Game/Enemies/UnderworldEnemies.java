package Game.Enemies;

public class UnderworldEnemies {
    
   
    public static class DemonImps extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
    	
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
            
            this.setEnemyHp(120);
            this.setEnemyAttack(31);
            this.setEnemyDefence(15);
            this.setEnemyExpReward(100);
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
    
    
    public static class InfernalKnight extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
    	
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
            
            this.setEnemyHp(300);
            this.setEnemyAttack(35);
            this.setEnemyDefence(35);
            this.setEnemyExpReward(400);
            
        }
        
        @Override
        public int attackPlayer() {
            
            if (Math.random() < 0.35) {
                return attack + 25; 
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
    
    
    public static class DarkLordAzrael extends Enemy {
    	
    	private int enemyHp;
        private int enemyAttack;
        private int enemyDefence;
        private int enemyExpReward;
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
            
            this.setEnemyHp(400);
            this.setEnemyAttack(40);
            this.setEnemyDefence(45);
            this.setEnemyExpReward(2500);
            
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
