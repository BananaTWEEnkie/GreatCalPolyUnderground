package gcpuapp2;

import java.io.PrintWriter;
import java.util.Hashtable;
import static jdk.nashorn.internal.codegen.ObjectClassGenerator.pack;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class Map {

        // Initialize
        Room[][] rooms = new Room[4][4];
        Hashtable<String, Artifact> artifactMap = new Hashtable<>();

        Map(Backpack pack)
        {
                       
                // Create rooms
                Room garden = new Room();
                garden.name = "Garden";
                garden.description = "You are standing at the entrance to a beautiful rose garden.";
                garden.exits = new String[]{"s", "e"};
                garden.exitNames = "south and east.";

                //create artifacts for the room
                Artifact fountain = new Artifact("fountain");
                fountain.description = "The small plaque on the fountain reads: Enjoy the garden!";
                garden.content = fountain;
                artifactMap.put(fountain.name, fountain);

                // Starbucks
                Room starBucks = new Room();
                starBucks.name = "Starbucks";
                starBucks.description = "The coffee smell was strong enough to give you an adrenaline rush.";
                starBucks.exits = new String[]{"e"};
                starBucks.exitNames = "east.";

                Artifact chair = new Artifact("wooden chair");
                chair.description = "The chair looks so brittle that it would collapse and only gain splinters if you sat on it.";
                starBucks.content = chair;
                artifactMap.put(chair.name, chair);
                
                // Library
                Room library = new Room();
                library.name = "Library";
                library.description = "You see towers of books that are blanketed with dust.";
                library.exits = new String[]{"s", "w"};
                library.exitNames = "south and west.";

                Artifact book = new Artifact("book");
                book.description = "Just a dusty old book with impossible to read text inside.";
                library.content = book;
                artifactMap.put(book.name, book);
                
                // Lobby
                Room lobby = new Room();
                lobby.name = "Lobby";
                lobby.description = "Sunlight is streaming in through the glass door.";
                lobby.exits = new String[]{"n"};
                lobby.exitNames = "north.";

                Artifact sign = new Artifact("sign");
                sign.description = "(read) This way to the rose garden.";
                lobby.content = sign;
                artifactMap.put(sign.name, sign);
                
                // Classroom
                Room classRoom = new Room();
                classRoom.name = "Classroom";
                classRoom.description = "An old exam lies on a table in the center of the room.";
                classRoom.exits = new String[]{"s", "w"};
                classRoom.exitNames = "south and west.";

                Artifact exam = new Artifact("exam");
                exam.description = "CIS 243 Final Exam... The rest appears unreadable due to a lack of printer tone.";
                classRoom.content = exam;
                artifactMap.put(exam.name, exam);
                
                // Lab
                Room lab = new Room();
                lab.name = "Lab";
                lab.description = "You entered a room with the smell of failed experiments. You then notice an old tv on a table.";
                lab.exits = new String[]{"s"};
                lab.exitNames = "south.";

                SpecialArtifact tv = new SpecialArtifact();
                tv.name = "old television";
                tv.description = "You see your own reflection on the tv screen. Look how attractive you are!";
                tv.touchDescription = "The tv beams with life and sounds emits from the speakers.";
                tv.specialDescription = "Oh sweet! A movie of Scooby-Doo is on where they investigate a haunted school. Now you feel all fired up.";
                lab.content = tv;
                artifactMap.put(tv.name, tv);
                
                // Large Room
                Room lgRoom = new Room();
                lgRoom.name = "Large Room";
                lgRoom.description = "A picture of the University President adorns the north wall.";
                lgRoom.exits = new String[]{"e"};
                lgRoom.exitNames = "east.";

                Artifact picture = new Artifact("picture");
                picture.description = "The picture bears an inscription that reads: President of Cal Poly Pomona.";
                lgRoom.content = picture;
                artifactMap.put(picture.name, picture);
                
                // Drafty Room
                Room draftyRoom = new Room();
                draftyRoom.name = "Drafty Room";
                draftyRoom.description = "The smell of hamburgers wafts through the air.";
                draftyRoom.exits = new String[]{"n", "w"};
                draftyRoom.exitNames = "north and west.";

                Artifact lunch = new Artifact("lunch");
                lunch.description = "The lunch appears to be a hamburger, French fries, and some kind of soda.";
                draftyRoom.content = lunch;
                artifactMap.put(lunch.name, lunch);
                
                // Empty Room
                Room emptyRoom = new Room();
                emptyRoom.name = "Empty Room";
                emptyRoom.description = "Nothing but nothing.";
                emptyRoom.exits = new String[]{"sw"};
                emptyRoom.exitNames = "southwest.";

                // Clearing
                Room clearing = new Room();
                clearing.name = "Clearing";
                clearing.description = "A dark cavernous opening in the nearby cliff lies just north of you.";
                clearing.exits = new String[]{"n"};
                clearing.exitNames = "north.";

                SpecialArtifact paper = new SpecialArtifact();
                paper.name = "paper";
                paper.description = "A blank piece of paper...";
                paper.touchDescription = "The paper begins to glow and you see mysterious writing appear.";
                paper.specialDescription = "The paper reads: Welcome to the Great Cal Poly Underground!";
                clearing.content = paper;
                artifactMap.put(paper.name, paper);
                
                // Kitchen
                Room kitchen = new Room();
                kitchen.name = "Kitchen";
                kitchen.description = "Everything in the room was practically in gold. There is a... chicken hanging from the cieling.";
                kitchen.exits = new String[]{"e"};
                kitchen.exitNames = "east.";

                Artifact chicken = new Artifact("rubber chicken");
                chicken.description = "It is a rubber chicken...";
                kitchen.content = chicken;
                artifactMap.put(chicken.name, chicken);
                
                Room cafeteria = new Room();
                cafeteria.name = "Cafeteria";
                cafeteria.description = "It's a bit empty, but there are many vending machines on the walls.";
                cafeteria.exits = new String[]{"n", "w"};
                cafeteria.exitNames = "north and west.";

                SpecialArtifact vendingMachine = new SpecialArtifact();
                vendingMachine.name = "vending machine";
                vendingMachine.description = "A vending machine that spits out an assortment soda.";
                vendingMachine.touchDescription = "*Clink* *kathunk* Score! You got free soda.";
                vendingMachine.specialDescription = "You grab the soda, open it, and hastily drank it. You were extremely thirsty from all the walking around.";
                cafeteria.content = vendingMachine;
                artifactMap.put(vendingMachine.name, vendingMachine);
                
                // Place rooms on map
                rooms[0][0] = garden;
                rooms[0][1] = starBucks;
                rooms[0][2] = library;
                rooms[1][0] = lobby;
                rooms[1][1] = classRoom;
                rooms[1][2] = lab;
                rooms[2][0] = lgRoom;
                rooms[2][1] = draftyRoom;
                rooms[2][2] = emptyRoom;
                rooms[3][0] = clearing;
                rooms[3][1] = kitchen;
                rooms[3][2] = cafeteria;
                
                for(int r =0;r < rooms.length;r++)
                {
                        for(int c=0;c < rooms[r].length;c++)
                        {
                                if(rooms[r][c] != null)
                                {
                                        rooms[r][c].pack = pack;
                                }
                        }
                }
        }

        // Clear map when restore occur
        void clear()
        {
                for(int r =0;r < rooms.length;r++)
                {
                        for(int c=0;c < rooms[r].length;c++)
                        {
                                if(rooms[r][c] != null)
                                {
                                        rooms[r][c].content = null;
                                }
                        }
                }
        }
        
        // Set artifacts to pass from main to map
        void setArtifact(String aName, int row, int col)
        {
                rooms[row][col].content = getArtifact(aName);
        }

        Artifact getArtifact(String name)
        {
                return artifactMap.get(name);
        }
        
        // To print game information for user
        void printInfo(int row, int col) {
                System.out.println(rooms[row][col].name);
                System.out.println("\nYou have entered a " + rooms[row][col].name.toLowerCase() + ".");
                System.out.println(rooms[row][col].description);
                System.out.println("There is an opening to the " + rooms[row][col].exitNames);
        }

        // To print game instructions for user
        void printInstructions()
        {
                System.out.println("Instructions: Navigate your way through the Cal Poly Underground.");
                System.out.println("Use the first letter of each directions to navigate.");
                System.out.println("For example: n = north, south = south, southwest = sw, etc.");
                System.out.println("In each room you are given 8 commands: drop, inventory, look, examine, restore, save, take, touch.");
                System.out.println("If you want to quit the game, type the command: quit");
                System.out.println("\nEnjoy!\n");
        }

        // When player save, it saves the artifacts and it's location to save file
        void save(PrintWriter pw)
        {
                 for(int r =0;r < rooms.length;r++)
                {
                        for(int c=0;c < rooms[r].length;c++)
                        {
                                 if(rooms[r][c] != null)
                                {
                                        if(rooms[r][c].content != null)
                                        {
                                                pw.println("Artifact"+","+rooms[r][c].content.name+","+ r +","+ c);
                                        }
                                }
                        }
                }
        }
}
