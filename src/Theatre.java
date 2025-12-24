public class Theatre {
    public static void main(String[] args) {
        //  Создаём актёров
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 180.5);
        Actor actor2 = new Actor("Мария", "Петрова", Gender.FEMALE, 165.0);
        Actor actor3 = new Actor("Алексей", "Сидоров", Gender.MALE, 175.0);

        //  Создаём режиссёров
        Director director1 = new Director("Петр", "Режиссеров", Gender.MALE, 15);
        Director director2 = new Director("Ольга", "Постановщикова", Gender.FEMALE, 8);

        //  Создаём спектакли
        Show regularShow = new Show("Горе от ума", 120, director1);
        Opera opera = new Opera("Травиата", 150, director2, "Джузеппе Верди",
                "История о любви и жертве...", 30);
        Ballet ballet = new Ballet("Лебединое озеро", 135, director1, "Пётр Чайковский",
                "История о заколдованной принцессе...", "Мариус Петипа");

        //  Добавляем актёров в спектакли
        System.out.println("=== Добавление актёров ===");
        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        //  Выводим списки актёров
        System.out.println("\n=== Списки актёров ===");
        regularShow.printActorsList();
        opera.printActorsList();
        ballet.printActorsList();

        //  Пытаемся добавить дубликат (проверь работу метода addActor)
        System.out.println("\n=== Попытка добавить дубликат ===");
        regularShow.addActor(actor1); // Должно появиться предупреждение

        //  Замена актёра
        System.out.println("\n=== Замена актёра ===");
        Actor newActor = new Actor("Новый", "Актер", Gender.MALE, 182.0);
        boolean replaced = regularShow.replaceActor("Иванов", newActor);
        if (replaced) {
            System.out.println("Актёр заменён!");
            regularShow.printActorsList();
        }

        //  Попытка замены несуществующего актёра
        System.out.println("\n=== Попытка замены несуществующего актёра ===");
        boolean notReplaced = opera.replaceActor("Несуществующий", newActor);

        //  Вывод либретто
        System.out.println("\n=== Либретто музыкальных спектаклей ===");
        opera.printLibretto();
        ballet.printLibretto();

        //  Вывод информации о режиссёрах
        System.out.println("\n=== Информация о режиссёрах ===");
        regularShow.printDirectorInfo();
    }
}
