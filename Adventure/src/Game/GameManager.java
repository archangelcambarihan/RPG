package Game;

import Game.Characters.*;
import Game.Characters.Character;
import Game.Enemies.*;
import Game.Enemies.AetheriaCapitalEnemies.*;
import Game.Enemies.ForestOfAetheriaEnemies.*;
import Game.Enemies.UnderworldEnemies.*;

public class GameManager {
    private Character player;
    private Enemy currentEnemy;
    private String currentLocation;
    
   
    public Character createCharacter(String characterName) {
        switch(characterName.toLowerCase()) {
            case "cloud":
                return new Cloud();
            case "asura":
                return new Asura();
            case "arthur":
                return new Arthur();
            case "lune":
                return new Lune();
            default:
                return new Cloud(); 
        }
    }
    
   
    public Enemy createEnemy(String location, String enemyType) {
        switch(location.toLowerCase()) {
            case "tera capital":
            case "teracapital":
                return createAetheriaEnemy(enemyType);
            case "forest of aetheria":
            case "forestofaetheria":
                return createForestEnemy(enemyType);
            case "underworld":
                return createUnderworldEnemy(enemyType);
            default:
                return new CapitalGuard();
        }
    }
    
    private Enemy createAetheriaEnemy(String type) {
        switch(type.toLowerCase()) {
            case "normal":
                return new CapitalGuard();
            case "general":
                return new CaptainCommander();
            case "boss":
                return new KingOfAetheria();
            default:
                return new CapitalGuard();
        }
    }
    
    private Enemy createForestEnemy(String type) {
        switch(type.toLowerCase()) {
            case "normal":
                return new WildBeast();
            case "general":
                return new ForestGuardian();
            case "boss":
                return new AncientTreelord();
            default:
                return new WildBeast();
        }
    }
    
    private Enemy createUnderworldEnemy(String type) {
        switch(type.toLowerCase()) {
            case "normal":
                return new DemonImps();
            case "general":
                return new InfernalKnight();
            case "boss":
                return new DarkLordAzrael();
            default:
                return new DemonImps();
        }
    }
    
    
    public String performPlayerAttack(int skillIndex) {
        if (player == null || currentEnemy == null) {
            return "No active battle!";
        }
        
        if (!player.canUseSkill(skillIndex)) {
            return "Cannot use this skill! Check MP or cooldown.";
        }
        
        int damage = player.useSkill(skillIndex);
        currentEnemy.takeDamage(damage);
        
        String result = player.getName() + " used " + 
                       player.getSkill(skillIndex).getName() + 
                       " and dealt " + damage + " damage!\n";
        
        if (!currentEnemy.isAlive()) {
            result += currentEnemy.getName() + " has been defeated!";
        }
        
        return result;
    }
    
    public String performEnemyAttack() {
        if (player == null || currentEnemy == null || !currentEnemy.isAlive()) {
            return "";
        }
        
        int damage = currentEnemy.attackPlayer();
        player.takeDamage(damage);
        
        String result = currentEnemy.getName() + " attacks for " + 
                       damage + " damage!\n";
        
        if (!player.isAlive()) {
            result += "You have been defeated!";
        }
        
        return result;
    }
    
  
    public void setPlayer(Character player) {
        this.player = player;
    }
    
    public Character getPlayer() {
        return player;
    }
    
    public void setCurrentEnemy(Enemy enemy) {
        this.currentEnemy = enemy;
    }
    
    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }
    
    public void setCurrentLocation(String location) {
        this.currentLocation = location;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
}