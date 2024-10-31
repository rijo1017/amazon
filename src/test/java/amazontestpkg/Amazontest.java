package amazontestpkg;

import java.io.IOException;

import org.testng.annotations.Test;

import amazonpagepkg.Amazonpage;
import amazonutilitypkg.Exluti;

public class Amazontest extends Basecl {

	@Test
	public void elementdisplay() throws IOException, InterruptedException
	{
		Amazonpage aa =new Amazonpage(driver);
		aa.isd();
		aa.ise();
		aa.iss();
		aa.hamburger();
		aa.displaylinkelements();
		aa.titleverification();
		aa.homepagescreenshot();
		aa.searchmobilephones("mobilephones");
		aa.addingtocart("mobilephones");
		aa.deliveryaddresss("686564");
		aa.languageselector();
		aa.buttss();
		aa.electronics();
		aa.todaysdeal();
		aa.mxplayer();
		aa.bestseller();
		aa.sell();
		aa.homeandkitchen();
		aa.newreleases();
		aa.customerservices();
		aa.sortbydropdown();
		aa.nooflinks();
		aa.buttontextverification();
		aa.checkbox();
		aa.loginfunctionality("8078113048","unknown");
		aa.productreview("macbook m1 air");
		aa.proceedtopayment();
		aa.footerlinktest();
		aa.footerlinktest2();
		aa.footerlinktest3();
		aa.footerlogotest();
		aa.increasethequanityoftheproduct();
		
		String xl = "amazon_project/resource/amazon.xlsx";
		
		  String Sheet = "Sheet1";

          int rowCount = Exluti.getRowCount(xl, Sheet);

          for (int i=1;i<=rowCount;i++)

          {

                      String UserNa=Exluti.getCellValue(xl, Sheet, i, 0);
                         System.out.println("username---"+UserNa);
                      String Pwdo=Exluti.getCellValue(xl, Sheet, i, 1);
                       System.out.println("password---"+Pwdo);
                      
                      aa.datadriventesting(UserNa, Pwdo);
                   
		
          }
		
	}
	
}
