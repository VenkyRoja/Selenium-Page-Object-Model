package crm.other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import crm.util.TestUtil;


public class currentdatetime {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		DateTimeFormatter MM = DateTimeFormatter.ofPattern("MM");
		DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
		DateTimeFormatter dd = DateTimeFormatter.ofPattern("dd");
		
		DateTimeFormatter HH = DateTimeFormatter.ofPattern("HH");
		DateTimeFormatter mm = DateTimeFormatter.ofPattern("mm");
		DateTimeFormatter ss = DateTimeFormatter.ofPattern("ss");
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss");
		
		DateTimeFormatter MMM= DateTimeFormatter.ofPattern("MMMM");
		
		LocalDateTime now = LocalDateTime.now(); 
		
		//----
		System.out.println();
		System.out.println(dtf.format(now));  
		
		System.out.println();
		System.out.println(yyyy.format(now));	
		System.out.println(MM.format(now));	  
		System.out.println(dd.format(now));		


		System.out.println();
		System.out.println(HH.format(now));	
		System.out.println(mm.format(now));	  
		System.out.println(ss.format(now));		
		
		
		System.out.println();
		System.out.println(dtf2.format(now));  
		

		System.out.println("-------------------------------------");
		
	       
		LocalDateTime date  =  LocalDateTime.now().plusDays(1);
		LocalDateTime date2 =  LocalDateTime.now().plusDays(7);
		LocalDateTime date3 =  LocalDateTime.of(2021, 9, 14, 0, 0).plusDays(1);
		LocalDateTime date4 =  LocalDateTime.of(2021, 10, 14,0,0).plusDays(9);
				
		System.out.println("Adding one day to current date:        " + date);
		System.out.println("Adding 7 days to the current date:     " + date2);
		System.out.println("Adding one day to the given date:      " + date3 );
		System.out.println("Adding 9 days to the given date:       " + date4);		
		
		System.out.println("-------------------------------------");
		
		System.out.println(dtf2.format(date3));
		System.out.println(dtf2.format(date4));
		
		System.out.println(MMM.format(date3));
		
		
		System.out.println("-------------------------------------");
		
	
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("MMM_dd_yyyy_HH_mm_ss");
		
		System.out.println(dtf3.format(date));
		System.out.println(dtf3.format(date2));
		System.out.println(dtf3.format(date3));
		System.out.println(dtf3.format(date4));	
		
		System.out.println("-------------------------------------");
		
		System.out.println(TestUtil.getCurrentTimestampString());
		System.out.println(System.currentTimeMillis());
		
	}
	
	
	
}
