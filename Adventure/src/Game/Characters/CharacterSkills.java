package Game.Characters;

import Game.Skills.Skill;

public class CharacterSkills {
    
    public static Skill[] getCloudSkills() {
        Skill[] skills = new Skill[3];
        
        skills[0] = new Skill("Slash", "A quick sword slash", 30, 10, 0);
        skills[1] = new Skill("Blade Rush", "Rush forward with a powerful blade strike", 50, 25, 2);
        skills[2] = new Skill("Hero's Strike", "A legendary strike that channels heroic power", 85, 40, 4);
        
        return skills;
    }
    
    public static Skill[] getAsuraSkills() {
        Skill[] skills = new Skill[3];
        
        skills[0] = new Skill("Power Punch", "A devastating punch charged with raw power", 35, 8, 0);
        skills[1] = new Skill("Fury Strike", "Unleash a furious barrage of strikes", 55, 20, 2);
        skills[2] = new Skill("Iron Fist Combo", "A devastating combo that breaks through defenses", 90, 35, 4);
        
        return skills;
    }
    
    public static Skill[] getArthurSkills() {
        Skill[] skills = new Skill[3];
        
        skills[0] = new Skill("Piercing Arrow", "An arrow that pierces through armor", 40, 12, 0);
        skills[1] = new Skill("Falcon Dash", "Dash like a falcon and strike with precision", 60, 28, 3);
        skills[2] = new Skill("Critical Shot", "A perfectly aimed shot that finds weak points", 100, 45, 5);
        
        return skills;
    }
    
    public static Skill[] getLuneSkills() {
        Skill[] skills = new Skill[3];
        
        skills[0] = new Skill("Fireball", "Launch a blazing ball of fire", 45, 15, 0);
        skills[1] = new Skill("Lightning Chain", "Summon lightning that chains between targets", 65, 30, 3);
        skills[2] = new Skill("Meteor Strike", "Call down a devastating meteor from the sky", 110, 50, 5);
        
        return skills;
    }
}