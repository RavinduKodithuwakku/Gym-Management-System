import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Scanner;
public class MyGymManager {

    public static  MongoClient mongoClient = new MongoClient("localhost", 27017);
    public static  MongoDatabase database = mongoClient.getDatabase("GymManager");
    public static void main(String[] args)  {
        int numberOfMembers = 0;


//--------------------------------------connection-------------------------------------//

       if(database.getCollection("Members") == null){
       database.createCollection("Members");
     }
        MongoCollection<Document> collection = database.getCollection("Members");


       //User Inputs

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("-----------------My Gym Manager--------------------" + "\n");
                System.out.println("Add a new Member                : Enter 1 ");
                System.out.println("Delete a Member                 : Enter 2 ");
                System.out.println("Print the list of members       : Enter 3 ");
                System.out.println("Sort the item                   : Enter 4 ");
                System.out.println("Exit                            : Enter 5 " + "\n");
                System.out.println("enter selection");

               // Add a new Member

                int selection = sc.nextInt();
                if (selection == 1) {
                    if(numberOfMembers >= 100){
                        System.out.println("User amount exceeded");
                    }

                    else {
                    System.out.println("------Adding a new Member--------------" + "\n");
                    System.out.println("If you are a  Student Member : Enter 1 ");
                    System.out.println("If you  are a Over 60 Member : Enter 2 " );
                    System.out.println("If you  are a Default Member : Enter 3 " + "\n");
                    System.out.println("enter selection");

                    int age = sc.nextInt();

                    //Student Member

                    if (age == 1) {
                        System.out.println("----------------Student Member----------------");
                        StudentMember newStudent = new StudentMember();
                        newStudent.setFirstName();
                        newStudent.setLastName();
                        newStudent.setMemberID();
                        newStudent.setSchool();
                        newStudent.setContactNum();
                        Date newDate = new Date();
                        newDate.setPassingDate();
                        newStudent.setDefaultDate(newDate.getPassingDate());

                        Document Information = new Document();
                        Information.put("Member ID",newStudent.getMemberID());
                        Information.put("First Name",newStudent.getFirstName());
                        Information.put("Last Name",newStudent.getLastName());
                        Information.put("School/University Name",newStudent.getSchool());
                        Information.put("Starting Date",newDate.getPassingDate());
                        Information.put("Contact NUmber",newStudent.getContactNum());
                        collection.insertOne(Information);


                       //Over 60 Member

                    } else if (age == 2) {
                        System.out.println("----------------Over 60 Member--------------- ");
                        Over60Member newOver60member = new Over60Member();
                        newOver60member.setFirstName();
                        newOver60member.setLastName();
                        newOver60member.setMemberID();
                        newOver60member.setAge();
                        newOver60member.setContactNum();
                        Date newDate = new Date();
                        newDate.setPassingDate();
                        newOver60member.setDefaultDate(newDate.getPassingDate());


                        Document Information = new Document();
                        Information.put("Member ID",newOver60member.getMemberID());
                        Information.put("First Name",newOver60member.getFirstName());
                        Information.put("Last Name",newOver60member.getLastName());
                        Information.put("Age",newOver60member.getAge());
                        Information.put("Starting Date",newDate.getPassingDate());
                        Information.put("Contact NUmber",newOver60member.getContactNum());
                        collection.insertOne(Information);


                        //Default Member

                    } else if (age == 3) {
                        DefaultMember newDefaultMember = new DefaultMember();

                        System.out.println("-----------------Default Member-------------- ");
                        newDefaultMember.setFirstName();
                        newDefaultMember.setLastName();
                        newDefaultMember.setMemberID();
                        newDefaultMember.setContactNum();
                        Date newDate = new Date();
                        newDate.setPassingDate();
                        newDefaultMember.setDefaultDate(newDate.getPassingDate());


                        Document Information = new Document();
                        Information.put("Member ID",newDefaultMember.getMemberID());
                        Information.put("First Name",newDefaultMember.getFirstName());
                        Information.put("Last Name",newDefaultMember.getLastName());
                        Information.put("Starting Date",newDate.getPassingDate());
                        Information.put("Contact NUmber",newDefaultMember.getContactNum());
                        collection.insertOne(Information);


                    } else {
                        System.out.println("Invalid Input");
                    }
                }

                    //Delete a Member

                } else if (selection == 2) {
                    System.out.println("-------------Deleting a Member--------------");
                    System.out.println("Enter the member ID : ");
                    int givenNumber = sc.nextInt();
                    BasicDBObject info = new BasicDBObject();
                    info.put("Member ID", givenNumber);
                    collection.deleteOne(info);
                    System.out.println("your ID deleted ");


                    //Print the list of members

                } else if (selection == 3) {
                    System.out.println("------Print the list of members-------------");

                    for(Document Data : collection.find() ){
                        System.out.println("Member ID              : " + Data.get("Member ID"));
                        System.out.println("First Name             : " + Data.get("First Name"));
                        System.out.println("Last Name              : " + Data.get("Last Name"));
                        System.out.println("Starting Date          : " + Data.get("Starting Date"));
                        System.out.println("School/University Name : " + Data.get("School/University Name"));
                        System.out.println("Age                    : " + Data.get("Age"));
                        System.out.println("Contact Number         : " + Data.get("Contact NUmber") +"\n");
                        System.out.println("*********************************" + "\n\n");
                    }

                    //Sort the item

                } else if (selection == 4) {
                    System.out.println("---------------Sort the item----------------");
                    FindIterable<Document> Sort = collection.find().sort(new BasicDBObject("First Name",1));
                    for (Document Information : Sort){
                        System.out.println(  "Member ID : " +Information.get("Member ID")+ " || " + "First Name : " +Information.get("First Name")+ " || " +
                                "Starting Date : " + Information.get("Starting Date") + " || " + "Contact Number : "  + Information.get("Contact NUmber"));
                    }

                    //Exit

                }else if (selection == 5){
                    break;
                } else {
                    System.out.println("Invalid number!! Please enter a valid Number : ");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!! Please enter a valid Integer :  ");
                sc.next();
            }
        }

    }
}