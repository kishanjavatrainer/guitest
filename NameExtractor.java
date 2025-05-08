public class NameParser {

    public static String getFirstName(String requestorName) {
        if (requestorName == null || !requestorName.contains(",")) {
            throw new IllegalArgumentException("Input must be in 'FirstName,LastName' format");
        }
        return requestorName.split(",")[0].trim();
    }

    public static String getLastName(String requestorName) {
        if (requestorName == null || !requestorName.contains(",")) {
            throw new IllegalArgumentException("Input must be in 'FirstName,LastName' format");
        }
        return requestorName.split(",")[1].trim();
    }

    public static void main(String[] args) {
        String requestorName = "Alice,Smith";
        String firstName = getFirstName(requestorName);
        String lastName = getLastName(requestorName);

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }
}
