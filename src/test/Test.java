package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        Class<Test> classa = Test.class;
        InputStream resourceAsStream = classa.getResourceAsStream("/test/jdbc.properties");
        properties.load(resourceAsStream);
        String userName = properties.getProperty("username");
        System.out.println(userName);
        /*
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("test/jdbc.properties");
        properties.load(resourceAsStream);
        String username = properties.getProperty("username");
        System.out.println(username);
        */
    }
}
