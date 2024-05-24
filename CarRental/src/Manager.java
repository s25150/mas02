import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Manager extends Employee{

    private Map<String, Rental> rentalsQualif = new TreeMap<>();
    public Manager(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public void addRentalsQualif(Rental newRental){
        if(!rentalsQualif.containsKey(newRental.getRentalId())){
            rentalsQualif.put(newRental.getRentalId(), newRental);
            newRental.addManager(this);
        }
    }

    public Rental findRentalQualif(String id) throws Exception{
        if(!rentalsQualif.containsKey(id)){
            throw new Exception("Unable to find Rental: " + id);
        }

        return rentalsQualif.get(id);
    }
}
