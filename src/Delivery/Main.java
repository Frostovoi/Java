package Delivery;

public class Main {
    public static void main(String[] args) {
        Courier c1 = new Courier("Alex", "123", 10);
        Courier c2 = new Courier("Bob", "213", 15);
        Courier c3 = new Courier("John", "312", 20);
        Repository repository = new Repository(new MinimalDistanceStrategy());
        c1.setCurPosition(new GeoCoordinate(55,55));
        c2.setCurPosition(new GeoCoordinate(30,30));
        c3.setCurPosition(new GeoCoordinate(10,10));
        repository.addCourier(c1);
        repository.addCourier(c2);
        repository.addCourier(c3);


        Order order = repository.addOrder(3,
                new GeoCoordinate(0,0),
                new GeoCoordinate(30,50)
        );
        repository.assignCourier(order);
        System.out.println(order.getCourier().getName());
        Order order1 = repository.addOrder(3,
                new GeoCoordinate(0,0),
                new GeoCoordinate(30,50)
        );

        repository.assignCourier(order1);
        System.out.println(order1.getCourier().getName());
        repository.completeOrder(order);
        repository.completeOrder(order1);
        repository.getCouriers().forEach(t-> System.out.println(t.isAvailable()));

    }
}
