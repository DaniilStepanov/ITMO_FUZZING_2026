package org.itmo.fuzzing.lab1;

/**
 * Ручной запуск лабиринта без фаззера.
 *
 * <p>Передайте маршрут первым аргументом командной строки. Если аргумент не задан, используется
 * короткий безопасный пример {@code "D"}. Класс нужен для знакомства с форматом входа и значениями
 * {@code VALID}, {@code INVALID} и {@code SOLVED}; готовый маршрут до цели здесь намеренно не дан.</p>
 */
public final class MazeRunner {

    public static final String MAZE_EXAMPLE = """
            +-+-----+
            |X|     |
            | | --+ |
            | |   | |
            | +-- | |
            |     |#|
            +-----+-+
            """;

    private MazeRunner() {
    }

    public static void main(String[] args) {
        String input = args.length == 0 ? "D" : args[0];
        System.out.println(MazeGenerated.maze(input));
    }
}
