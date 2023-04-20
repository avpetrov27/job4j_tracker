package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                        p.name(),
                        p.subjects()
                                .stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0D)))
                .collect(toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                        p.name(),
                        p.subjects()
                                .stream()
                                .mapToInt(Subject::score)
                                .sum()))
                .max(comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(comparing(Tuple::score))
                .orElse(null);
    }
}
