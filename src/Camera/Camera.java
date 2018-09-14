package Camera;

import Primitives.cRay;
import Primitives.cVector;
import Primitives.cVector2;

public abstract class Camera {
    public abstract cRay CameraRay(cVector2 positon);
}
