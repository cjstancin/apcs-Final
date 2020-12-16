import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MT {
    public static void main(String[] args) throws IOException {
        Scanner scanner;
        File file;
        PrintWriter output;
        Scanner fileScan;

        try {
            scanner = new Scanner(System.in);
            showMenu();
            int option = Integer.parseInt(scanner.nextLine());

            while (option < 4  && option > 0){
                if (option == 1) {
                    System.out.println("File Name: "); //create file
                    String fileName = scanner.nextLine();
                    file = new File(fileName);
                    output = new PrintWriter(new FileWriter(file, true));

                    System.out.println("Game Name: "); //name of save
                    String gameName = scanner.nextLine();
                    output.println(gameName);

                    int knightCount = 0;
                    int peasantCount = 0;
                    int mageCount = 0;
                    int clericCount = 0;
                    int courtierCount = 0;

                    for (int x = 1; x <= 4; x++){
                        System.out.println("What class would you like to be Player " + x + "?" + " You can choose knight, peasant, mage, cleric, or courtier");
                        String type = scanner.nextLine();

                        if (type.equals("knight")) { //knight class
                            knightCount++;
                            if(knightCount > 2) {
                                System.out.println("Too Many Knight!");
                                x--;
                            } else {
                                Character character = new Character(type);
                                System.out.println("What is your name?");
                                String name = scanner.nextLine();
                                output.println(name + "," + character);
                            }
                        } else if (type.equals("peasant")) { //peasant class
                            peasantCount++;
                            if(peasantCount > 2) {
                                System.out.println("Too Many Peasants!");
                                x--;
                            } else {
                                Character character = new Character(type);
                                System.out.println("What is your name?");
                                String name = scanner.nextLine();
                                output.println(name + "," + character);
                            }
                        } else if (type.equals("mage")) { //mage class
                            mageCount++;
                            if(mageCount > 2) {
                                System.out.println("Too Many Mages!");
                                x--;
                            } else {
                                Character character = new Character(type);
                                System.out.println("What is your name?");
                                String name = scanner.nextLine();
                                output.println(name + "," + character);
                            }
                        } else if (type.equals("cleric")) { //cleric class
                            clericCount++;
                            if(clericCount > 2) {
                                System.out.println("Too Many Clerics!");
                                x--;
                            } else {
                                Character character = new Character(type);
                                System.out.println("What is your name?");
                                String name = scanner.nextLine();
                                output.println(name + "," + character);
                            }
                        } else if (type.equals("courtier")) { //courtier class
                            courtierCount++;
                            if(courtierCount > 2) {
                                System.out.println("Too Many Courtiers!");
                                x--;
                            } else {
                                Character character = new Character(type);
                                System.out.println("What is your name?");
                                String name = scanner.nextLine();
                                output.println(name + "," + character);
                            }
                        } else {
                            System.out.println("Not a class. No character will be made."); //wrong or invalid class
                        }
                    }
    
                    output.close();
                    showMenu();
                    option = Integer.parseInt(scanner.nextLine());
                }
                
                if (option == 2) {
                    System.out.println("Validate which file?"); //choosing file to validate
                    String fileName = scanner.nextLine();
                    file = new File(fileName);
                    fileScan = new Scanner(file);
                    int errors = 0;
                    fileScan.nextLine();

                    while (fileScan.hasNextLine()) {
                        ArrayList<String> stats = new ArrayList<String>(); 
                        String player = fileScan.nextLine();
                        System.out.println(player);
                        for (String stat : player.split(",")) { //breaking individual stats up into array
                            stats.add(stat);
                        }
                        if(!checkCharacter(stats)) {errors++;}
                        System.out.println("Errors: " + errors);
                    }
                    if (errors > 0) {
                        System.out.println("\nLol it's broken");
                    } else {
                        System.out.println("\nDon't worry ur fine");
                    }

                    fileScan.close();
                    showMenu();
                    option = Integer.parseInt(scanner.nextLine());
                }

                if (option == 3) {
                    System.out.println("Enter game save file"); //choosing save file
                    String fileName = scanner.nextLine();
                    file = new File(fileName);
                    fileScan = new Scanner(file);

                    if (file.length() > 0) {
                        ArrayList<String> names = new ArrayList<String>(); 
                        while (fileScan.hasNextLine()) {
                            String player = fileScan.nextLine();
                            String[] nameBreak = player.split(","); //breaking up players
                            names.add(nameBreak[0]);
                        }
                        names.remove(0);
                        System.out.println("\nWhich player would you like to change?");
                        String redo = scanner.nextLine();

                        for (int x = 0; x < file.length() - 1; x++) {
                            if (redo.equals(names.get(x))){
                                int index = x;
                                Character randomChar = new Character();
                                String newStats = redo + "," + randomChar;
                                String fill = "";
                                ArrayList<String> oldData = new ArrayList<String>();
                                BufferedReader reader = new BufferedReader(new FileReader(file));
                                String current = reader.readLine();

                                while (current != null) {
                                    fill = fill + current + "\n";
                                    oldData.add(current);
                                    current = reader.readLine();
                                }
                                String oldStats = oldData.get(index + 1);
                                String oldContentString = String.join("\n", oldData);
                                String newData = oldContentString.replaceAll(oldStats, newStats);

                                FileWriter writer = new FileWriter(file, false);
                                
                                writer.write(newData);
                                reader.close();
                                writer.close();
                                System.out.println(redo + " has been randomized");
                                break;
                            } else {
                                System.out.println("No character found");
                            }
                        }
                        showMenu();
                        option = Integer.parseInt(scanner.nextLine());
                    }
                    
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    public static void showMenu(){
        System.out.println("----------------------------\n1. Create new game\n2. Validate file\n3. Reroll existing character\n4. Quit\n----------------------------");
    }

    public static boolean checkCharacter(ArrayList<String> stats) { 
        int cp = 0;       
        if (stats.size() < 7) {
            return false;
        } else {
            cp = Integer.parseInt(stats.get(2)) + Integer.parseInt(stats.get(3)) + Integer.parseInt(stats.get(4)) + Integer.parseInt(stats.get(5)) + Integer.parseInt(stats.get(6));
        }
        
        if ((stats.get(1)).equals("knight") && (Integer.parseInt(stats.get(2)) > 10 || Integer.parseInt(stats.get(2)) < 7)) {
            return false;
        } else if ((stats.get(1)).equals("peasant") && (Integer.parseInt(stats.get(3)) > 10 || Integer.parseInt(stats.get(3)) < 7)) {
            return false;
        } else if ((stats.get(1)).equals("cleric") && (Integer.parseInt(stats.get(4)) > 10 || Integer.parseInt(stats.get(4)) < 7)) {
            return false;
        } else if ((stats.get(1)).equals("mage") && (Integer.parseInt(stats.get(5)) > 10 || Integer.parseInt(stats.get(5)) < 7)) {
            return false;
        } else if ((stats.get(1)).equals("courtier") && (Integer.parseInt(stats.get(7)) > 10 || Integer.parseInt(stats.get(7)) < 7)) {
            return false;
        } else if ((stats.get(1)).equals("knight") || (stats.get(1)).equals("peasant") || (stats.get(1)).equals("cleric") || (stats.get(1)).equals("mage") || (stats.get(1)).equals("courtier")){
            return true;
        } else if (cp < 8 || cp > 28) {
            return false;
        }
        return false;
    }
}