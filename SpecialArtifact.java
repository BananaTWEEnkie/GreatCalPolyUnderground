
package gcpuapp2;

public class SpecialArtifact extends Artifact {

        String specialDescription, touchDescription;
        boolean powerStateOn, didTouch, didExamine;

        SpecialArtifact() {

        }

        SpecialArtifact(String aName) {
                super(aName);
        }

        // User examines special artifacts that allow special description to be viewed
        String examine() {
                didExamine = true;
                if (powerStateOn == false) {
                        return this.description;
                }

                return this.specialDescription;
        }

        // User touches special artifact, display appropriate messages
        String touch() {
                if (!powerStateOn && didExamine) {
                        didTouch = true;
                        this.powerStateOn = true;
                        return this.touchDescription;
                }
                if (!didExamine) {
                        return "You must examine first!";
                }

                this.powerStateOn = false;
                return this.description;
        }

}
