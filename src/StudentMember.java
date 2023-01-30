public class StudentMember extends DefaultMember {

    String school;

    public void setSchool(){
        System.out.println("Enter your School/University Name :");
        this.school = input.next();
        while(true) {
            try {
                Integer.parseInt(this.school);
                System.out.println("Invalid input!! Enter your School/University Name : ");
                this.school = input.next();
            }catch (Exception e){
                break;
            }
        }

    }

    public String getSchool(){
        return school;
    }
}
