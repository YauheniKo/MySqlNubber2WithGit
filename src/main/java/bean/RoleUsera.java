package bean;

import java.util.Objects;

public class RoleUsera {

    private int id;
    private String role;

    public RoleUsera(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleUsera() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        RoleUsera roleUsera = (RoleUsera) o;
        return id == roleUsera.id &&
                Objects.equals(role, roleUsera.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "RoleUsera{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
