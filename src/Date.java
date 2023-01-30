public class Date extends DefaultMember{

    String PassingDate;
    int date;
    int month;
    int year;

    public void setPassingDate() {

        while (true) {
            System.out.println("Enter your starting day :");
            try {
                this.date = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!!");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter your starting month :");
            try {
                this.month = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!! ");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter your starting year :");
            try {
                this.year= input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!! ");
                input.next();
            }
        }
        PassingDate = date + "." + month + "." + year;
    }
    public String getPassingDate() {
        return PassingDate;
    }
}
