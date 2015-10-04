
package gcpuapp2;

import java.util.Scanner;

public class Room {

        String name, description, exits[], exitNames, _name;
        Artifact content;
        int count;
        Backpack pack;

        Room()
        {

        }

        String getExits()
        {
                return "There is an opening to the " + exitNames;
        }

        // Check for valid exits
        boolean isValidExit(String anExit) {
                boolean result = false;

                int index = 0;
                while (result == false && index < exits.length) {
                        if (exits[index].equals(anExit)) {
                                result = true;
                        }

                        index++;
                }

                return result;
        }

        // When user drops artifact into room
        String drop(String name)
        {
                
                Artifact removeArtifact = pack.removeArtifact(name);
                if(removeArtifact !=null)
                {
                        if (content == null)
                        {
                                content = removeArtifact;
                                return "[" + content.name+"] dropped";
                        }
                        else
                        {
                                Artifact anyArtifact = content;
                                content = removeArtifact;
                                 pack.setArtifact(anyArtifact);
                                 return "[" + removeArtifact.name +"] dropped\n"+"["+anyArtifact.name+"] taken";
                        }
                }
                else
                if(pack.count() == 0)
                        return "You have nothing to drop.";
                else
                        return "You don't have " + name + " to drop.";
                
        }
        
        // User examine room
        String examine() {
                if (content != null) {
                        return content.examine();
                }
                return "There is nothing here.";
        }

        // User looks in room
        String look()
        {
                System.out.println(name);
                System.out.println(getExits());

                if (content != null) 
                        return "You see " + content.name + " here.";

                return "There is nothing here in the " + this.name + ".";
        }

        // User takes artifact from room
        public String take()
        {
                if(content != null)
                {
                        String message = pack.take(content);
                        content = null;
                        return message;             
                }
                
                return "There is nothing to take.";
        }
        
        // User touches artifacts in room
        String touch()
        {
                if (content != null)
                {
                        return content.touch();
                }
                return "There is nothing to touch.";
        }
        
}
