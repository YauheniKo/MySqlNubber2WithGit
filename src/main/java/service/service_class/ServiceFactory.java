package service.service_class;

import service.service_inerf.ServiceInterf;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ServiceInterf serviceCar = new CarService();

    private final ServiceInterf serviceRole = new UserService();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ServiceInterf getServiceCar() {
        return serviceCar;
    }

    public ServiceInterf getServiceRole() {

        return serviceRole;
    }
}
