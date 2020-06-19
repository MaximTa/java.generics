package ru.geekbrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class App extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(AppConfiguration.class);
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication application = new SpringApplication(App.class);
        application.setApplicationContextClass(AnnotationConfigWebApplicationContext.class);
        SpringApplication.run(App.class, args);
        fillBox();//hw1

     }
    public static void fillBox(){
        Box<Apple> boxWithApple = new Box<>(new Apple(), new Apple(), new Apple()); //picking apples in box
        Box<Orange> boxWithOranges = new Box<>(new Orange(), new Orange()); //picking apples in box
        Box<Orange> anotherBoxWithOranges = new Box<>();
        System.out.println("A box of apples weighs " + boxWithApple.getWeight()); //weight box with apples
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight()); //weight box with apples
        System.out.println(boxWithApple.compare(boxWithOranges));
        boxWithOranges.replaceFruitsToAnotherBox(anotherBoxWithOranges);
        System.out.println(boxWithOranges.getBox());
        System.out.println(anotherBoxWithOranges.getBox());
    }
}
