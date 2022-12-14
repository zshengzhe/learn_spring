package org.zsz.learnspring.d_properties.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Zhang Shengzhe
 * @create 2022-10-26 14:49
 */
public class BeanFactory {

  private static Properties PROPERTIES;

  // 使用静态代码块初始化properties，加载factory_d.properties文件
  static {
    PROPERTIES = new Properties();
    try {
      PROPERTIES.load(BeanFactory.class.getClassLoader().getResourceAsStream("d_properties/factory.properties"));
    } catch (IOException e) {
      throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
    }
  }

  public static Object getBean(String beanName) {
    try {
      // 从properties文件中读取指定name对应类的全限定名，并反射实例化
      Class<?> klass = Class.forName(PROPERTIES.getProperty(beanName));
      return klass.newInstance();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException("[" + beanName + "] instantiation error!", e);
    }
  }

}
