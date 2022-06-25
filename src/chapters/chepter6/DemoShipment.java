package chapters.chepter6;

public class DemoShipment {
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(6, 8, 8, 9, 7);
        Shipment shipment2 = new Shipment(4, 7, 16, 24, 8.8);
       double vol;

        vol = shipment1.volume();

        System.out.println("Oбъeм shipmentl равен " + vol);
        System.out.println("Bec shipmentl равен " + shipment1.weight);
        System.out.println("Cтoимocть доставки: $" + shipment1.cost);
        System.out.println();


        vol = shipment2.volume();
        System.out.println("Oбъeм shipmentl равен " + vol);
        System.out.println("Bec shipmentl равен " + shipment2.weight);
        System.out.println("Cтoимocть доставки: $" + shipment2.cost);

    }
}
