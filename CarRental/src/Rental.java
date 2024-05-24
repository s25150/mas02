import java.util.ArrayList;
import java.util.List;

public class Rental {
    private List<Car> cars = new ArrayList<>();
    private List<RentalEmployee> employees = new ArrayList<>();
    private String rentalId;

    public Rental(String rentalId) {
        this.rentalId = rentalId;
    }

    public void addEmployee(RentalEmployee employee) throws Exception{
        if(!employees.contains(employee)){
            employees.add(employee);
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

    public void removeCar(Car car){
        cars.remove(car);
        car.removeRental();
    }

    public void addCars(List<Car> newCars) {
        for(Car c : newCars){
            addCars(c);
        }
    }

    public void addEmployees(RentalEmployee employee) {
        employees.add(employee);
    }

    public void addEmployees(List<RentalEmployee> newEmployees) {
        employees.addAll(newEmployees);
    }

    public void removeEmployee(RentalEmployee employee){
        employees.remove(employee);
    }
}
