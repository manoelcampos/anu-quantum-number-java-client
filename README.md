# A Java client to get real random integers from https://quantumnumbers.anu.edu.au [![build](https://github.com/manoelcampos/anu-quantum-number-java-client/actions/workflows/build.yml/badge.svg)](https://github.com/manoelcampos/anu-quantum-number-java-client/actions/workflows/build.yml) [![javadoc](https://javadoc.io/badge2/com.manoelcampos/anu-quantum-number-client/javadoc.svg)](https://javadoc.io/doc/com.manoelcampos/anu-quantum-number-client)

## How to use

Create an account at https://quantumnumbers.anu.edu.au and get an API key.

Include the library inside your project's pom.xml:

```xml
<dependency>
    <groupId>com.manoelcampos</groupId>
    <artifactId>anu-quantum-number-client</artifactId>
    <version>1.1.1</version>
</dependency>
```

## Example

Check an example inside the [main method here](https://github.com/manoelcampos/anu-quantum-number-java-client/blob/master/src/main/java/com/manoelcampos/anuquantumnumbers/AnuQuantumNumberClient.java#L93).

The example is loading the service API key from a .env file.
In order to make it work in your project, create a .env file inside the project root dir and insert your API key, as demonstrated in [ .env.example]( .env.example).

If you don't want to use an .env file, just pass the API key to the `AnuQuantumNumberClient` constructor.