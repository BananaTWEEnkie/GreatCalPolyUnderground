
package gcpuapp2;

public class Artifact
{

        String name, description;

        Artifact()
        {

        }

        // Passes name into map and room
        Artifact(String aName) {
                this.name = aName;
        }

        // Passes description to map and room
        Artifact(String aName, String aDescription) {
                this(aName);
                this.description = aDescription;
        }

        // User examine artifact
        String examine() {

                return this.description;

        }

        // User touches artifact
        String touch() {
                return "Nothing happens.";
        }

}
