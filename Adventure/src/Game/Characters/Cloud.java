package Game.Characters;

import Game.Skills.Skill;

public class Cloud extends Character {
    
    public Cloud() {
        super("Cloud", "Swordsman", 150, 80, 45, 20);
        initializeSkills();
    }
    
    private void initializeSkills() {
       
        Skill slash = new Skill(
            "Slash",
            "A quick sword slash",
            30,  
            10,  
            0    
        );
        
        
        Skill bladeRush = new Skill(
            "Blade Rush",
            "Rush forward with a powerful blade strike",
            50,  
            25,  
            2    
        );
        
      
        Skill heroStrike = new Skill(
            "Hero's Strike",
            "A legendary strike that channels heroic power",
            85,
            40,  
            4    
        );
        
        addSkill(0, slash);
        addSkill(1, bladeRush);
        addSkill(2, heroStrike);
    }
}