import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car implements Serializable {
    private static List<Car> extent = new ArrayList<>();
    private List<CarRent> carRents = new ArrayList<>();
    private Rental rental;
    private String brand;
    private String model;
    private int yearOfManufacture;

    private enum type{
        SUV, COUPE, SEDAN, HATCHBACK, CABRIOLET, CROSSOVER, MINIVAN;
    }
    private int numberOfDoors;
    private int rentCost; // per day
    private LocalDate dateOfCreation;
    private int idCar;
    private static int id = 0;

    public Car(String brand, String model, int yearOfManufacture, int numberOfDoors, int rentCost) {
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.numberOfDoors = numberOfDoors;
        this.rentCost = rentCost;
        this.dateOfCreation = LocalDate.now();
        this.idCar = ++id;
        addCar(this);
    }


    public void setRental(Rental newRental){
        if(!(rental == null)){
            removeRental();
        }
        rental = newRental;
        newRental.addCars(this);
    }

    public void removeRental(){
        rental.removeCar(this);
        rental = null;
    }

    public void addCarRent(CarRent cc){
        carRents.add(cc); //możliwe wielorazowe wypożyczanie tego samego auta przez tego samego klienta
    }
    private static void addCar(Car car){
        extent.add(car);
    }
    public static void removeCar(Car car) {
        extent.remove(car);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Car");

        for (Car c : extent) {
            System.out.println(c);
        }
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public int getIdCar() {
        return idCar;
    }

    @Override
    public String toString() {
        return "CarId= " + idCar +
                ", brand= " + brand +
                ", model= " + model +
                ", yearOfManufacture= " + yearOfManufacture +
                ", numberOfDoors= " + numberOfDoors +
                ", rentCost= " + rentCost +
                ", dateOfCreation= " + dateOfCreation;
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Car>) stream.readObject();
    }
}
