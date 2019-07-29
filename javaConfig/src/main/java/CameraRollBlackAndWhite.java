import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproducibleCameraRoll(usingCameraRollClass = CameraRollColor.class)
public class CameraRollBlackAndWhite implements CameraRoll {
    public void processing() {
        System.out.println("-1 black and white frame");
    }
}
