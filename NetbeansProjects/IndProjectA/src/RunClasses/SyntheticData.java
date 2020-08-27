package RunClasses;

import BaseClasses.*;
import ExtraClasses.Item;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class SyntheticData {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static List<Item> courses;
	private static List<Item> trainers;
	private static List<Item> students;
	private static List<Item> assignments;
	
	public static List<Item> synthCourses() {
		courses = new ArrayList<>();
		courses.add(new Course("BC11 Java Part-Time"	, "Java"	, "Part-Time", LocalDate.parse("15/06/2020", formatter), LocalDate.parse("15/01/2021", formatter)));
		courses.add(new Course("BC11 Java Full-Time"	, "Java"	, "Full-Time", LocalDate.parse("15/03/2021", formatter), LocalDate.parse("15/06/2021", formatter)));
		courses.add(new Course("BC11 C# Part-Time"		, "C#"		, "Part-Time", LocalDate.parse("15/06/2020", formatter), LocalDate.parse("15/01/2021", formatter)));
		courses.add(new Course("BC11 C# Full-Time"		, "C#"		, "Full-Time", LocalDate.parse("15/03/2021", formatter), LocalDate.parse("15/06/2021", formatter)));
		courses.add(new Course("BC11 Python Part-Time"	, "Python"	, "Part-Time", LocalDate.parse("15/06/2020", formatter), LocalDate.parse("15/01/2021", formatter)));
		courses.add(new Course("BC11 Python Full-Time"	, "Python"	, "Full-Time", LocalDate.parse("15/03/2021", formatter), LocalDate.parse("15/06/2021", formatter)));
		return courses;
	}


	public static List<Item> synthAssignments() {
		assignments = new ArrayList<>();
	
		assignments.add(new Assignment("Stony Global Mercury PART-TIME JAVA"	, 
				"Performed suspicion in certainty so frankness by attention pretended. Newspaper or in tolerably education enjoyment. "	,
				LocalDate.parse("15/07/2020", formatter)));
	
		assignments.add(new Assignment("Intensive Gamma PART-TIME JAVA"		,
				"Extremity excellent certainty discourse sincerity no he so resembled."	,
				LocalDate.parse("05/11/2021", formatter)));
		
		assignments.add(new Assignment("Strawberry Dinosaur FULL-TIME JAVA"	,
				"Wrote water woman of heart it total other. By in entirely securing suitable graceful at families improved."	,
				LocalDate.parse("30/04/2021", formatter)));
		
		assignments.add(new Assignment("Rocky Trendy FULL-TIME JAVA"		,
				"Zealously few furniture repulsive was agreeable consisted difficult."	,
				LocalDate.parse("08/06/2021", formatter)));
		
		assignments.add(new Assignment("Indigo Firecracker PART-TIME C#"	,
				"Of be talent me answer do relied. Mistress in on so laughing throwing endeavor occasion welcomed. "		,
				LocalDate.parse("20/07/2020", formatter)));
		
		assignments.add(new Assignment("Ivory Pointless Viper PART-TIME C#"		,
				"Effects present letters inquiry no an removed or friends. Desire behind latter me though in. Supposing shameless am he engrossed up additions. "		,
				LocalDate.parse("05/01/2021", formatter)));
		
		assignments.add(new Assignment("Brave Metaphor FULL-TIME C#"	,
				" Gravity sir brandon calling can. No years do widow house delay stand. Prospect six kindness use steepest new ask."		,
				LocalDate.parse("30/04/2021", formatter)));
		
		assignments.add(new Assignment("Sad Electron FULL-TIME C#"		,
				"My possible peculiar together to. Desire so better am cannot he up before points. Remember mistaken opinions it pleasure of debating. "		,
				LocalDate.parse("08/06/2021", formatter)));
		
		assignments.add(new Assignment("Screaming Locomotive PART-TIME PYTHON"	,
				"Arrival entered an if drawing request. How daughters not promotion few knowledge contented. Yet winter law behind number stairs garret excuse."	,
				LocalDate.parse("08/12/2020", formatter)));
		
		assignments.add(new Assignment("Dreaded Green Space PART-TIME PYTHON"		,
				"Betrayed cheerful declared end and. Questions we additions is extremely incommode. Next half add call them eat face. "	,
				LocalDate.parse("14/12/2020", formatter)));
		
		assignments.add(new Assignment("Needless Angry Waterbird FULL-TIME PYTHON"	,
				"On recommend tolerably my belonging or am. Mutual has cannot beauty indeed now sussex merely you. It possible. "	,
				LocalDate.parse("30/04/2021", formatter)));
		
		assignments.add(new Assignment("Swift Toothbrush FULL-TIME PYTHON"		,
				"Shot what able cold new the see hold. Friendly as an betrayed formerly he."	,
				LocalDate.parse("08/06/2021", formatter)));
		
		return assignments;
	}

	public static List<Item> synthTrainers() {
		trainers = new ArrayList<>();
		trainers.add(new Trainer("Kirsten"	, "Kaufman"		, "Core Java"));
		trainers.add(new Trainer("Alishba"	, "Villareal"	, "SQL"));
		trainers.add(new Trainer("Clement"	, "Brandt"		, "Spring"));
		trainers.add(new Trainer("Zahrah"	, "Silva"		, "Java EE"));
		trainers.add(new Trainer("Keavey"	, "Plant"		, "C#"));
		trainers.add(new Trainer("Finlay"	, "Douglas"		, ".NET"));
		trainers.add(new Trainer("Raiden"	, "Clay"		, "Python"));
		trainers.add(new Trainer("Mitchell"	, "Kaiser"		, "Machine Learning"));
		trainers.add(new Trainer("Delia"	, "Nava"		, "HTML-CSS"));
		trainers.add(new Trainer("Cooper"	, "Cummings"	, "JavaScript"));
		return trainers;
	}

	public static List<Item> synthStudents() {
		students = new ArrayList<>();
		students.add(new Student("Lewie"  	, "Samson"		, LocalDate.parse("06/10/1979", formatter), new BigDecimal("1000")));
		students.add(new Student("Samad"  	, "Redman"		, LocalDate.parse("23/09/1980", formatter), new BigDecimal("1310")));
		students.add(new Student("Edgar"  	, "Cline"		, LocalDate.parse("11/12/1980", formatter), new BigDecimal("1400")));
		students.add(new Student("Aarush" 	, "Finley"		, LocalDate.parse("11/02/1983", formatter), new BigDecimal("1200")));
		students.add(new Student("Konrad"	, "Coles"		, LocalDate.parse("31/10/1983", formatter), new BigDecimal("2100")));
		students.add(new Student("Kier"		, "Arroyo"		, LocalDate.parse("24/11/1984", formatter), new BigDecimal("2300")));
		students.add(new Student("Adelle"	, "Huffman"		, LocalDate.parse("17/05/1985", formatter), new BigDecimal("1000")));
		students.add(new Student("Nigel"	, "Hope"		, LocalDate.parse("06/08/1986", formatter), new BigDecimal("420")));
		students.add(new Student("Steven"	, "Good"		, LocalDate.parse("22/02/1987", formatter), new BigDecimal("2030")));
		students.add(new Student("Keaton"	, "Herman"		, LocalDate.parse("08/09/1989", formatter), new BigDecimal("2101")));
		students.add(new Student("Mabel"	, "Dawe"		, LocalDate.parse("25/01/1990", formatter), new BigDecimal("1900")));
		students.add(new Student("Ansh"		, "Trujillo"	, LocalDate.parse("14/04/1990", formatter), new BigDecimal("1800")));
		students.add(new Student("Javier"	, "Odom"		, LocalDate.parse("19/03/1991", formatter), new BigDecimal("2400")));
		students.add(new Student("Oscar"	, "Swift"		, LocalDate.parse("19/06/1992", formatter), new BigDecimal("1500")));
		students.add(new Student("Hareem"	, "Salgado"		, LocalDate.parse("16/07/1992", formatter), new BigDecimal("1800")));
		students.add(new Student("Vikram"	, "Bellamy"		, LocalDate.parse("25/09/1994", formatter), new BigDecimal("1990")));
		students.add(new Student("Jeremy"	, "Ho"			, LocalDate.parse("27/03/1995", formatter), new BigDecimal("800")));
		students.add(new Student("Mathias" 	, "Wormald"		, LocalDate.parse("14/06/1995", formatter), new BigDecimal("20")));
		students.add(new Student("Jiya"    	, "Davie"		, LocalDate.parse("24/07/1995", formatter), new BigDecimal("0")));
		students.add(new Student("Georgia" 	, "Morin"		, LocalDate.parse("09/08/1996", formatter), new BigDecimal("100")));
		students.add(new Student("Vera"    	, "Knox"		, LocalDate.parse("21/07/1998", formatter), new BigDecimal("330")));
		students.add(new Student("Abdulahi"	, "Carlson"		, LocalDate.parse("08/01/2000", formatter), new BigDecimal("2444")));
		students.add(new Student("Sinead"	, "Ryder"		, LocalDate.parse("29/01/2000", formatter), new BigDecimal("300")));
		students.add(new Student("Jamal"	, "Wallis"		, LocalDate.parse("21/02/2000", formatter), new BigDecimal("431")));
		students.add(new Student("Noor"		, "Russo"		, LocalDate.parse("10/08/2000", formatter), new BigDecimal("280")));
		students.add(new Student("Mariah"	, "Craig"		, LocalDate.parse("16/07/1981", formatter), new BigDecimal("250")));
		students.add(new Student("Saqlain"	, "Weston"		, LocalDate.parse("14/11/1982", formatter), new BigDecimal("1901")));
		students.add(new Student("Ashanti"	, "McKay"		, LocalDate.parse("02/04/1984", formatter), new BigDecimal("2030")));
		students.add(new Student("Gene"		, "Sanchez"		, LocalDate.parse("17/02/1985", formatter), new BigDecimal("1080")));
		students.add(new Student("Rubie"	, "Christie"	, LocalDate.parse("06/03/1985", formatter), new BigDecimal("40")));
		students.add(new Student("Jae"		, "Byrd"		, LocalDate.parse("28/08/1986", formatter), new BigDecimal("2100")));
		students.add(new Student("Arya"		, "Whitehead"	, LocalDate.parse("04/02/1987", formatter), new BigDecimal("1900")));
		students.add(new Student("Raphael"	, "Martinez"	, LocalDate.parse("23/03/1990", formatter), new BigDecimal("1500")));
		students.add(new Student("Bodhi"	, "Robles"		, LocalDate.parse("20/08/1990", formatter), new BigDecimal("1300")));
		students.add(new Student("Harlan"	, "Butt"		, LocalDate.parse("01/01/1991", formatter), new BigDecimal("120")));
		students.add(new Student("Jethro"	, "Carver"		, LocalDate.parse("18/04/1991", formatter), new BigDecimal("110")));
		students.add(new Student("Jedd"		, "Currie"		, LocalDate.parse("07/07/1991", formatter), new BigDecimal("105")));
		students.add(new Student("Laurie"	, "Childs"		, LocalDate.parse("08/02/1992", formatter), new BigDecimal("2000")));
		students.add(new Student("Faith"	, "Greaves"		, LocalDate.parse("23/07/1992", formatter), new BigDecimal("2010")));
		students.add(new Student("Julien"	, "Carey"		, LocalDate.parse("18/08/1992", formatter), new BigDecimal("2000")));
		students.add(new Student("Jakob"	, "Hart"		, LocalDate.parse("05/10/1992", formatter), new BigDecimal("2000")));
		students.add(new Student("Ciaran"	, "Lancaster"	, LocalDate.parse("30/04/1993", formatter), new BigDecimal("1060")));
		students.add(new Student("Farhaan"	, "Kramer"		, LocalDate.parse("11/02/1994", formatter), new BigDecimal("40")));
		students.add(new Student("Reyansh"	, "Camacho"		, LocalDate.parse("06/07/1995", formatter), new BigDecimal("0")));
		students.add(new Student("Tiago"	, "Corrigan"	, LocalDate.parse("02/02/1996", formatter), new BigDecimal("0")));
		students.add(new Student("Elana"	, "O'Sullivan"	, LocalDate.parse("22/05/1997", formatter), new BigDecimal("0")));
		students.add(new Student("Zayne"	, "McCarty"		, LocalDate.parse("19/10/1997", formatter), new BigDecimal("1230")));
		students.add(new Student("Ella-Mai"	, "Fletcher"	, LocalDate.parse("02/05/1998", formatter), new BigDecimal("1704")));
		students.add(new Student("Max"		, "Fulton"		, LocalDate.parse("03/12/1998", formatter), new BigDecimal("180")));
		students.add(new Student("Tonisha"  , "Barnett"		, LocalDate.parse("02/03/1999", formatter), new BigDecimal("2149")));
//		students.add(new Student("Khadija"  , "Ellis"		, LocalDate.parse("07/06/1991", formatter), new BigDecimal("19")));
//		students.add(new Student("Saeed"    , "Vaughan"		, LocalDate.parse("01/01/1989", formatter), new BigDecimal("1320")));
//		students.add(new Student("Blanka"   , "Guerrero"	, LocalDate.parse("21/09/1982", formatter), new BigDecimal("123")));
//		students.add(new Student("Dione"	, "Tran"		, LocalDate.parse("18/01/1994", formatter), new BigDecimal("1230")));
//		students.add(new Student("Viaan"	, "Whittaker"	, LocalDate.parse("28/09/1996", formatter), new BigDecimal("2100")));
//		students.add(new Student("Cherie"	, "Marriott"	, LocalDate.parse("22/12/1996", formatter), new BigDecimal("2000")));
//		students.add(new Student("Riley"	, "Gray"		, LocalDate.parse("21/09/1982", formatter), new BigDecimal("2500")));
//		students.add(new Student("Zakaria"	, "Perez"		, LocalDate.parse("01/01/1989", formatter), new BigDecimal("2001")));
		return students;
	}
}
