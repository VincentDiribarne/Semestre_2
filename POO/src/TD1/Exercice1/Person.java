package TD1.Exercice1;

public class Person {

    private int age=42;
    private boolean majeur=false;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        majeur = (age >= 18);
        this.age = age;
    }

    public boolean isMajeur() {
        return majeur;
    }
}

