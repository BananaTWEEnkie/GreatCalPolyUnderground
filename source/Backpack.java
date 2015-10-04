package gcpuapp2;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Backpack
{

        // Create an arraylist for back pack to hold
        private ArrayList<Artifact> contents = new ArrayList<Artifact>();

        // Clear backpack when user restores
        void clear()
        {
                for(int r =0;r < contents.size();r++)
                {
                        contents.clear();
                }
        }
        
        // Check backpack space
        public int count()
        {
                return contents.size();
        }

        public void setArtifact(Artifact anyArtifact)
        {
                contents.add(anyArtifact);
        }
        
        // User types inventory, display appropriate artifacts
        public String list()
        {
                if (contents.size() == 1) 
                        return "You are carrying " + this.contents.get(0).name+".";
               else
               if(contents.size()==2)
                       return "You are carrying " + this.contents.get(0).name+" and "+this.contents.get(1).name+".";
               else
                if(contents.size()==3)
                         return "You are carrying " + this.contents.get(0).name+", "+this.contents.get(1).name+" and "+this.contents.get(2).name+".";
                else 
                        return "Your pack is empty";
        }
        
        public Artifact removeArtifact(String name)
        {
                String loweredName = name.toLowerCase();
                
                for(int i = 0;i  < contents.size();i++)
                {
                        if(this.contents.get(i).name.equals(loweredName))
                        {
                                return contents.remove(i);
                        }
                }

                return null;
        }
        
        // Write to text file what's in user inventory when they save
        void save(PrintWriter pw)
        {
                for(int i = 0;i < contents.size();i++)
                {
                        pw.println("Inventory"+","+this.contents.get(i).name);
                }
        }
        
        void setInventory(String itemName)
        {
                
        }
        
        // When user takes, put artifact in backpack. Also checks to not exceed more than 3 artifacts at a time
        public String take(Artifact content)
        {
                setArtifact(content);

                if(contents.size() > 3)
                        return "You can only hold up to 3 artifacts at a time!";  
                
                return "You have taken " + content.name;             
        }

}
