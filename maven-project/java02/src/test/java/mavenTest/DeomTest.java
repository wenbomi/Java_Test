package mavenTest;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName DeomTest
 * @Author Xiao Mi
 * @Date 2023/2/6 15:32
 * 简介：
 */
public class DeomTest {
    @Test
    public void sayTest(){
        Demo demo = new Demo();
        String sap = demo.say("SAP");
        Assert.assertEquals("hello SAP",sap);
    }
}
