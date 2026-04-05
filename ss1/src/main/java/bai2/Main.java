package bai2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PlaySession session1 = context.getBean(PlaySession.class);
        PlaySession session2 = context.getBean(PlaySession.class);

        session1.addTime(2);
        session2.addTime(1);

        System.out.println("Máy 01: " + session1.getPlayTime() + " giờ");
        System.out.println("Máy 02: " + session2.getPlayTime() + " giờ");
    }
}
