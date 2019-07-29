import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    public static UnproducibleCameraRollBeanFactoryPostProcessor unproducibleRollBeanFactoryPostProcessor() {
        return new UnproducibleCameraRollBeanFactoryPostProcessor();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean("cameraRollOne")
    public CameraRoll cameraRollOne() {
        return new CameraRollColor();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean("cameraRollTwo")
    public CameraRoll cameraRoll() {
        return new CameraRollBlackAndWhite();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean("camera")
    public Camera camera(CameraRoll cameraRollTwo) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRollTwo);
        return camera;
    }


}
