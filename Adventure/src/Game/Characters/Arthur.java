package Game.Characters;

import Game.Skills.Skill;

public class Arthur extends Character {
    
    public Arthur() {
        super("Arthur", "Marksman", 120, 90, 55, 15);
        initializeSkills();
    }
    
    private void initializeSkills() {
        
        Skill piercingArrow = new Skill(
            "Piercing Arrow",
            "An arrow that pierces through armor",
            40,  
            12,  
            0    
        );
        
        
        Skill falconDash = new Skill(
            "Falcon Dash",
            "Dash like a falcon and strike with precision",
            60,  
            28, 
            3    
        );
        
       
        Skill criticalShot = new Skill(
            "Critical Shot",
            "A perfectly aimed shot that finds weak points",
            100, 
            45,  
            5    
        );
        
        addSkill(0, piercingArrow);
        addSkill(1, falconDash);
        addSkill(2, criticalShot);
    }
}