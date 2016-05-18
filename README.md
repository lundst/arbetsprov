# arbetsprov
0Uppgiften g�r ut p� att i java implementera en bokaff�r. B�ckerna i aff�ren ska inneh�lla titel, f�rfattare, pris och antal i lager. De ska laddas fr�n http://www.contribe.se/bookstoredata/bookstoredata.txt, datan ska endast laddas ner och inte upp. Klassen som h�ller reda p� alla b�cker ska implementera f�ljande interface;


public interface BookList {  
   public Book[] list(String searchString);
   public boolean add(Book book, int amount);
   public int[] buy(Book... books);
}


Statusen fr�n buy ska kunna ge:
OK(0),
NOT_IN_STOCK(1),
DOES_NOT_EXIST(2)


Klassen �Book� ska inneh�lla f�ljande:


public class Book {
   private String title;
   private String author;
   private BigDecimal price;
}


En anv�ndare ska kunna ta fram en lista p� b�cker, antingen hela lagret eller s� ska den kunna s�ka p� titel och f�rfattare. Sedan ska anv�ndaren kunna l�gga till och ta bort b�cker fr�n sin kundvagn och k�pa allt i kundvagnen (d�r det totala priset r�knas ut).


Det ska vara m�jligt att ut�ka aff�rens utbud.


Skriv l�mpliga enhetstester d�r du ser att det finns ett behov..


Fokusera p� backend, utg� fr�n att frontend-delen ska vara utbytbar det vill s�ga att ett annat frontend team �r f�rsenade och ska koppla in sitt gr�nssnitt mot backendet du bygger..
Du skriver g�rna logiken i ett IDE t.ex. Eclipse eller netbeans.
3-part programvaror f�r anv�ndas om man kan motivera behovet och att  strukturen �r uppbyggd p� ett s�tt som g�r att allt som beh�vs f�r att anv�nda den finns i projektet.


Obs! Det ska vara k�rbart.


All kod ska laddas upp till ett repo p� Github vars l�nk skickas till arbetsprov@contribe.se.
