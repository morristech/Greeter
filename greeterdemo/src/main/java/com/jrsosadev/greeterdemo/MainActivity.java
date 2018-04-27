package com.jrsosadev.greeterdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.jrsosadev.greeter.Greet;
import com.jrsosadev.greeter.GreetActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Greet> greets = new ArrayList<>();
        greets.add(new Greet("Greeter Android Library", "Greeter is an easy to use onboarding library. Tired of writing the same initial onboarding experience? No more! ","https://images.pexels.com/photos/33684/astronaut-spacewalk-iss-tools.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
        greets.add(new Greet("Test2", "subtitle2","http://via.placeholder.com/350x150"));
        greets.add(new Greet("Title3", "title3", "http://via.placeholder.com/350x150"));
        greets.add(new Greet("Test2", "subtitle2","http://via.placeholder.com/350x150"));
        greets.add(new Greet("Title3", "title3", "http://via.placeholder.com/350x150"));

        Intent greetUserIntent = new Intent(this, GreetActivity.class);
        greetUserIntent.putParcelableArrayListExtra(GreetActivity.GREET_BUNDLE_EXTRA, greets);

        startActivity(greetUserIntent);
    }
}
