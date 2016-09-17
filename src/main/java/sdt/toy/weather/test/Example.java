/**
 * 
 */
package sdt.toy.weather.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import sdt.toy.weather.YahooWeatherService;
import sdt.toy.weather.data.Channel;
import sdt.toy.weather.data.unit.DegreeUnit;


public class Example {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/** read file **/

		//FileInputStream fstream = new FileInputStream("/testfile.txt");
	//	BufferedReader br = new BufferedReader(new InputStreamReader(Example.class.getClass().getResourceAsStream("/testfile.txt")));
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String strLine;
		YahooWeatherService service = new YahooWeatherService();
		//Read File Line By Line
		if (br.readLine() == null) {
			String locations;
			//FileInputStream dstream = new FileInputStream("default/textfile.txt");
			BufferedReader dr = new BufferedReader(new InputStreamReader(Example.class.getClass().getResourceAsStream("default/textfile.txt")));
			while ((locations = dr.readLine()) != null)  {
			
			Channel result = service.getForecast(locations, DegreeUnit.CELSIUS);
			String city =	result.getLocation().getCity();
			float geoLat =	result.getItem().getGeoLat();
			float geoLong =	result.getItem().getGeoLong();
			double elevation = service.getElevation(geoLat,geoLong);
			Date date = result.getItem().getCondition().getDate();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			String nowAsString = df.format(date);
			String cond = result.getItem().getCondition().getText();
			String condition = service.getCondition(cond);
			int temp = result.getItem().getCondition().getTemp();
			double pressure = (result.getAtmosphere().getPressure())/68.94757293168;
			float humidity = result.getAtmosphere().getHumidity();
			System.out.println(city+"|"+geoLat+","+geoLong+","+elevation+"|"+nowAsString+"|"+condition+"|"+temp+"|"+pressure+"|"+humidity);
			 
		}}
		else {
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		
		//Close the input stream
		
String woeid =	strLine.indexOf(',')>0 ? service.getWoeid("("+strLine+")") : service.getWoeid(strLine) ;
 Channel result = service.getForecast(woeid, DegreeUnit.CELSIUS);
	String city =	result.getLocation().getCity();
	float geoLat =	result.getItem().getGeoLat();
	float geoLong =	result.getItem().getGeoLong();
	double elevation = service.getElevation(geoLat,geoLong);
	Date date = result.getItem().getCondition().getDate();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
	String nowAsString = df.format(date);
	String cond = result.getItem().getCondition().getText();
	String condition = service.getCondition(cond);
	int temp = result.getItem().getCondition().getTemp();
	double pressure = (result.getAtmosphere().getPressure())/68.94757293168;
	float humidity = result.getAtmosphere().getHumidity();
	System.out.println(city+"|"+geoLat+","+geoLong+","+elevation+"|"+nowAsString+"|"+condition+"|"+temp+"|"+pressure+"|"+humidity);
	
		} }
		br.close();
		}

	

}
