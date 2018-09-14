package Light;

import Primitives.cVector;


public class Light {
    cVector position;
    LightIntensity Intesity ;
    public Light(cVector position, LightIntensity intesity) {
        this.position = position;
        this.Intesity = intesity;
    }

    public cVector getPosition() {
        return position;
    }

    public void setPosition(cVector position) {
        this.position = position;
    }

    public LightIntensity getIntesity() {
        return Intesity;
    }

    public void setIntesity(LightIntensity intesity) {
        Intesity = intesity;
    }
}
