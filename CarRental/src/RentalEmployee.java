import java.time.LocalDate;

public class RentalEmployee extends Employee {
    private RentalEmployee(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public static RentalEmployee createRentalEmployee(Rental rental, String name, String surname, LocalDate birthDate)
        throws Exception{
            if(rental == null){
                throw new Exception("Wypożyczalnia nie istnieje");
            }

            RentalEmployee employee = new RentalEmployee(name, surname, birthDate);

            rental.addEmployee(employee);

            return employee;

    }
    //kompozycja
}
