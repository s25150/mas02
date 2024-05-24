import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        DataBase.readFile();

        Car car1 = new Car("Fiat", "Punto", 2002, 5, 50);
        Car car2 = new Car("Honda", "Civic", 2015, 3, 120);
        //Car.showExtent();

        Client client1 = new Client("Julia", "Beverly", LocalDate.of(2001, 1, 23));
        List<String> client2LikedBrands= new ArrayList<>();
        client2LikedBrands.add("Suzuki");
        Client client2 = new Client("Michael", "Moller", LocalDate.of(1994, 3, 11), client2LikedBrands);

        //Client.showExtent();

        client1.addLikedBrands("Audi", "Mazda");
        //Client.showExtent();
        //client1.getLikedBrands();

        Employee emp1 = new Employee("Marcin", "Brzytwa", LocalDate.of(1966, 12, 11));
        Client client3 = new Client(emp1);
        //Client.showExtent();
        //Employee.showExtent();


        //asocjacja zwykla Car i Rental
        Rental rental1 = new Rental("R1");
        Rental rental2 = new Rental("R2");
        rental1.addCars(car1);
        rental1.addCars(car2);
        rental1.showCars();

        //asocjacja z atrybutem Car i person (CarRent)
        CarRent<Client> carrent1 = new CarRent<>(LocalDate.of(2002, 12, 11),LocalDate.of(2002, 12, 15), car1, client2);
        CarRent<Client> carrent2 = new CarRent<>(LocalDate.of(2023, 6, 23),LocalDate.of(2002, 6, 24), car2, client2);
        CarRent<Employee> carrent3 = new CarRent<>(LocalDate.of(2002, 12, 11),LocalDate.of(2002, 12, 15), car1, emp1);
        System.out.println(carrent3.getCar() +"\n");

        //asocjacja kwalifikowana Rental i Manager
        Manager manager1 = new Manager("John", "Trevor", LocalDate.of(1985, 10, 13));
        manager1.addRentalsQualif(rental2);
        System.out.println(manager1.findRentalQualif("R2") + "\n");
        //System.out.println(manager1.findRentalQualif("R1"));

        //kompozycja RentalEmployee i Rental
        RentalEmployee.createRentalEmployee(rental2, "Maciej", "Kopka", LocalDate.of(1981, 9, 2));
        RentalEmployee.createRentalEmployee(rental2, "Anna", "Bzuk", LocalDate.of(1975, 3, 23));
        rental2.showEmployees();


        //CarRent.showExtent();

        //DataBase.writeFile();



    }
}