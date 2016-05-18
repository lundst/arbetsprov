# arbetsprov
0Uppgiften går ut på att i java implementera en bokaffär. Böckerna i affären ska innehålla titel, författare, pris och antal i lager. De ska laddas från http://www.contribe.se/bookstoredata/bookstoredata.txt, datan ska endast laddas ner och inte upp. Klassen som håller reda på alla böcker ska implementera följande interface;


public interface BookList {  
   public Book[] list(String searchString);
   public boolean add(Book book, int amount);
   public int[] buy(Book... books);
}


Statusen från buy ska kunna ge:
OK(0),
NOT_IN_STOCK(1),
DOES_NOT_EXIST(2)


Klassen “Book” ska innehålla följande:


public class Book {
   private String title;
   private String author;
   private BigDecimal price;
}


En användare ska kunna ta fram en lista på böcker, antingen hela lagret eller så ska den kunna söka på titel och författare. Sedan ska användaren kunna lägga till och ta bort böcker från sin kundvagn och köpa allt i kundvagnen (där det totala priset räknas ut).


Det ska vara möjligt att utöka affärens utbud.


Skriv lämpliga enhetstester där du ser att det finns ett behov..


Fokusera på backend, utgå från att frontend-delen ska vara utbytbar det vill säga att ett annat frontend team är försenade och ska koppla in sitt gränssnitt mot backendet du bygger..
Du skriver gärna logiken i ett IDE t.ex. Eclipse eller netbeans.
3-part programvaror får användas om man kan motivera behovet och att  strukturen är uppbyggd på ett sätt som gör att allt som behövs för att använda den finns i projektet.


Obs! Det ska vara körbart.


All kod ska laddas upp till ett repo på Github vars länk skickas till arbetsprov@contribe.se.
