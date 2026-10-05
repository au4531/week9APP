class OrderProcessing extends Thread {

    public OrderProcessing() {
        setName("OrderProcessing");
        setPriority(Thread.MAX_PRIORITY);   // 10
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Processing customer order");
        }
    }
}

class DeliveryTracking extends Thread {

    public DeliveryTracking() {
        setName("DeliveryTracking");
        setPriority(Thread.NORM_PRIORITY);  // 5
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Tracking delivery location");
        }
    }
}

class Notification extends Thread {

    public Notification() {
        setName("Notification");
        setPriority(Thread.MIN_PRIORITY);   // 1
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Sending notification");
        }
    }
}

public class FoodDelivery {
    public static void main(String[] args) {

        OrderProcessing order = new OrderProcessing();
        DeliveryTracking delivery = new DeliveryTracking();
        Notification notification = new Notification();

        order.start();
        delivery.start();
        notification.start();
    }
}