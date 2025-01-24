package com.javafundamentalAssignment3.app;

/**
 * Represents a user in the system with user name, password, and security question.
 */
class User {
    private String username;
    private String password;
    private String Question;
    private String Answer;

    /**
     * Constructs a new User with specified details.
     *
     * @param username     the user name of the user
     * @param password     the password of the user
     * @param hintQuestion the security question for the user
     * @param hintAnswer   the answer to the security question
     */
    public User(String username, String password, String Question, String Answer) {
        this.username = username;
        this.password = password;
        this.Question = Question;
        this.Answer = Answer;
    }

    /**
     * Validates user credentials.
     *
     * @param username the entered user name
     * @param password the entered password
     * @return true if credentials match, false otherwise
     */
    public boolean validate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /**
     * Gets the user name of the user.
     *
     * @return the user name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the hint question of the user.
     *
     * @return the hint question
     */
    public String getQuestion() {
        return Question;
    }

    /**
     * Validates the answer to the hint question.
     *
     * @param answer the entered answer
     * @return true if the answer matches, false otherwise
     */
    public boolean validateAnswer(String answer) {
        return this.Answer.equalsIgnoreCase(answer);
    }

    /**
     * Sets a new password for the user.
     *
     * @param newPassword the new password to set
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
