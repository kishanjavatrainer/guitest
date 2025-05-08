public class NameExtractor {

    public static void getFirstAndLastName(String requestorName) {
        if (requestorName == null || !requestorName.contains(",")) {
            throw new IllegalArgumentException("Input must be in 'FirstName,LastName' format");
        }

        String[] parts = requestorName.split(",");
        String firstName = parts[0].trim();
        String lastName = parts[1].trim();

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }

    public static void main(String[] args) {
        String requestorName = "Alice,Smith";
        getFirstAndLastName(requestorName);
    }
}
