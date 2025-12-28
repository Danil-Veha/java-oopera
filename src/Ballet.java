public class Ballet extends MusicalSpectacle {
    protected String choreographer;

    public Ballet(String title, int duration, Person director,
                  String musicAuthor, String librettoText, String choreographer) {
        super(title, duration, director, musicAuthor, librettoText);

        if (choreographer == null && director != null && director.getChoreographer() != null) {
            this.choreographer = director.getChoreographer();
        } else {
            this.choreographer = choreographer;
        }
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
    }

}