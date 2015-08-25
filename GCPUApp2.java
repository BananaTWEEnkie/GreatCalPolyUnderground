
package gcpuapp2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GCPUApp2 {

        public static void main(String[] args) {

                // Declare and initialize variables
                Scanner scan = new Scanner(System.in);

                // Staring location
                int row = 3;
                int col = 0;

                // Create an instance of a map
                Backpack pack = new Backpack();
                Map map = new Map(pack);

                // Begin user dialogue
                System.out.println("Welcome to the Great Cal Poly Underground!\n");
                map.printInstructions();
                String entered ="";
                String input = "";
                String answer = "";
                map.printInfo(row, col);

                // Start game
                while (!answer.equalsIgnoreCase("Y"))
                {
                        // Get user input
                        System.out.print("\n> ");
                        entered = scan.nextLine();
                        input = entered.toLowerCase();

                        // Search for commands to give appropriate functions
                        if (input.equals("n"))
                        {
                                if (map.rooms[row][col].isValidExit("n"))
                                {
                                        row--;
                                        map.printInfo(row, col);
                                } 
                                else 
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("e"))
                        {
                                if (map.rooms[row][col].isValidExit("e"))
                                {
                                        col++;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("s"))
                        {
                                if (map.rooms[row][col].isValidExit("s"))
                                {
                                        row++;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("w"))
                        {
                                if (map.rooms[row][col].isValidExit("w"))
                                {
                                        col--;
                                        map.printInfo(row, col);
                                }
                                else 
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("nw"))
                        {
                                if (map.rooms[row][col].isValidExit("nw"))
                                {
                                        row--;
                                        col--;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("ne"))
                        {
                                if (map.rooms[row][col].isValidExit("ne"))
                                {
                                        row--;
                                        col++;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("se"))
                        {
                                if (map.rooms[row][col].isValidExit("se"))
                                {
                                        row++;
                                        col++;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                        }
                        else
                        if (input.equals("sw"))
                         {
                                if (map.rooms[row][col].isValidExit("sw"))
                                {
                                        row++;
                                        col--;
                                        map.printInfo(row, col);
                                }
                                else
                                        System.out.println("You can't go that way.");
                         }
                         else
                         if (input.startsWith("drop" ))
                         {
                                String artifactName = input.substring(4).trim();
                                if(artifactName.equals(""))
                                {
                                        System.out.println("DROP WHAT?");
                                }
                                else
                                        System.out.println(map.rooms[row][col].drop(artifactName));
                        }
                        else
                        if (input.equals("examine"))
                                System.out.println(map.rooms[row][col].examine());        
                        else
                         if (input.equals("inventory"))
                                 System.out.println(pack.list());
                        else
                        if (input.equals("look"))
                                System.out.println(map.rooms[row][col].look());
                        else
                        if (input.equals("restore"))
                        {
                                Scanner scan2 = new Scanner(System.in);
                                System.out.print("Enter file to restore > ");
                                String fileName = scan2.nextLine();
                                
                                File file = new File("c:/files/" + fileName);
                                try (FileReader reader = new FileReader(file);
                                        BufferedReader buffer = new BufferedReader(reader);)
                                {
                                        map.clear();
                                        pack.clear();
                                        String line = buffer.readLine();
                                        while (line != null)
                                        {
                                                String[] data = line.split(",");
                                                String key = data[0];
                                                if (key.equals("StartLocation"))
                                                {
                                                        row = Integer.parseInt(data[1]);
                                                        col = Integer.parseInt(data[2]);
                                                }
                                                else
                                                if (key.equals("Artifact"))
                                                {
                                                        String name = data[1];
                                                        int artifactRow = Integer.parseInt(data[2]);
                                                        int artifactCol = Integer.parseInt(data[3]);
                                                        map.setArtifact(name, artifactRow, artifactCol);
                                                }
                                                else
                                                if (key.equals("Inventory"))
                                                {
                                                        String itemName = data[1];
                                                        Artifact inventoryArtifact = map.getArtifact(itemName);
                                                        pack.setArtifact(inventoryArtifact);
                                                }
                                                        line = buffer.readLine();
                                        }
                                        
                                        System.out.println();
                                        map.printInfo(row, col);
                                }
                                catch (IOException e)
                                {
                                        System.out.println(e.getMessage());
                                }
                        }
                        else
                        if (input.equals("save"))
                        {
                                Scanner scan2 = new Scanner(System.in);
                                System.out.print("Enter file to save > ");
                                String fileName = scan2.nextLine();
                                
                                try
                                {       
                                        File file = new File("c:/files/"  + fileName);
                                       
                                        if(file.exists() && file.isFile())
                                        {
                                                Scanner scan3 = new Scanner(System.in);
                                                String saveAnswer;
                                                
                                                do
                                                {
                                                        System.out.println("\nThis save file already exists. Do you want to overwrite it or cancel? (yes/cancel)");
                                                        System.out.print("> ");
                                                        saveAnswer = scan3.nextLine();
                                                        
                                                        if(saveAnswer.equalsIgnoreCase("yes") )
                                                        {
                                                                FileWriter writer = new FileWriter(file);
                                                                BufferedWriter buffer = new BufferedWriter(writer);
                                                                PrintWriter pw = new PrintWriter(buffer);

                                                                pw.println("StartLocation" + "," + row + "," + col);
                                                                map.save(pw);
                                                                pack.save(pw);

                                                                buffer.close();
                                                                pw.close();
                                                                
                                                                System.out.println("Save complete.");
                                                        }
                                                        else
                                                        if(saveAnswer.equalsIgnoreCase("cancel"))
                                                        {
                                                                System.out.println("You have canceled.");
                                                                saveAnswer = "yes";
                                                        }
                                                        else
                                                                System.out.println("Please input yes or cancel.");                                                                
                                                } while(!saveAnswer.equalsIgnoreCase("yes"));
                                        }
                                }
                                catch (IOException e)
                                {
                                        System.out.println(e.getMessage());
                                }
                        }
                        else
                        if (input.equals("take"))
                        {
                                System.out.println(map.rooms[row][col].take());
                        }
                        else
                        if (input.equals("touch")) 
                                System.out.println(map.rooms[row][col].touch());
                        else
                        if (input.equals("quit"))
                        {
                                Scanner scan2 = new Scanner(System.in);

                                // Ask user if they really do want to quit
                                System.out.print("Do you with to leave the Underground (Y/N)? > ");
                                answer = scan2.nextLine();

                                if (answer.equalsIgnoreCase("N"))
                                {
                                        map.printInfo(row, col);
                                }

                        }
                        else
                                System.out.println("I don't understand the word \"" + input + "\".");
                }

                // Print end message
                System.out.println("\n~*~ Thank you for visiting the Great Cal Poly Underground! ~*~");

                scan.close();

        }

}
