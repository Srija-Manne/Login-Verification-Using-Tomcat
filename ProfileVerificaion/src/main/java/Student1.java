

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class Student1 extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
    	 PrintWriter p = response.getWriter();
    	 String s1 = request.getParameter("name");
         String s2 = request.getParameter("password");
         
         Cookie cookies[] = request.getCookies();
         if(cookies != null)
         {
         int count = 0;
         for(Cookie c : cookies)
         {
        	 if(c.getName().equals(s1))
        	 {
        		 p.print("Already Exist");
        		 count++; 
        	 }
        	
         }
         if(count == 0)
         {
        	  p.print("Login Successfull");
              Cookie c1 = new Cookie(s1,s2);
              response.addCookie(c1);
         }    
        }
         else 
         {
        	 p.print("Login Successfull");
             Cookie c1 = new Cookie(s1,s2);
             response.addCookie(c1);
         }
    }
}