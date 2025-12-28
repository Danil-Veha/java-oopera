public class Person {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected String musicAuthor;    // композитор (может быть null)
    protected String choreographer;  // хореограф (может быть null)

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.musicAuthor = null;
        this.choreographer = null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;

    }
    public String getMusicAuthor() {
        return musicAuthor;
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
    }


    @Override
    public String toString() {
        String result = name + " " + surname;
        if (musicAuthor != null || choreographer != null) {
            result += " (";
            if (musicAuthor != null) result += "композитор: " + musicAuthor;
            if (musicAuthor != null && choreographer != null) result += ", ";
            if (choreographer != null) result += "хореограф: " + choreographer;
            result += ")";
        }
        return result;
    }
}