public class Theatre {
    public static void main(String[] args) {
        System.out.println("=== ТЕАТР: ПРОВЕРКА АРХИТЕКТУРЫ ===\n");

        // Пример 1: Обычный актер (не композитор, не хореограф)
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 180.5);
        System.out.println("1. Обычный актер: " + actor1);

        // Пример 2: Актер-композитор
        Actor actor2 = new Actor("Сергей", "Рахманинов", Gender.MALE, 175.0);
        actor2.setMusicAuthor("Сергей Рахманинов");
        System.out.println("2. Актер-композитор: " + actor2);

        // Пример 3: Обычный режиссер
        Director director1 = new Director("Петр", "Режиссеров", Gender.MALE, 15);
        System.out.println("3. Обычный режиссер: " + director1);

        // Пример 4: Режиссер-хореограф
        Director director2 = new Director("Мариус", "Петипа", Gender.MALE, 25);
        director2.setChoreographer("Мариус Петипа");
        System.out.println("4. Режиссер-хореограф: " + director2);

        // Пример 5: Режиссер-композитор-хореограф (мультиталант)
        Director director3 = new Director("Леонид", "Мультиталантов", Gender.MALE, 30);
        director3.setMusicAuthor("Леонид Мультиталантов");
        director3.setChoreographer("Леонид Мультиталантов");
        System.out.println("5. Режиссер-композитор-хореограф: " + director3);

        System.out.println("\n=== СОЗДАНИЕ СПЕКТАКЛЕЙ ===");

        // Обычный спектакль
        Show regularShow = new Show("Горе от ума", 120, director1);
        regularShow.addActor(actor1);
        System.out.println("Обычный спектакль создан");

        // Опера: musicAuthor берется из параметра
        Opera opera = new Opera("Травиата", 150, director1,
                "Джузеппе Верди", "Либретто оперы...", 30);
        System.out.println("Опера создана, композитор: " + opera.getMusicAuthor());

        // Балет: choreographer берется из режиссера (director2 - хореограф)
        Ballet ballet = new Ballet("Лебединое озеро", 135, director2,
                "Пётр Чайковский", "Либретто балета...", null);
        System.out.println("Балет создан, хореограф: " + ballet.getChoreographer());

        // Балет с режиссером-композитором-хореографом
        Ballet ballet2 = new Ballet("Щелкунчик", 120, director3,
                null, "Либретто...", null);
        System.out.println("Балет2 создан:");
        System.out.println("  Композитор: " + ballet2.getMusicAuthor());
        System.out.println("  Хореограф: " + ballet2.getChoreographer());

        System.out.println("\n=== ПРОВЕРКА МЕТОДОВ ===");

        // Проверка equals для актеров
        Actor actorA = new Actor("Иван", "Иванов", Gender.MALE, 180.0);
        Actor actorB = new Actor("Иван", "Иванов", Gender.MALE, 180.0); Actor actorC = new Actor("Иван", "Иванов", Gender.MALE, 175.0);

        System.out.println("actorA.equals(actorB): " + actorA.equals(actorB));
        System.out.println("actorA.equals(actorC): " + actorA.equals(actorC));

        // Проверка добавления дубликата
        regularShow.addActor(actorA);
        regularShow.addActor(actorB); // Должен быть отклонен как дубликат

        System.out.println("\n=== АРХИТЕКТУРНЫЕ ВЫВОДЫ ===");
        System.out.println("1. Actor и Director наследуются от Person");
        System.out.println("2. Person содержит поля musicAuthor и choreographer (по требованию ревьюера)");
        System.out.println("3. Поля musicAuthor и choreographer могут быть null");
        System.out.println("4. MusicalShow может получить эти поля из Person, если они не указаны явно");
        System.out.println("5. Один человек может иметь несколько творческих ролей");
    }
}
