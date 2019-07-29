package annotationTest;

import org.springframework.stereotype.Component;

@Component("cameraRollColor")
public class CameraRollColor implements CameraRoll {
    public void processing() {
        System.out.println("-1 color frame");
    }
}
