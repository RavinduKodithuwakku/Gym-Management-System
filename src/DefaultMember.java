import java.util.Scanner;

public class DefaultMember {

    String FirstName;
    String LastName;
    String defaultDate;
    int contactNum;
    int memberID;

    Scanner input = new Scanner(System.in);

    public void setFirstName(){
        System.out.println("Enter your First Name :");
        this.FirstName = input.next();
        while(true) {
            try {
                Integer.parseInt(this.FirstName);
                System.out.println("Invalid input!! Enter your name : ");
                this.FirstName = input.next();
            }catch (Exception e){
                break;
            }
        }
    }

    public void setLastName(){
        System.out.println("Enter your Last Name :");
        this.LastName = input.next();
        while(true) {
            try {
                Integer.parseInt(this.LastName);
                System.out.println("Invalid input!! Enter your Last Name : ");
                this.LastName = input.next();
            }catch (Exception e){
                break;
            }
        }
    }

    public void setContactNum(){
            System.out.println("Enter your Contact Number :");
            while(true){
                try{
                    this.contactNum = input.nextInt();
                    break;
                }catch (Exception e){
                    System.out.println("Invalid input!! Enter your Contact Number : ");
                    input.next();
                }
            }
        }

    public void setMemberID(){
        System.out.println("Enter your Member ID :");
        while(true){
            try{
                this.memberID = input.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Invalid input!! Enter your Number ID : ");
                input.next();
            }
        }
    }


    public void setDefaultDate(String defaultDate) {
        this.defaultDate = defaultDate;
    }


    public String getDefaultDate() {
        return defaultDate;
    }
    public String getFirstName(){return FirstName;}
    public String getLastName(){return LastName;}
    public int getContactNum(){return contactNum;}
    public int getMemberID(){return memberID;}

}