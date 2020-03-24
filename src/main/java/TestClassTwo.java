

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassTwo extends testngBase{
    @Test()
    public void firstTestMethod() {
        System.out.println("First test method from class 2");
    }

    @Test()
    public void secondTestMethod() {
        System.out.println("Second test method from class 2");
        Assert.assertTrue(false);
    }
}