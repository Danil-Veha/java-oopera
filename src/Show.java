import java.util.*;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> actors;

    public Show(String title, Director director, ArrayList<Actor> actors, int duration) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.duration = duration;
    }

    public Show(String title, Director director, int duration) {
        this.title = title;
        this.director = director;
        this.actors = new ArrayList<>();
        this.duration = duration;
    }

    public boolean hasActorsWithSameSurname() {
        if (actors == null || actors.size() < 2) {
            return false;
        }

        Set<String> surnames = new HashSet<>();
        for (Person actor : actors) {
            if (actor != null && !surnames.add(actor.getSurname())) {
                return true;
            }
        }
        return false;
    }

    public Map<String, List<Person>> getActorsWithSameSurname() {
        Map<String, List<Person>> result = new HashMap<>();

        if (actors == null || actors.size() < 2) {
            return result;
        }

        Map<String, List<Person>> surnameMap = new HashMap<>();
        for (Person actor : actors) {
            if (actor != null) {
                String surname = actor.getSurname();
                surnameMap.computeIfAbsent(surname, k -> new ArrayList<>()).add(actor);
            }
        }

        for (Map.Entry<String, List<Person>> entry : surnameMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр спектакля '" + title + "': " + director);
    }

    public void printActorsList() {
        System.out.println("Актёры спектакля '" + title + "':");
        if (actors.isEmpty()) {
            System.out.println("  (актёров нет)");
        } else {
            for (Actor actor : actors) {
                System.out.println("  - " + actor);
            }
        }
    }

    public boolean addActor(Actor newActor) {
        if (newActor == null) {
            System.out.println("Ошибка: пытаемся добавить null-актёра!");
            return false;
        }

        if (actors.contains(newActor)) {
            System.out.println("Актёр " + newActor + " уже участвует в спектакле!");
            return false;
        }

        actors.add(newActor);
        System.out.println("Актёр " + newActor + " успешно добавлен в спектакль '" + title + "'");
        return true;
    }

    public boolean replaceActor(String oldActorSurname, Actor newActor) {
        if (oldActorSurname == null && oldActorSurname.isEmpty() && newActor == null) {
            System.out.println("Ошибка: некорректные входные данные!");
            return false;
        }

        for (int i = 0; i < actors.size(); i++) {
            Actor actor = actors.get(i);
            if (actor.getSurname().equalsIgnoreCase(oldActorSurname)) {
                Actor oldActor = actors.get(i);
                actors.set(i, newActor);
                System.out.println("Актёр " + oldActor + " заменён на " + newActor);
                return true;
            }
        }

        System.out.println("Актёр с фамилией '" + oldActorSurname + "' не найден в спектакле.");
        return false;
    }



    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

}