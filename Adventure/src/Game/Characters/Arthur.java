package Game.Characters;

import Game.Skills.Skill;

public class Arthur extends Character {
	
	private int characterHp;
    private int characterMp;
    private int characterAttack;
    private int characterDefence;
    
    public Arthur() {
        super("Arthur", "Marksman", 120, 90, 55, 15);
        
        this.setCharacterHp(120);
        this.setCharacterMp(90);
        this.setCharacterAttack(55);
        this.setCharacterDefence(15);
        
        initializeSkills();
    }
    
    private void initializeSkills() {
        
    	int skill1Damage = 40;
        int skill1MpCost = 12;
        int skill1Cooldown = 0;
    	
        Skill piercingArrow = new Skill(
            "Piercing Arrow",
            "An arrow that pierces through armor",
            skill1Damage,
            skill1MpCost,
            skill1Cooldown  
        );
        
        int skill2Damage = 60;
        int skill2MpCost = 28;
        int skill2Cooldown = 3;
        
        Skill falconDash = new Skill(
            "Falcon Dash",
            "Dash like a falcon and strike with precision",
            skill2Damage,
            skill2MpCost,
            skill2Cooldown 
        );
        
        int skill3Damage = 100;
        int skill3MpCost = 45;
        int skill3Cooldown = 5;
        
        Skill criticalShot = new Skill(
            "Critical Shot",
            "A perfectly aimed shot that finds weak points",
            skill3Damage,
            skill3MpCost,
            skill3Cooldown 
        );
        
        addSkill(0, piercingArrow);
        addSkill(1, falconDash);
        addSkill(2, criticalShot);
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
