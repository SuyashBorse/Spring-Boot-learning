package in.SuyashBorse;

import in.SuyashBorse.Notification.EmailService;
import in.SuyashBorse.Notification.NotificationService;
import in.SuyashBorse.Notification.SmsService;

public class OrderService {

    //EmailService notification = new EmailService(); //Due to this it is tightly coupled.
    //NotificationService notification = new EmailService();  // loosely coupled  as compared to direct object creation still not the best case.

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public  OrderService(){

    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
