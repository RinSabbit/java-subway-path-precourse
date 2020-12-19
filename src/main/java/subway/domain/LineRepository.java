package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.SubwayException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLine(String name) {
        return lines().stream()
            .filter(line -> Objects.equals(line.getName(), name))
            .findFirst()
            .orElseThrow(() -> new SubwayException("없는 노선입니다."));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
