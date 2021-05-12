package TextBasedAdventureGame;

import java.util.Random;
import java.util.Scanner;

public class textbasedadventuregame {
    public static void main(String[] args) {
     //System objects
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    //Game Variables
    String[] enemies = { "Skeleton", "Warewolf", "Golem", "Zombie", "Warrior"};
    int maxEnemyHealth = 75;
    int maxEnemyMagic = 100;
    int enemyAttackDamage = 25;
    int enemyMagicDamage = 20;

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
        int enemyMagic = rand.nextInt(maxEnemyMagic); 
        String enemy = enemies[rand.nextInt(enemies.length)];
        System.out.println("\t# " + enemy + " appeared! #\n");   
        
        while(enemyHealth > 0) {
            System.out.println("\tYour HP: " + health);
            System.out.println("\tYour MP: " + magic);
            System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
            System.out.println("\t" + enemy + "'s MP: " + enemyMagic);
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Magic Attack");
            System.out.println("\t3. Drink health potion");
            System.out.println("\t4. Drink magic potion");
            System.out.println("\t5. Run!!");

            String input = in.nextLine();
            if (input.equals("1")){
                int damageDealt = rand.nextInt(attackDamage);
                int damageTaken = rand.nextInt(enemyAttackDamage);

                enemyHealth -= damageDealt;
                health -= damageTaken;

                System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                System.out.println("\t> You recieved " + damageTaken + " in retaliation ");

                if(health < 1){
                    System.out.println("\t> You have taken too much damage, you are too weak to continue");
                    break;
                }

            } else if (input.equals("2")) {
                int magicDealt = rand.nextInt(magicAttackDamage);
                int magicTaken = rand.nextInt(enemyMagicDamage);

                enemyHealth -= magicDealt;
                health -= magicTaken;

                System.out.println("\t> Your spell towards the " + enemy + " for " + magicDealt + " magic damage.");
                System.out.println("\t> You recieved " + magicTaken + " in retaliation ");

                if(magic < 1){
                    System.out.println("\t> You do not have enough magic, you must take a magic potion");
                    break;
                }

            } else if (input.equals("3")) {
                if(numHealthPotions > 0) {
                    health += healthPotionHealAmount;
                    numHealthPotions--;
                    System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmount + "."
                                    + "\n\t> You know have " + health + " HP."
                                    + "\n\t> You have " + numHealthPotions + " health potions left. \n");
                } else {
                    System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                }

            } else if (input.equals("4")){
                if(numMagicPotion > 0) {
                    magic += magicPotionHealAmount;
                    numMagicPotion--;
                    System.out.println("\t> You drank a magic potion, rejuvenating your  magic for " + magicPotionHealAmount + "."
                                    + "\n\t> You know have " + magic + " MP."
                                    + "\n\t> You have " + numMagicPotion + " health potions left. \n");
                } else {
                    System.out.println("\t> You have no magic potions left! Defeat enemies for a chance to get one!");
                }

            } else if (input.equals("5")){
                System.out.println("\tYou run away from the " + enemy + "!");
                continue GAME;
            } else {
                System.out.println("\tInvalid command");
            }

            }
        }
    }
}
