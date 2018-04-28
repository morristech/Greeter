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
=======

    Copyright 2018 Joel R Sosa

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
