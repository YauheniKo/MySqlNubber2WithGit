package bean;

import java.util.Objects;

public class Car {

    private int id;
    private String model;
    private String type;

    public Car(){

    }
    public Car(int id){
        this.id=id;
    }

    public Car(String model){
        this.model=model;
    }



    public Car( String model, String type) {
        this.model = model;
        this.type = type;
    }

    public Car(int id, String model, String type) {
        this.id = id;
        this.model = model;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                model.equals(car.model) &&
                type.equals(car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, type);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}'+"\n";
    }
}
