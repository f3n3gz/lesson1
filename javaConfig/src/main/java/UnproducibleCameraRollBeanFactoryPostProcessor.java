import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class UnproducibleCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);

            String className = beanDefinition.getBeanClassName();

            if (className != null) {
                try {
                    System.out.println(className);
                    Class<?> beanClass = Class.forName(className);

                    UnproducibleCameraRoll annotation = (UnproducibleCameraRoll) beanClass.getAnnotation(UnproducibleCameraRoll.class);

                    if (annotation != null) {
                        Class usingCameraRollName = annotation.usingCameraRollClass();

                        beanDefinition.setBeanClassName(usingCameraRollName.getName());
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
