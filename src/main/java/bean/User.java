package bean;

import java.util.Objects;

public class User {

    private String login;
    private String password;
    private int role;



    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.role=role;

    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;


    }
    public User(String login) {

        this.login = login;


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return role == user1.role &&
                Objects.equals(login, user1.login) &&
                Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
