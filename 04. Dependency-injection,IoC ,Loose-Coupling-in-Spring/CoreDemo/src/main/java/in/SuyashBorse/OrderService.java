package in.SuyashBorse;

public class OrderService {

    EmailService notification = new EmailService(); //Due to this it is tightly coupled.

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();

    }
}
