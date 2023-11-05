package TestData;

public class User {
    private String username;
    private String password;
    private String expectedErrorMessage;

    private String expectedUrl;
    private String firstName;
    private String lastName;
    private String postalCode;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String expectedUrl) {
        this.username = username;
        this.password = password;
        this.expectedUrl = expectedUrl;
    }

    public User(String username, String password, String expectedUrl, String expectedErrorMessage) {
        this.username = username;
        this.password = password;
        this.expectedUrl = expectedUrl;
        this.expectedErrorMessage = expectedErrorMessage;
    }
    public User (String username, String password, String firstName, String lastName, String postalCode){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
