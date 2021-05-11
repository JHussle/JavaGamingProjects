package TextBasedAdventureGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void public static void main(String[] args) {
     //System objects
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    //Game Variables
    String[] enemies = { "Skeleton", "Warewolf", "Golem", "Zombie", "Warrior"};
    int maxEnemyHealth = 75;
    int enemyAttackDamage = 25;

    //Player Variable
    int health = 100;
    int magic = 100;
    int attackDamage = 50;
    int magicAttackDamage = 25; // Magic attach power
    int numHealthPotions = 5;
    int numMagicPotion = 4;
    int healthPotionHealAmount = 30;
    int magicPotionHealAmount = 25;
    int healtPotionDropChance = 50; // Percentage that a health potion will be dropped
    int magicPotionDropChance = 25; // Percentage of a magic potion will be dropped

    boolean running = true;

    System.out.println("Welcome to the Dungeon!");
    
    GAME:
    while(running) {
        System.out.println("------------------------------");

        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String enemy = enemies[rand.nextInt(enemies.length)];
        System.out.println("\t# " + enemy + " appeared! #\n");
        }
    }    
}
