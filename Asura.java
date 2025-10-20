public class Asura extends Character {
    public Asura() {
        super("Asura", 120, 20, 15, 8, 12);
    }
    
    @Override
    public void skill1(Character target) {
        int damage = 15;
        System.out.println(name + " uses Power Punch on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }
    
    @Override
    public void skill2(Character target) {
        if (mp < 10) {
            System.out.println("Not enough MP for Furry Strike!");
            return;
        }
        int damage = 25;
        mp -= 10;
        System.out.println(name + " uses Furry Strike on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }
    
    @Override
    public void skill3(Character target) {
        if (mp < 15) {
            System.out.println("Not enough MP for Iron Fist Combo!");
            return;
        }
        mp -= 15;
        System.out.println(name + " uses Iron Fist Combo on " + target.getName() + "!");
        for (int i = 0; i < 3; i++) {
            int damage = 10;
            System.out.println("Hit " + (i+1) + ": " + damage + " damage!");
            target.takeDamage(damage);
        }
    }
}