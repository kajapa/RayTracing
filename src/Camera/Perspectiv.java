package Camera;

import Primitives.*;

public class Perspectiv extends Camera {
    public OrthoBase onb;
    public cVector origin;
    float distance;

    public Perspectiv(cVector origin, cVector lookat, cVector up, float distance) {
        this.origin = origin;
        this.onb= new OrthoBase(origin,lookat,up);
        this.distance = distance;
    }

    @Override
    public cRay CameraRay(cVector2 positon) {
        return new cRay(origin,RayDir(positon));
    }
    public cVector RayDir(cVector2 pos)
    {
        return new cVector().multiply(onb,(new cVector(pos.x,pos.y,-distance)));
    }
}
