package TextBasedAdventureGame;

import java.util.Random;
import java.util.Scanner;



public class textbasedadventuregame {
    public static void main(String[] args) {
     //Constructor Class for type of characters that the user will be able to select
     
     
     
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
    int armor = 100;
    int health = 100;
    int magic = 100;
    int attackDamage = 50;
    int magicAttackDamage = 25; // Magic attach power
    int numArmorRepairs = 3;
    int numHealthPotions = 5;
    int numMagicPotion = 4;
    int armorRepairAmount = 25;
    int healthPotionHealAmount = 30;
    int magicPotionHealAmount = 25;
    int armorRepairDropChance = 15; // Percentage that a armor repair will be dropped
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
            System.out.println("\tYour AHP: " + armor);
            System.out.println("\tYour HP: " + health);
            System.out.println("\tYour MP: " + magic);
            System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
            System.out.println("\t" + enemy + "'s MP: " + enemyMagic);
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Magic Attack");
            System.out.println("\t3. Repair armor");
            System.out.println("\t4. Drink health potion");
            System.out.println("\t5. Drink magic potion");
            System.out.println("\t6. Run!!");

            String input = in.nextLine();
            if (input.equals("1")){
                int damageDealt = rand.nextInt(attackDamage);
                int damageTaken = rand.nextInt(enemyAttackDamage);

                enemyHealth -= damageDealt;
                armor -= damageTaken;

                if(armor > 0){ /* Armor isnt stopping at zero takes a negative value, this shouldnt be the case */
                    break;
                } else if(armor < 0) {
                    health -= damageTaken;
                }

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
                magic -= magicDealt;

                if(magic > 1){
                    System.out.println("\t> You do not have enough magic, you must take a magic potion");
                    break;
                }

                System.out.println("\t> Your spell towards the " + enemy + " for " + magicDealt + " magic damage.");
                System.out.println("\t> You recieved " + magicTaken + " in retaliation ");

                

            
            } else if (input.equals("3")) {
                if(numArmorRepairs > 0) {
                    armor += armorRepairAmount;
                    numArmorRepairs--;
                    System.out.println("\t> You used an armor repair, repair amount for " + armorRepairAmount + "."
                                    + "\n\t> You know have " + armor + " AHP."
                                    + "\n\t> You have " + numArmorRepairs + " armor repair(s) left. \n");
                } else {
                    System.out.println("\t> You have no armor repairs left! Defeat enemies for a chance to get one!");
                }

            } else if (input.equals("4")) {
                if(numHealthPotions > 0) {
                    health += healthPotionHealAmount;
                    numHealthPotions--;
                    System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmount + "."
                                    + "\n\t> You know have " + health + " HP."
                                    + "\n\t> You have " + numHealthPotions + " health potions left. \n");
                } else {
                    System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                }

            } else if (input.equals("5")){
                if(numMagicPotion > 0) {
                    magic += magicPotionHealAmount;
                    numMagicPotion--;
                    System.out.println("\t> You drank a magic potion, rejuvenating your  magic for " + magicPotionHealAmount + "."
                                    + "\n\t> You know have " + magic + " MP."
                                    + "\n\t> You have " + numMagicPotion + " health potions left. \n");
                } else {
                    System.out.println("\t> You have no magic potions left! Defeat enemies for a chance to get one!");
                }

            } else if (input.equals("6")){
                System.out.println("\tYou run away from the " + enemy + "!");
                continue GAME;
            } else {
                System.out.println("\tInvalid command");
            }

        }
            if(health < 1) {
                System.out.println("You limp out og the dungeon, weak from battle");
                break;
            }
            System.out.println("------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + armor + "AHP left. #");
            System.out.println(" # You have " + health + "HP left. #");
            System.out.println(" # You have " + magic + "MP left. #");

            if(rand.nextInt(100) > healtPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion #");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
            }
            if(rand.nextInt(100) > magicPotionDropChance){
                numMagicPotion++;
                System.out.println(" # The " + enemy + " dropped a magic potion #");
                System.out.println(" # You now have " + numMagicPotion + " magic potion(s). #");
            }
            if(rand.nextInt(100) > armorRepairDropChance){
                numMagicPotion++;
                System.out.println(" # The " + enemy + " dropped a armor repair kit #");
                System.out.println(" # You now have " + numArmorRepairs + " armor repair kit(s). #");
            }

            System.out.println("------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command");
                input = in.nextLine();
            }
            if(input.equals("1")){
                System.out.println("You continue on your adventure");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, to continue another day...");
                break;
            }
        }
        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");
    }
}