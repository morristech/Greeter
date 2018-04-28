# Greeter
Onboard your users in a simple and clean way. 

Tired of writing the same onboarding code when you first start your Android apps? Greeter might help. 

#### How does it work?  

Greeter is desinged for fast prototyping an onboarding experience so you dont have to deal with implementing the same ViewPager, PagerAdapter and related Fragments over an over again.  

#### Show me!  

Once you added the library you'll need to register a GreetActivity to your manifest.  

```xml  
  <activity
            android:name="com.jrsosadev.greeter.GreetActivity"
            android:launchMode="singleTop" />  
```  

From here you just need to create some `Greet` objects and add them to an `ArrayList<Greet>`. `Greet` objects are `Parcelable` friendly so the work ultra fast when passing around extras, which is the next thing to do.  

```java  
ArrayList<Greet> greets = new ArrayList<>();
greets.add(new Greet("Greeter Android Library", "Greeter is an easy to use onboarding library. Tired of writing the same initial onboarding experience? No more! ","https://images.pexels.com/photos/33684/astronaut-spacewalk-iss-tools.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
greets.add(new Greet("Test2", "subtitle2","http://via.placeholder.com/350x150"));
        
```  

#### Almost done! 
Just create an intent with  the list as a `ParcelableArrayListExtra`. Make sure you are using the built in `GreetActivity.GREET_BUNDLE_EXTRA` as the key value or it won't work. 
```java
Intent greetUserIntent = new Intent(this, GreetActivity.class);
greetUserIntent.putParcelableArrayListExtra(GreetActivity.GREET_BUNDLE_EXTRA, greets);

startActivity(greetUserIntent);  				
```  

#### Really, only a few lines?  
Yeap, here is the demo running.   
<img src="https://github.com/jrsosadev/Greeter/blob/master/greeterdemo/screenshot.png"   />




License
MIT License

Copyright (c) 2018 Joel R. Sosa

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
