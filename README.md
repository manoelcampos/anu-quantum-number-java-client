# A Java client to get real random integers from https://quantumnumbers.anu.edu.au [![build](https://github.com/manoelcampos/anu-quantum-number-java-client/actions/workflows/build.yml/badge.svg)](https://github.com/manoelcampos/anu-quantum-number-java-client/actions/workflows/build.yml)

## How to use

Create an account at https://quantumnumbers.anu.edu.au and get an API key.

Include the library inside your project's pom.xml:

```xml
<dependency>
    <groupId>com.manoelcampos</groupId>
    <artifactId>anu-quantum-number-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

Create a .env file inside your project root dir and insert your API key, as demonstrated in [ .env.example]( .env.example).