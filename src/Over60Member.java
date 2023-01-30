public class Over60Member extends DefaultMember {

    int age;
    public void setAge(){
        System.out.println("Enter your age :");
        while(true){
            try{
                this.age = input.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Invalid input!! Enter your age : ");
                input.next();
            }
        }
    }
    public int getAge(){
        return age;
    }
}

