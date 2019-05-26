# Java 11 to Java12 kata
Kata to discover new features introduced in Java 12

## What do I have to do ?
Find the TODO and adapt the code to use new features of Java 12.

You will discover new methods with the String and Files classes.

There are also 2 new ways of writing switch.

You will also discover the usage of a new Collector.

## Summary about new used features
### String
* indent
* transform

### Files
* mismatch

### Switch
* Two new ways of writing a switch :
  * Quite classical but more compact
  * More functional
  
Unfortunately, these improvements are still experimental and need to be activated to be used.
Have a look into the POM file and you'll see that we pass a specific argument to the compiler for that.

### Collectors
* teeing