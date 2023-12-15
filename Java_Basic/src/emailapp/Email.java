package emailapp;
import java.util.Scanner;
public class Email {

@SuppressWarnings("unused")
private String fName, lName,pwd,dept,email;
@SuppressWarnings("unused")
private int mailBoxCapacity=500;
@SuppressWarnings("unused")
private String alternateMail,orgSuffix="digibox.co.in";
private int defaultPassLen=6;

Scanner in = new Scanner(System.in);

//Constructor to receive first & last Name
public Email(String fName, String lName){
	this.fName = fName;
	this.lName = lName;
	System.out.println("Employee Name:"+fName+" "+lName+"\n");

	//Call a method asking for the department and return the department
	this.dept = setDepartment();

	//Call a method generating random password
	this.pwd = createPwd(defaultPassLen);
//	System.out.println("\nYour Password is:"+this.pwd);
	
	//Combine elements to generate email
	email = fName.toLowerCase()+"."+lName.toLowerCase()+"@"+dept+"."+orgSuffix;
//	System.out.println("Your Email is:"+email);
}
//Ask for the department
private String setDepartment(){
	System.out.println("Department: \n1.For Sales \n2.For Development \n3.For Accounting" + "\nEnter department code:");
	int choice = in.nextInt();
	if(choice == 1) {return "sales";}
	else if(choice == 2) {return "dev";}
	else if(choice == 3) {return "acc";}
	else {return "";}
}

//Generate a random password
private String createPwd(int len){
	String passSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#$!&*_-";
	char[] pass = new char[len];
	for(int i =0; i<len ; i++) {
		int ps = (int)(Math.random()* passSet.length());
		pass[i]=passSet.charAt(ps);
	}
	return new String(pass);
}

//Set the email box capacity
public void setMailCapacity(int capacity) {
	this.mailBoxCapacity=capacity;
}

//Set the alternate email
public void setAlternateMail(String altMail) {
	this.alternateMail = altMail;
}
//change password
public void changePass(String passWord) {
	this.pwd = passWord;
}
public String showInfo() {
	return "Name:"+fName+" "+lName+"\nCompany Email:"+email+"\nPassword:"+pwd+"\nMailbox Capacity:"+mailBoxCapacity;
			
			
}
}//Class ends
