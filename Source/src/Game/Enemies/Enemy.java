package Game.Enemies;

public class Enemy {
    protected String name;
    protected String type;
    protected int maxHP;
    protected int currentHP;
    protected int attack;
    protected int defence;
    protected int expReward;
    protected String location;
    
    public Enemy(String name, String type, int hp, int attack, int defence, int expReward, String location) {
        this.name = name;
        this.type = type;
        this.maxHP = hp;
        this.currentHP = hp;
        this.attack = attack;
        this.defence = defence;
        this.expReward = expReward;
        this.location = location;
    }
    
    public int attackPlayer() {
    	System.out.println("DEBUG Enemy attacking: " + name + " with attack value: " + attack);
        return attack;
    }
    
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defence);
        currentHP -= actualDamage;
        if (currentHP < 0) currentHP = 0;
    }
    
    public boolean isAlive() {
        return currentHP > 0;
    }
    

    public String getName() { return name; }
    public String getType() { return type; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getAttack() { return attack; }
    public int getDefence() { return defence; }
    public int getExpReward() { return expReward; }
    public String getLocation() { return location; }
}