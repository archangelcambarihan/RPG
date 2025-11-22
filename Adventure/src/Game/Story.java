package Game;

public class Story {
    
    
    public static String getIntroduction() {
        return "It was once a peaceful world of Aetheria...\n\n"
                + "People lived in prosperity. The Kingdom of Tera was in celebration of their grand festival.\n\n"
                + "Until...\n\n"
                + "The seal of the Underworld was finally broken!\n\n"
                + "Monsters attacked the world, spreading chaos and destruction.\n\n"
                + "There is one person who is willing to do whatever it takes to restore the seal and save Aetheria...";
    }
    
    
    public static String getCharacterSelectionText() {
        return "Choose your hero:\n\n"
                + "Cloud - Swordsman\n"
                + "Asura - Brawler\n"
                + "Arthur - Marksman\n"
                + "Lune - Mage";
    }
    
    
    public static String getCloudStory() {
        return "=== CLOUD ===\n\n"
                + "A wandering swordsman with a mysterious past.\n\n"
                + "Calm but determined, he wields his blade with precision.\n\n"
                + "When darkness threatens Aetheria, Cloud draws his sword to protect the innocent.";
    }
    
    public static String getAsuraStory() {
        return "=== ASURA ===\n\n"
                + "A street fighter from the slums who seeks stronger opponents.\n\n"
                + "Trying to prove that he can be on top.\n\n"
                + "The broken seal has unleashed powerful foes - the perfect challenge for Asura!";
    }
    
    public static String getArthurStory() {
        return "=== ARTHUR ===\n\n"
                + "A hunter from the northern Forest of Aetheria.\n\n"
                + "When monsters began to invade, he vowed to use his bow to defend the innocent.\n\n"
                + "His arrows never miss their mark.";
    }
    
    public static String getLuneStory() {
        return "=== LUNE ===\n\n"
                + "A top graduate at the Magic Academy.\n\n"
                + "In thirst for knowledge, she travels the kingdom until the seal broke.\n\n"
                + "This phenomenon has piqued her interest and she wants to explore it with her magic.";
    }
    
    
    public static String getCharacterStory(String characterName) {
        switch(characterName.toLowerCase()) {
            case "cloud":
                return getCloudStory();
            case "asura":
                return getAsuraStory();
            case "arthur":
                return getArthurStory();
            case "lune":
                return getLuneStory();
            default:
                return "";
        }
    }
    
    
    public static String getBattleIntro(String enemyName, boolean isBoss) {
        if (isBoss) {
            return "=== BOSS BATTLE ===\n\n" + enemyName + " appears!\n\n";
        } else {
            return "A " + enemyName + " appears!\n\n";
        }
    }
    
    
    public static String getDefeatMessage(String enemyName) {
        return "=== DEFEAT ===\n\n"
                + "YOU HAVE BEEN DEFEATED!\n\n"
                + enemyName + " has bested you.\n\n"
                + "The darkness spreads across Aetheria...\n"
                + "The world falls into despair.\n"
                + "Hope fades as evil triumphs.\n\n"
                + "GAME OVER\n\n"
                + "Do not give up, hero!\n"
                + "Return and save Aetheria!";
    }
    
    
    public static String getFinalVictoryMessage(String characterName, String className, int level) {
        return "=== ULTIMATE VICTORY ===\n\n"
                + "Dark Lord Azrael falls, his dark powers fading into nothingness!\n\n"
                + "The Underworld seal is restored!\n"
                + "Light returns to all of Aetheria!\n\n"
                + "You have conquered:\n"
                + "[/] Tera Capital\n"
                + "[/] Forest of Aetheria\n"
                + "[/] Underworld\n\n"
                + "Peace returns to the kingdom!\n"
                + "Your legend will live forever!\n\n"
                + characterName + " the " + className + "\n"
                + "Level " + level + " Hero\n"
                + "HERO OF AETHERIA!\n\n"
                + "= CONGRATULATIONS =";
    }
    
    
    public static String getWorldCompletionMessage(int worldProgress) {
        switch(worldProgress) {
            case 0:
                return "Tera Capital has been saved!\nThe path to the Forest opens!";
            case 1:
                return "The Forest is safe!\nThe Underworld awaits!";
            default:
                return "";
        }
    }
    
    
    public static String getLevelUpMessage(int newLevel) {
        return "\n= LEVEL UP! =\n"
                + "You are now Level " + newLevel + "!\n"
                + "HP +20  |  MP +15  |  ATK +5  |  DEF +2\n";
    }
    
    
    public static String getNormalAttackMessage(String characterName, int damage) {
        return characterName + " performs a Normal Attack!\nDealt " + damage + " damage!\n\n";
    }
    
    public static String getSkillUsedMessage(String skillName, int damage) {
        return "You used " + skillName + "!\nDealt " + damage + " damage!\n\n";
    }
    
    public static String getEnemyAttackMessage(String enemyName, int damage) {
        return enemyName + " attacks!\nYou take " + damage + " damage!\n";
    }
    
    public static String getVictoryMessage(String enemyName, int expGained) {
        return enemyName + " has been defeated!\n\nVictory! You gained " + expGained + " EXP!\n";
    }
    
    public static String getRestoreMessage() {
        return "Restored 50 HP and 30 MP!\n\n";
    }
    
    public static String getSkillErrorMessage(boolean onCooldown, int cooldown, int mpCost, int currentMP) {
        String message = "Cannot use this skill!\n\n";
        
        if (onCooldown) {
            message += "Cooldown: " + cooldown + " turns\n";
        } else {
            message += "Not enough MP!\n";
        }
        
        message += "MP Cost: " + mpCost + "\n";
        message += "Current MP: " + currentMP;
        
        return message;
    }
}