package Models;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
    private static final String NUMBERS = "1234567890";
    private static final String COMBINED = UPPERCASE_LETTERS + LOWERCASE_LETTERS + SPECIAL_CHARACTERS + NUMBERS;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        System.out.println(generatePassword(20));
        System.out.println(generatePassword(15));
        System.out.println(generatePassword(10));

    }
    public static String generatePassword(int length){

        return IntStream.range(0,length)
                .map(i -> random.nextInt(COMBINED.length()))
                .mapToObj(randomIdx -> String.valueOf(COMBINED.charAt(randomIdx)))
                .collect(Collectors.joining());
    }
}
