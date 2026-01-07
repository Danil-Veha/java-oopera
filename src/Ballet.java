import java.util.ArrayList;

public class Ballet extends MusicalShow {
    protected Person choreographer;

    public Ballet(String title, int duration, Director director,
                  ArrayList<Actor> actors, Person musicAuthor, String librettoText,
                  Person choreographer) {
        super(title, duration, director, actors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(Person choreographer) {
        this.choreographer = choreographer;
    }

}