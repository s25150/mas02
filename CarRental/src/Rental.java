import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rental {

    private static List<Rental> extent = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private static Set<RentalEmployee> allEmployees = new HashSet<>();
    private List<RentalEmployee> employees = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private String rentalId;

    public Rental(String rentalId) {
        this.rentalId = rentalId;
        addRental(this);
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

    private static void addRental(Rental rental){
        extent.add(rental);
    }
    private static void removeRental(Rental rental) {
        extent.remove(rental);
        for(RentalEmployee re: rental.employees){
            for(RentalEmployee allemp: allEmployees){
                if(re==allemp){
                    allEmployees.remove(allemp);
                }
            }
            rental.removeEmployee(re);
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

    public void showCars(){
        System.out.println("Cars in rental " + this.getRentalId());
        for(Car c : cars){
            System.out.print("CarId:"+c.getIdCar() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void showEmployees(){
        System.out.println("Employees in rental " + this.getRentalId());
        for(RentalEmployee e : employees){
            System.out.print("Employee " + e.getName() + " " + e.getSurname() + " \n");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Rental [id]" + rentalId + " ";
    }
}
