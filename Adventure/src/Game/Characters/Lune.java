package Game.Characters;

import Game.Skills.Skill;

public class Lune extends Character {
    
    public Lune() {
        super("Lune", "Mage", 100, 150, 40, 10);
        initializeSkills();
    }
    
    private void initializeSkills() {
        
        Skill fireball = new Skill(
            "Fireball",
            "Launch a blazing ball of fire",
            45,  
            15,  
            0   
        );
        
        
        Skill lightningChain = new Skill(
            "Lightning Chain",
            "Summon lightning that chains between targets",
            65,  
            30,  
            3    
        );
        
        
        Skill meteorStrike = new Skill(
            "Meteor Strike",
            "Call down a devastating meteor from the sky",
            110, 
            50,  
            5   
        );
        
        addSkill(0, fireball);
        addSkill(1, lightningChain);
        addSkill(2, meteorStrike);
    }
}