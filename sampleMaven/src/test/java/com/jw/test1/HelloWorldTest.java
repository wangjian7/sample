package com.jw.test1;

/**
 * Created by hengsheng.wj on 2016/4/26.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorld();

        String result = helloWorld.sayHello();

        assertEquals("Hello Maven", result);
    }
}
