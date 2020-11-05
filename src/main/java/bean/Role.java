package bean;

import java.util.Objects;

public class Role {

    private String login;
    private String password;
    private String role;



    public Role( String login,String password,String role) {
        this.login = login;
        this.password = password;
        this.role=role;

    }
    public Role( String login,String password) {
        this.login = login;
        this.password = password;
        this.role="USER";

    }
    public Role( String login) {

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role) &&
                Objects.equals(password, role1.password) &&
                Objects.equals(login, role1.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash( login,password,role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
