package gorest.co.in.FAKER;

import com.github.javafaker.Faker;


public class faker {
    static Faker faker;
    public static String name(){
        faker=new Faker();
        String name=faker.name().fullName();
        return name;
    }

    public static String email(){
        faker=new Faker();
        String emailAddress=faker.internet().emailAddress();
        return emailAddress;
    }
    public static Integer id(){
        faker=new Faker();
        Integer xid=faker.number().numberBetween(10,99);
        return xid;
    }

}
