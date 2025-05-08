import java.util.Random;

public class UserNameGenerator {

    public static String generateUserName(String requestorName) {
        if (requestorName == null || !requestorName.contains(",")) {
            throw new IllegalArgumentException("Input must be in 'FirstName,LastName' format");
        }

        String firstName = requestorName.split(",")[0].trim();

        // Generate random 3-digit number (100–999)
        int randomNumber = new Random().nextInt(900) + 100;

        return firstName + randomNumber;
    }

    public static void main(String[] args) {
        String requestorName = "John,Doe";
        String userName = generateUserName(requestorName);
        System.out.println("Generated Username: " + userName);
    }
}
