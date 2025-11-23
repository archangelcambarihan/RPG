package Game.Skills;

public class Skill {
    private String name;
    private String description;
    private int damage;
    private int mpCost;
    private int cooldown;
    
    public Skill(String name, String description, int damage, int mpCost, int cooldown) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.mpCost = mpCost;
        this.cooldown = cooldown;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int getMpCost() {
        return mpCost;
    }
    
    public int getCooldown() {
        return cooldown;
    }
    
    @Override
    public String toString() {
        return name + " (Damage: " + damage + ", MP: " + mpCost + ", Cooldown: " + cooldown + ")";
    }
}