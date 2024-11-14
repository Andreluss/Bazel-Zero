package test.java.com.example;

import com.example.Greeting;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GreetingTest {

    @Test
    public void testSayHi() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Greeting.sayHi();

        // Assert
        Assert.assertEquals("Hi!\n", outContent.toString());

        // Clean up
        System.setOut(null);
    }
}