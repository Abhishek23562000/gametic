
import java.util.Scanner;

class email{
    String email_id;

    void send_mail(String message){
        System.out.println("Mail sending Successfull: "+message);
    }

    void receive_email(){
        System.out.println("Email from xyz");
    }
}
public class Mainclass1 {
    public static void main(String[] args) {
        System.out.println("Main Method Start");
        Scanner sc = new Scanner(System.in);
        email e1 = new email();
        System.out.println("enter the email_id");
        e1.email_id = sc.nextLine();

        e1.send_mail("hello how are you");
        e1.receive_email();


    }
}