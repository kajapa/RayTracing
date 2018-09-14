package Camera;

import Primitives.*;

public class Ortho extends Camera {
    public cVector CameraPosition;
    public float angle;
    public cVector2 size;

    public Ortho(cVector cameraPosition, float angle, cVector2 size) {
        CameraPosition = cameraPosition;
        this.angle = angle;
        this.size = size;
    }

    @Override
    public cRay CameraRay(cVector2 pixel) {
        cVector dir= new cVector((float)Math.sin(angle),0f,(float)Math.cos(angle));
        dir=dir.normalized();
        cVector2 centerDistance= new cVector2(pixel.x*size.x,pixel.y*size.y);

        cVector position = new cVector(CameraPosition.x+centerDistance.x*(float)Math.cos(angle),CameraPosition.y+centerDistance.y,CameraPosition.z+centerDistance.x*(float)Math.sin(angle));

        return new cRay(position,dir);

    }
}
