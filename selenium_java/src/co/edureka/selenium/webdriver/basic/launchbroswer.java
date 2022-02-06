package co.edureka.selenium.webdriver.basic;


import java.io.BufferedReader;
import java.util.Random;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class launchbroswer{
	private static String string;
	public static WebDriver driver =null;
	//public static String filePath="C:\\Users\\Windows10\\Desktop\\sj_demo2\\selenium_java\\PartyVideo.mp4";
	
	public static void main(String[] args) throws Exception	
	{
		String filePath = "E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\IDF Yaniv - Sheet1.csv";
		System.out.println("starting read user.csv file");
		readCsv(filePath);
	}	
	//מתחבר לדפדפן הנוכחי+שולח הודעות
	public static void send_Message(String name, String message,boolean con) throws Exception
	{		
		if(con!=true) // d'ont connect if its already connected 
		{
			System.setProperty("webdriver.chrome.driver","E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\driver\\chromedriver7.exe");
			driver =new ChromeDriver();
			String baseUrl=("https://web.whatsapp.com//");//open the web
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		}
		driver.findElement(By.xpath("//div[@class='_2cNrC'][2]")).click();// לוחץ על שיחה חדשה
		////driver.findElement(By.xpath("//label[@class='_3xpD_']")).click();// לוחץ על טקטס החיפוש
		driver.findElement(By.xpath("//div[@class='_13NKt copyable-text selectable-text']")).sendKeys(name);// כותב את השם של אותו בן אדם
		Thread.sleep(1000); // wait a sec
		driver.findElement(By.xpath("//div[@class='_3OvU8']")).click(); //open current chat 
		send_Message_to_current_chat(message);
	}
	//שולח הודעה בצאט עצמו
	public static void send_Message_to_current_chat(String mess) throws Exception
	{
		
		WebElement sendMessage=driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/div/div[2]/div[1]/div/div[2]")); //cannot find the correct class for sending message 
		//WebElement sendMessage=driver.findElement(By.xpath("//div[@class='_13NKt copyable-text selectable-text']"));
		//WebElement sendMessage=driver.findElement(By.className("_2A8P4")); //press on the chat 
		sendMessage.sendKeys(mess); //write the string in the chat 
		//Thread.sleep(800);
//		driver.findElement(By.xpath("//div[@class='_2jitM']")).click();//click on add photo 
//		WebElement uploadElement = driver.findElement(By.xpath("//li[1]//button[1]//input[1]")); //send the pic 
//		uploadElement.sendKeys("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\WhatsApp Video 2021-10-25 at 20.03.44.mp4");// find the photo from pc
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[2]/span/div[1]/span/div[1]/div/div[2]/span/div/div")).click(); // send the text message 
		//_33pCO
		//driver.findElement(By.xpath("//div[@class='_33pCO']")).click();
		Thread.sleep(2000); // wait 2 second 
	}

	//מחלקה שמחכה להודעה 
	public static void listener() throws Exception // wait for receive message than response 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='OUeyt']")));//אם מופיע שקיבלת הודעה מהשיחה
	}
	public static String FnameInput(String n) throws Exception // get Full name than output just the first name 
	{
		String[] parts=n.split("\\ ");
		String beforeFirstDot = parts[0];
		return beforeFirstDot;	
	}
	//פעולה שקוראת מהקובץ
	@SuppressWarnings("resource")
	public static void readCsv(String filePath) 
	{
		  BufferedReader reader = null;
		  
		  try {
		   List<ContactDB> contacts = new ArrayList<ContactDB>();
		   String line = "";
		   reader = new BufferedReader(new FileReader(filePath));
		   reader.readLine();
		   String gender;
		   while((line = reader.readLine()) != null)
		   {
		    String[] fields = line.split(","); // defines the comma as a separation 
		    if(fields.length > 0)
		    {
		     ContactDB contact = new ContactDB();
		     contact.setId(Integer.parseInt(fields[0]));
		     contact.setName(fields[1]);
		     gender=fields[3];
		     if(gender.equals("Female"))
		     {
		    	 contact.setGender(false);//female
		     }
		     else
		     {
		    	 contact.setGender(true);//male
		     }
		     
		     //contact.setCheckSend(Integer.parseInt(fields[3]));
		     contacts.add(contact);
		    }
		   }
		   String Fname,msg="",Oname;
		   String msgMen1=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Men3.csv")).readLine();
		   String msgMen2=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Men2.csv")).readLine(); 
//		   String msgMen3=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Men3.csv")).readLine();
		   String msgWomen1=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Women1.csv")).readLine();
		   String msgWomen2=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Women2.csv")).readLine();
		//   String msgWomen3=new BufferedReader(new FileReader("E:\\Engineer\\Selenium projects\\sj_demo2\\selenium_java\\ExtraFiles\\Women3.csv")).readLine();
		   boolean connection=false;
		   for(ContactDB c: contacts) 
		   {
			   if(c.getId()%15==0)
			   {
				   Thread.sleep(8000 + (int)(Math.random() * ((10000 - 8000) + 1)));
			   }
			   Oname=c.getName();
			   Fname=FnameInput(c.getName());
				// מכניס לפה את ההודעה
			   //System.out.print(c.isGender());
			   if(c.isGender()&&c.getId()%2==0)//when its get to 12 24... its write the first one
			   {
				   msg=(msgMen2 + "\n");
				
			   }
			   else if(c.isGender())
			   {
				   msg=(msgMen1 + "\n");
			   }
			   else if(c.getId()%2!=0)
			   {
				   msg=(msgWomen2 + "\n");
			   }
			   else 
			   {
				   msg=(msgWomen1 + "\n");
			   }
//			   else if(c.isGender()&&c.getId()%4!=0)
//			   {
//				   msg=("מה איתך"+" "+"נסיך"+ "?\n"+msgMen2);
//			   }
//			   else if(c.isGender())
//			   {
//				   msg=("מה איתך"+" "+"יא מלך"+ "?\n"+msgMen2);
//			   }
//			   else if(c.getId()%3!=0)
//			   {
//				   msg=("הייי"+" "+"חיים שלי"+"?\n"+msgWomen2);
//			   }
//			   else if(c.getId()%4!=0)
//			   {
//				   msg=("בוקר טוב"+" "+"מותקקק" +"?\n"+msgWomen2);
//			   }
//			   else 
//			   {
//				   msg=("בוקר טוב"+" "+"חיים שליי" +"?\n"+msgWomen2); 
//			   }
				launchbroswer.send_Message(Oname,msg,connection);
				connection=true;
				//System.out.printf("[contactId=%d, Name=%s, Gender=%b, check=%d]\n", c.getId(), c.getName(), c.isGender(),c.isCheckSend());
				//System.out.printf("[contactId=%d, Gender=%b,Name=%s]\n", c.getId(), c.isGender(),c.getName());
			   }
		   
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  } finally {
		   try {
		    reader.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
	 }
	public static void tearDown() throws Exception {
		driver.quit();
		}
	}
//לחיצה על כפתור החיפוש
//driver.findElement(By.xpath("//label[@class='_2MSJr']")).click();
		