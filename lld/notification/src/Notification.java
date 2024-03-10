public class Notification {
    public String title;
    public String body;
    public String sender;

    public Notification(String title,String body,String sender){
        this.title=title;
        this.body=body;
        this.sender=sender;
    }

    public void setBody(String s) {
        this.body=s;
    }

    public void setSender(String sender) {
        this.sender=sender;
    }
}
