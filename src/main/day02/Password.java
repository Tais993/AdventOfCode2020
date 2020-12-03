package main.day02;

public class Password {
    private final int minRequired;
    private final int maxRequired;
    private final char charRequired;
    private final String password;

    public Password(int minRequired, int maxRequired, char charRequired, String password) {
        this.minRequired = minRequired;
        this.maxRequired = maxRequired;
        this.charRequired = charRequired;
        this.password = password;
    }

    public char getCharRequired() {
        return charRequired;
    }

    public int getMaxRequired() {
        return maxRequired;
    }

    public int getMinRequired() {
        return minRequired;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidPartOne() {
        int count = password.length() - password.replaceAll(Character.toUpperCase(charRequired) + "","").length();
        count += password.length() - password.replaceAll(Character.toLowerCase(charRequired) + "","").length();
        return count >= minRequired && count <= maxRequired;
    }

    public boolean isValidPartTwo() {
        int count = password.charAt(minRequired - 1) == charRequired ? 1 : 0;
        if (password.length() >= maxRequired) {
            count += password.charAt(maxRequired - 1) == charRequired ? 1 : 0;
        }

        return count == 1;
    }

    @Override
    public String toString() {
        return "Password{" +
                "minRequired=" + minRequired +
                ", maxRequired=" + maxRequired +
                ", charRequired=" + charRequired +
                ", password='" + password + '\'' +
                '}';
    }
}
