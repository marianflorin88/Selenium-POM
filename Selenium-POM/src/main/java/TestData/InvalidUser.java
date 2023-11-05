package TestData;

public class InvalidUser {
    private String invalidUsername;
    private String password;
    private String expectedErrorMessage;

    public InvalidUser(String invalidUsername, String password, String expectedErrorMessage) {
        this.invalidUsername = invalidUsername;
        this.password = password;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }
}