package Game.Characters;

import Game.Skills.Skill;
import java.util.HashMap;
import java.util.Map;

public class Character {
    protected String name;
    protected String className;
    protected int maxHP;
    protected int currentHP;
    protected int maxMP;
    protected int currentMP;
    protected int level;
    protected int currentExp;
    protected int expToNextLevel;
    protected int attack;
    protected int defence;
    protected Skill[] skills;
    protected Map<String, Integer> skillCooldowns;
    
    public Character(String name, String className, int hp, int mp, int attack, int defence) {
        this.name = name;
        this.className = className;
        this.maxHP = hp;
        this.level = 1;
        this.currentExp = 0;
        this.expToNextLevel = 100;
        this.currentHP = hp;
        this.maxMP = mp;
        this.currentMP = mp;
        this.attack = attack;
        this.defence = defence;
        this.skills = new Skill[3];
        this.skillCooldowns = new HashMap<>();
    }
    
    public void addSkill(int index, Skill skill) {
        if (index >= 0 && index < 3) {
            skills[index] = skill;
            skillCooldowns.put(skill.getName(), 0);
        }
    }
    
    public boolean canUseSkill(int skillIndex) {
        if (skillIndex < 0 || skillIndex >= 3 || skills[skillIndex] == null) {
            return false;
        }
        Skill skill = skills[skillIndex];
        return currentMP >= skill.getMpCost() && 
               skillCooldowns.get(skill.getName()) <= 0;
    }
    
    public int useSkill(int skillIndex) {
        if (!canUseSkill(skillIndex)) {
            return 0;
        }
        
        Skill skill = skills[skillIndex];
        currentMP -= skill.getMpCost();
        skillCooldowns.put(skill.getName(), skill.getCooldown());
        
        return attack + skill.getDamage();
    }
    
    public void reduceCooldowns() {
        for (String skillName : skillCooldowns.keySet()) {
            int currentCooldown = skillCooldowns.get(skillName);
            if (currentCooldown > 0) {
                skillCooldowns.put(skillName, currentCooldown - 1);
            }
        }
    }
    
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defence);
        currentHP -= actualDamage;
        if (currentHP < 0) currentHP = 0;
    }
    
    public void heal(int amount) {
        currentHP += amount;
        if (currentHP > maxHP) currentHP = maxHP;
    }
    
    public void restoreMP(int amount) {
        currentMP += amount;
        if (currentMP > maxMP) currentMP = maxMP;
    }
    
    public boolean isAlive() {
        return currentHP > 0;
    }
    
 
    public String getName() { return name; }
    public String getClassName() { return className; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentMP() { return currentMP; }
    public int getMaxMP() { return maxMP; }
    public int getAttack() { return attack; }
    public int getDefence() { return defence; }
    public Skill getSkill(int index) { 
        return (index >= 0 && index < 3) ? skills[index] : null; 
    }
    public int getSkillCooldown(int index) {
        if (index >= 0 && index < 3 && skills[index] != null) {
            return skillCooldowns.get(skills[index].getName());
        }
        return 0;
    }
    public boolean addExp(int exp) {
        currentExp += exp;
        
        if (currentExp >= expToNextLevel) {
            levelUp();
            return true;
        }
        return false;
    }

    private void levelUp() {
        level++;
        currentExp = currentExp - expToNextLevel;
        expToNextLevel = (int)(expToNextLevel * 1.5);
        
       
        maxHP += 20;
        currentHP = maxHP; 
        maxMP += 15;
        currentMP = maxMP; 
        attack += 5;
        defence += 2;
    }

  
    public int getLevel() { return level; }
    public int getCurrentExp() { return currentExp; }
    public int getExpToNextLevel() { return expToNextLevel; }
}