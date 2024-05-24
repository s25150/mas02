import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Employee extends Person implements Serializable {
    private static List<Employee> extent = new ArrayList<>();
    private int idEmployee;
    private static int id = 0;

    private static Double discount = 0.15; //stała zniżka pracownicza

    public Employee(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
        super.discount = discount;
        idEmployee = ++id;
        addEmployee(this);
    }


    public static double getEmployeeDiscount() {
        return discount;
    }


    private static void addEmployee(Employee employee){
        extent.add(employee);
    }
    private static void removeEmployee(Employee employee) {
        extent.remove(employee);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Employee");

        for (Employee e : extent) {
            System.out.println(e);
        }
    }

    private int getIdEmployee() {
        return idEmployee;
    }


    @Override
    public String toString() {
        return "EmployeeId= " + getIdEmployee() +
                ", name= " + getName() +
                ", surname= " + getSurname() +
                ", age= " + getAge(getBirthDate());
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Employee>) stream.readObject();
    }
}
