public class CarClient {
    //wypożyczenia samochodów przez klientów
    private Client client;
    private Car car;

    public CarClient(Client client, Car car) {
        this.client = client;
        this.car = car;
        car.addCarClient(this);
        client.addCarClient(this);
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }
}
