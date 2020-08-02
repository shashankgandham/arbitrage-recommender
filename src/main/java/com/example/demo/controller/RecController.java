package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecController {

	//@RequestMapping(value = "/getalllg", method = RequestMethod.GET)
	@GetMapping("/getRec")
	public String[] getResource(){
		StringBuilder stringsFinal = new StringBuilder();
		ArrayList<String> ticker = new ArrayList<String>();
		int GloabalCount= 0;
		int index=0;
		String companySymbols[] = new String[30];
		companySymbols[0] = "TCS";
		companySymbols[1] = "IBM";
		companySymbols[2] = "GOOG";
		companySymbols[3] = "SI";
		companySymbols[4] = "NOK";
		try
		{
		for(int p = 0; p<companySymbols.length && companySymbols[p]!=null; p++) {
			URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+companySymbols[p]+"&apikey=SEG8V2YH0699G4QP&outputsize=full");
			URLConnection urc=url.openConnection();
			InputStreamReader ireader=new InputStreamReader(urc.getInputStream());
			BufferedReader buff=new BufferedReader(ireader);
			String line = buff.readLine();
			int i = 0;
			double BSE = 0.0;
			double NSE = 0.0;
			String strings[] = new String[50];
			

			while(line!=null && i<16)
			{
				if(i>8) {
					strings[i] = line;
					if(i == 10 && line.contains("open\""))
					{
						//System.out.println(":::)))"+line);
						int hr=line.indexOf(":");
						int cl_b=line.indexOf("\"", hr);
						int dot=line.indexOf("\"", cl_b+1);
						String name = line.substring(cl_b+1, dot);
						BSE = Double.parseDouble(new String(name));
						System.out.println(":::|||"+BSE);
					}
				}
				else {
					strings[i] = "";
				}

				line=buff.readLine();
				i++;
			}
			strings[i] = "}";

			while(line!=null && i>=16 && i<23)
			{
				strings[i] = line;//str.append(line);
				if(i == 17 && line.contains("open\""))
				{
					//System.out.println(":::)))"+line);
					int hr=line.indexOf(":");
					int cl_b=line.indexOf("\"", hr);
					int dot=line.indexOf("\"", cl_b+1);
					String name=new String(line.substring(cl_b+1, dot));
				//	System.out.println(":::|||"+name);
					NSE = Double.parseDouble(name.toString());
					System.out.println(":::|||"+NSE);
				}
				line=buff.readLine();
				i++;
			}
			strings[i] = "}";

			if(Math.abs(5-4)>0) {
				int  k = 0;
				ticker.add(companySymbols[p]);
				//System.out.println("Globa;"+GloabalCount);
				for(int j = GloabalCount; k<i; j++) {
					stringsFinal.append(strings[k]);
					//System.out.println(stringsFinal[j]+" ||| "+strings[k]);
					k++;
				}
			}
			GloabalCount += i;
		}
		System.out.print(stringsFinal.toString());
		String str[] = new String[ticker.size()]; 
		  
        // Convert ArrayList to object array 
        Object[] objArr = ticker.toArray(); 
  
        // Iterating and converting to String 
        int i = 0; 
        for (Object obj : objArr) { 
            str[i] = (String)obj; 
            System.out.println(str[i]);
            i++;
        }    
  
        return str;
		}
		catch(IOException e)
		{
			System.out.println(e);
			return null;
		}
	}

}

