# Best coding practices

## Please use documentation code!!!
Make sure you add documentation code to all your methods and classes!
Here's how you can do this (make sure to use two stars after the `/` in the start of the documentation code):
```java
/**
 * Returns the passed in integer as a string
 * @param someParam The integer to convert into a String.
 * @return The String representation of the integer passed in.
 */
public static String someMethod(int someParam) {
    return someParam.toString();
}
```

## Use comment code in all your methods
I don't want to have to debug your code to know what it does if it's confusing, so please use comment code in all your methods!!

## FOLLOW JAVA CODING CONVENTIONS!!!
For example, packages are always lowercase and should be in the form of a domain in reverse (`com.example`), 
classes, interfaces, enums, and annotations should be pascal case (`SomeClass`), and methods, fields, and variables should be camel case (`someMethod`).