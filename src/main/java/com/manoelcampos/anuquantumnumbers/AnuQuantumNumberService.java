package com.manoelcampos.anuquantumnumbers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

/**
 * Client to <a href="https://quantumnumbers.anu.edu.au">ANU Quantum Numbers</a> service.
 * You need to create an account at the website and then an API key.
 * Create a .env file inside your project root directory
 * and insert the line below:
 *
 * <p>
 * ANU_QUANTUM_NUMBERS_APIKEY=you-api-key
 * </p>
 *
 * or create an environment variable with the name shown above.
 *
 * @author Manoel Campos da Silva Filho
 * @see <a href="https://quantumnumbers.anu.edu.au/documentation">API Docs</a>
 */
public class AnuQuantumNumberService {
    private static final String API_PATH = "https://api.quantumnumbers.anu.edu.au";
    private final String API_KEY;
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    /**
     * Instantiates an object for sending requests to the random.org service
     * to generate real random values.
     */
    public AnuQuantumNumberService() {
        objectMapper = new ObjectMapper();

        final var dotenv = Dotenv.load();
        API_KEY = dotenv.get("ANU_QUANTUM_NUMBERS_APIKEY");
        client = HttpClient.newBuilder().build();
    }

    /**
     * Generates a given total of real random integers between [0 .. 255].
     *
     * @param length the total of random integers to generate.
     * @return an array containing the generated integers
     */
    public int[] generateInt8Numbers(final int length) {
        return generateNumbers(length, NumberType.uint8);
    }

    /**
     * Generates a given total of real random integers between [0 .. 65535].
     *
     * @param length the total of random integers to generate.
     * @return an array containing the generated integers
     */
    public int[] generateInt16Numbers(final int length) {
        return generateNumbers(length, NumberType.uint16);
    }

    /**
     * Generates a given total of real random integers.
     *
     * @param length the total of random integers to generate.
     * @param type   the type of the integers, indicating the maximum value to generate
     *               (starting from 0)
     * @return an array containing the generated integers
     */
    private int[] generateNumbers(final int length, final NumberType type) {
        try {
            final var req =
                    HttpRequest
                            .newBuilder(new URI(API_PATH + "?length=%d&type=%s".formatted(length, type.name())))
                            .header("content-type", "application/json")
                            .header("x-api-key", API_KEY)
                            .GET()
                            .build();

            final String res = client.send(req, HttpResponse.BodyHandlers.ofString()).body();
            final var response = objectMapper.readValue(res, Response.class);
            return response.getData();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(final String[] args) {
        final var randomService = new AnuQuantumNumberService();
        final int n = 4;
        System.out.printf(
                "Generating %d real random integers from [0 .. %d] using %s%n",
                n, NumberType.uint16.maxValue(), randomService.getClass().getSimpleName());
        Arrays.stream(randomService.generateInt16Numbers(n)).forEach(System.out::println);
    }
}

