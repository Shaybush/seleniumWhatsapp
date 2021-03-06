package co.edureka.selenium.webdriver.basic;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReaderWriter {
	 public static void main(String[] args) {
		  String filePath = "E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\AsafTry.csv";
		  System.out.println("starting write user.csv file: " + filePath);
		  writeNewCsv(filePath);
		 }
	 public static void writeCsv(String filePath)// מוסיף לרשימה קיימת
	 {
			String gender="";
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner (System.in);
			List<ContactDB> contacts=new ArrayList<ContactDB>();
			ContactDB contact=new ContactDB();
			System.out.println("for exit press 999 now just press any keyboard");
			String Name = keyboard.nextLine();
			int i=listLength(filePath);
			while(!Name.equals("999"))
			{
				contact=new ContactDB();
				System.out.println("Input Name\n");
				Name = keyboard.nextLine();
				if(!Name.equals("999"))
				{
				System.out.println("F/M");
				gender=keyboard.nextLine();
				}
				if(gender.equals("F"))
				{
					contact.setGender(false); //female
				}
				if(gender.equals("M"))
				{
					contact.setGender(true); // male
				}
				contact.setId(i);
				contact.setName(Name);
				contact.setCheckSend(false);
				i++;
				if(!Name.equals("999"))
				contacts.add(contact);	
				System.out.println("id: "+contact.getId()+"\n Gender: "+contact.isGender()+"\n Name: "+contact.getName()+"\n check: "+contact.isCheckSend());
			}
			
			FileWriter fileWriter=null;
			try 
			{
				fileWriter = new FileWriter(filePath,true);
				for(ContactDB c:contacts)
				{
					fileWriter.append(String.valueOf(c.getId()));
					fileWriter.append(",");
					fileWriter.append(c.getName());
					fileWriter.append(",");
					fileWriter.append(String.valueOf(c.isCheckSend()));
					fileWriter.append(",");
					if(c.isGender())
					{
					fileWriter.append("Male"); 
					}
					else
					{
						fileWriter.append("Female");
					}
					fileWriter.append("\n");
					System.out.println("id: "+contact.getId()+"\n Gender: "+contact.isGender()+"\n Name: "+contact.getName()+"\n check: "+contact.isCheckSend());
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try {
					fileWriter.flush();
					fileWriter.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
	 }
	public static void writeNewCsv(String filePath)// יוצר רשימה חדשה
	{
		String gender="";
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner (System.in);
		List<ContactDB> contacts=new ArrayList<ContactDB>();
		ContactDB contact=new ContactDB();
		System.out.println("for exit press 999 now just press any keyboard");
		String Name = keyboard.nextLine();
		int i=1;
		while(!Name.equals("999"))
		{
			contact=new ContactDB();
			System.out.println("Input Name\n");
			Name = keyboard.nextLine();
			if(!Name.equals("999"))
			{
			System.out.println("F/M");
			gender=keyboard.nextLine();
			}
			if(gender.equals("F"))
			{
				contact.setGender(false);// female 
			}
			if(gender.equals("M"))
			{
				contact.setGender(true);//male
			}
			contact.setId(i);
			contact.setName(Name);
			contact.setCheckSend(false);
			i++;
			if(!Name.equals("999"))
			contacts.add(contact);	
			System.out.println("id: "+contact.getId()+"\n Gender: "+contact.isGender()+"\n Name: "+contact.getName()+"\n check: "+contact.isCheckSend());
		}
		//System.out.println("id: "+contact.getId()+"\n Gender: "+contact.isGender()+"\n Name: "+contact.getName()+"\n check: "+contact.isCheckSend());
		FileWriter fileWriter=null;
		try 
		{
			fileWriter = new FileWriter(filePath);
			fileWriter.append("Id,Name,CheckSend,Gender\n");
			for(ContactDB c:contacts)
			{
				fileWriter.append(String.valueOf(c.getId()));
				fileWriter.append(",");
				fileWriter.append(c.getName());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(c.isCheckSend()));
				fileWriter.append(",");
				if(c.isGender())
				{
					fileWriter.append("Male");
				}
				else
				{
					fileWriter.append("Female");
				}
				fileWriter.append("\n");
				System.out.println("id: "+contact.getId()+"\n Gender: "+contact.isGender()+"\n Name: "+contact.getName()+"\n check: "+contact.isCheckSend());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static int listLength(String filePath)
	{
		int size=0;
		  BufferedReader reader = null;
		  try {
		   reader = new BufferedReader(new FileReader(filePath));
		   reader.readLine();
		   while((reader.readLine()) != null) {size++;}
		   size++;
		  } 
		  catch (Exception ex) {ex.printStackTrace();}
		  finally { 
		   try { reader.close();} 
		   catch (Exception e) {e.printStackTrace();}
		  }
		  System.out.println(size-1);
		return size-1;
}

}
		  
