import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rental {
    private List<Car> cars = new ArrayList<>();
    private static Set<RentalEmployee> allEmployees = new HashSet<>();
    private List<RentalEmployee> employees = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private String rentalId;

    public Rental(String rentalId) {
        this.rentalId = rentalId;
    }

    public void addEmployee(RentalEmployee employee) throws Exception{
        if(!employees.contains(employee)){
            if(allEmployees.contains(employee)){
                throw new Exception("This employee works for another rental");
            }
            employees.add(employee);
            allEmployees.add(employee);
        }
    }

    public void addCars(Car car) {
        if(!cars.contains(car)){
            cars.add(car);
            car.setRental(this);
        }else{
            System.out.println("Car " + car.getIdCar() + " already exists in this rental");
        }

    }

    public String getRentalId() {
        return rentalId;
    }

    public void removeCar(Car car){
        cars.remove(car);
        car.removeRental();
    }

    public void addCars(List<Car> newCars) {
        for(Car c : newCars){
            addCars(c);
        }
    }


    public void addManager(Manager manager){
        managers.add(manager);
    }


    public void removeManager(Manager manager){
        managers.remove(manager);
    }


    public void removeEmployee(RentalEmployee employee){
        employees.remove(employee);
        allEmployees.remove(employee);
    }
}
