package TD1.Exercice1;

public class Test {

    public static void main(String[] args) {

        //Q1
        new Vide();

        //Q2
        Personne uneAutrePersonne = new Personne();
        System.out.println(uneAutrePersonne.getNom());
        System.out.println(uneAutrePersonne.getNumero());

        //Q3
        Surcharge s = new Surcharge();
        s.affiche();
        s.affiche("Test");
        s.affiche(4, "Cool");

        //Q4
        Person unePersonne = new Person();
        System.out.println("Age = " +unePersonne.getAge()+ ", majeur : " + (unePersonne.isMajeur()? "oui":"non" ) );
        unePersonne.setAge(20);
        System.out.println("Age = " +unePersonne.getAge()+ ", majeur : " + (unePersonne.isMajeur()? "oui":"non" ) );
        unePersonne.setAge(6);
        System.out.println("Age = " +unePersonne.getAge()+ ", majeur : " + (unePersonne.isMajeur()? "oui":"non" ) );

        //Q5
        //Point p1 = new Point();
        //System.out.println(p1.affiche());

        //Point p2 = new Point(4. , 5.);
        //System.out.println(p2.affiche());

        //Point p3 = new Point(p2);
        //System.out.println(p3.affiche());
    }

}
