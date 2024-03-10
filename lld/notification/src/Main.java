public class Main {
    //Observer pattern is used to notify any update in the subject to different observer.

    public static void main(String[] args) {

        System.out.println("Hello world!");
        Employee employee1 = new Employee("anuj","SDE3","ONEWEATHER","SWISH");
        Employee employee2 = new Employee("mohit","SDE3","ONEWEATHER","SWISH");

        Notification notification = new Notification("test","this is testing","CEO");
        NotificationService<Notification> notificationService = new NotificationService<Notification>();
        notificationService.attach(employee1);
        notificationService.attach(employee2);

        notificationService.notify(notification);

        notification = new Notification("test","this is testing","SWISH");
        notificationService.notify(notification);

        notificationService.dettach(employee1);
        notification.setBody("This is testing part 2");


        //only mohit should recieve the notificaiton
        notificationService.notify(notification);


        notification.setSender("MANAGER");

        //no one should get the notification
        notificationService.notify(notification);
    }
}