package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.plaf.SpinnerUI;
import java.util.Map;

/**
 * 主程序类/主配置类
 *
 * @author chenpi
 * @SpringBootApplication 这是一个Spring boot应用
 * @create 2022-10-17 20:23
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
        // Pet tom01 = run.getBean("tom", Pet.class);
        // Pet tom02 = run.getBean("tom", Pet.class);
        // System.out.println(tom01 == tom02);
        //
        // //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$f59b6e0c@253c1256
        // MyConfig bean = run.getBean(MyConfig.class);
        // System.out.println(bean);
        //
        // //测试通过配置类的注册方法获取组件是否是一致的
        // //如果@Configuration(proxyBeanMethods = true) 代理对象调用方法。SpringBoot总会检查这个组件是否在容器中存在
        // //保持组件单实例
        // User user = bean.user01();
        // User user1 = bean.user01();
        // System.out.println(user == user1);
        //
        // User user01 = run.getBean("user01", User.class);
        // Pet tom = run.getBean("tom", Pet.class);
        // System.out.println("用户中的宠物：" + (user01.getPet() == tom));
        //
        //
        // //5、获取组件
        // String[] beanNamesForType = run.getBeanNamesForType(User.class);
        // System.out.println("======");
        // for (String s : beanNamesForType) {
        //     System.out.println(s);
        // }
        // DBHelper dbHelper = run.getBean(DBHelper.class);
        // System.out.println(dbHelper);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);
        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);

        boolean haha = run.containsBean("haha");
        System.out.println("容器中haha组件："+haha);
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中hehe组件："+hehe);

    }

}
