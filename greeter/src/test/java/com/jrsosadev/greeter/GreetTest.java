package com.jrsosadev.greeter;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GreetTest {

    Greet greet;

    @Before
    public void init() {
        greet = new Greet("Greeter Library", "Simple and clean library to onboard people", "http://via.placeholder.com/350x150");

    }

    @Test
    public void validation_isCorrect() {
        greet.validate();
    }

}