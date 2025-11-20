package Game.Characters;

import Game.Skills.Skill;

public class Cloud extends Character {
	
	private int characterHp;
    private int characterMp;
    private int characterAttack;
    private int characterDefence;
    
    public Cloud() {
        super("Cloud", "Swordsman", 150, 80, 45, 20);
        
        this.setCharacterHp(150);
        this.setCharacterMp(80);
        this.setCharacterAttack(45);
        this.setCharacterDefence(20);
        
        initializeSkills();
    }
    
    private void initializeSkills() {
       
    	int skill1Damage = 30;
        int skill1MpCost = 10;
        int skill1Cooldown = 0;
        
        Skill slash = new Skill(
            "Slash",
            "A quick sword slash",
            skill1Damage,
            skill1MpCost,
            skill1Cooldown  
        );
        
        int skill2Damage = 50;
        int skill2MpCost = 25;
        int skill2Cooldown = 2;
        
        Skill bladeRush = new Skill(
            "Blade Rush",
            "Rush forward with a powerful blade strike",
            skill2Damage,
            skill2MpCost,
            skill2Cooldown  
        );
        
        int skill3Damage = 85;
        int skill3MpCost = 40;
        int skill3Cooldown = 4;
        
        Skill heroStrike = new Skill(
            "Hero's Strike",
            "A legendary strike that channels heroic power",
            skill3Damage,
            skill3MpCost,
            skill3Cooldown  
        );
        
        addSkill(0, slash);
        addSkill(1, bladeRush);
        addSkill(2, heroStrike);
    }

	public int getCharacterHp() {
		return characterHp;
	}

	public void setCharacterHp(int characterHp) {
		this.characterHp = characterHp;
	}

	public int getCharacterMp() {
		return characterMp;
	}

	public void setCharacterMp(int characterMp) {
		this.characterMp = characterMp;
	}
	
	@Override
	public int getAttack() {
		return characterAttack;
	}

	public void setCharacterAttack(int characterAttack) {
		this.characterAttack = characterAttack;
	}
	
	@Override
	public int getDefence() {
		return characterDefence;
	}

	public void setCharacterDefence(int characterDefence) {
		this.characterDefence = characterDefence;
	}
}
