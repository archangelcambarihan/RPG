package Game.Characters;

import Game.Skills.Skill;

public class Asura extends Character {
    
    public Asura() {
        super("Asura", "Brawler", 180, 60, 50, 25);
        initializeSkills();
    }
    
    private void initializeSkills() {
        
        Skill powerPunch = new Skill(
            "Power Punch",
            "A devastating punch charged with raw power",
            35,  
            8,   
            0    
        );
        
        
        Skill furyStrike = new Skill(
            "Fury Strike",
            "Unleash a furious barrage of strikes",
            55,  
            20,  
            2    
        );
        
        
        Skill ironFistCombo = new Skill(
            "Iron Fist Combo",
            "A devastating combo that breaks through defenses",
            90,  
            35,  
            4    
        );
        
        addSkill(0, powerPunch);
        addSkill(1, furyStrike);
        addSkill(2, ironFistCombo);
    }
}