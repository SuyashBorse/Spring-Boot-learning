package in.SuyashBorse.Notification;

public class EmailService implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("Email notification sent");
    }
}
