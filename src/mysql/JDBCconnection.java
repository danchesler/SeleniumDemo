package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCconnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//need to connect and login to mysql
		//jdbc:mysql://"+ localhost +":" + 3306 + "/Qadbt"
		
		String url = "jdbc:mysql://localhost:3306/qadbt";
		
		Connection conn = DriverManager.getConnection(url, "root", "Cougar12");
		
		//use to make queries
		Statement s  = conn.createStatement();
		
		//acts like array
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'daniel'");
		
		while (rs.next())
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/client/");
			driver.findElement(By.id("userEmail")).sendKeys(rs.getString("name"));
			driver.findElement(By.id("userPassword")).sendKeys(rs.getString("location"));
		}
		
		System.out.println("pushed by gitspace");
		System.out.println("pull by gitstuff");
		System.out.println("test line 3");
		
		//added by gitstuff
		System.out.println("more lines1");
		System.out.println("test line 3");
		System.out.println("test line 3");
	}

}
