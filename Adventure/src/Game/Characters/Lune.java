package Game.Characters;

import Game.Skills.Skill;

public class Lune extends Character {
    
	private int characterHp;
    private int characterMp;
    private int characterAttack;
    private int characterDefence;
	
    public Lune() {
        super("Lune", "Mage", 100, 150, 40, 10);
        
        this.setCharacterHp(100);
        this.setCharacterMp(150);
        this.setCharacterAttack(40);
        this.setCharacterDefence(10);
        
        initializeSkills();
    }
    
    private void initializeSkills() {
        
    	int skill1Damage = 45;
        int skill1MpCost = 15;
        int skill1Cooldown = 0;
    	
        Skill fireball = new Skill(
            "Fireball",
            "Launch a blazing ball of fire",
            skill1Damage,
            skill1MpCost,
            skill1Cooldown
        );
        
        int skill2Damage = 65;
        int skill2MpCost = 30;
        int skill2Cooldown = 3;
        
        Skill lightningChain = new Skill(
            "Lightning Chain",
            "Summon lightning that chains between targets",
            skill2Damage,
            skill2MpCost,
            skill2Cooldown 
        );
        
        int skill3Damage = 110;
        int skill3MpCost = 50;
        int skill3Cooldown = 5;
        
        Skill meteorStrike = new Skill(
            "Meteor Strike",
            "Call down a devastating meteor from the sky",
            skill3Damage,
            skill3MpCost,
            skill3Cooldown
        );
        
        addSkill(0, fireball);
        addSkill(1, lightningChain);
        addSkill(2, meteorStrike);
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
