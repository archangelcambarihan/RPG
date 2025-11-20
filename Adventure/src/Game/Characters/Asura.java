package Game.Characters;

import Game.Skills.Skill;

public class Asura extends Character {
	
	private int characterHp;
    private int characterMp;
    private int characterAttack;
    private int characterDefence;
    
    public Asura() {
        super("Asura", "Brawler", 180, 60, 50, 25);
        
        this.setCharacterHp(180);
        this.setCharacterMp(60);
        this.setCharacterAttack(50);
        this.setCharacterDefence(25);
        
        initializeSkills();
    }
    
    private void initializeSkills() {
        
    	int skill1Damage = 35;
        int skill1MpCost = 8;
        int skill1Cooldown = 0;
    	
        Skill powerPunch = new Skill(
            "Power Punch",
            "A devastating punch charged with raw power",
            skill1Damage,
            skill1MpCost,
            skill1Cooldown  
        );
        
        int skill2Damage = 55;
        int skill2MpCost = 20;
        int skill2Cooldown = 2;
        
        Skill furyStrike = new Skill(
            "Fury Strike",
            "Unleash a furious barrage of strikes",
            skill2Damage,
            skill2MpCost,
            skill2Cooldown  
        );
        
        int skill3Damage = 90;
        int skill3MpCost = 35;
        int skill3Cooldown = 4;
        
        Skill ironFistCombo = new Skill(
            "Iron Fist Combo",
            "A devastating combo that breaks through defenses",
            skill3Damage,
            skill3MpCost,
            skill3Cooldown  
        );
        
        addSkill(0, powerPunch);
        addSkill(1, furyStrike);
        addSkill(2, ironFistCombo);
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
