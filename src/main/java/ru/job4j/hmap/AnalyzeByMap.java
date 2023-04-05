package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0, count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return count > 0 ? sum * 1.0D / count : 0D;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averages = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int sum = 0, count = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            averages.add(new Label(pupil.name(), count > 0 ? sum * 1.0D / count : 0D));
        }
        return averages;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sumBySubject = new LinkedHashMap<>();
        Map<String, Integer> countBySubject = new LinkedHashMap<>();
        List<Label> averages = new LinkedList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumBySubject.merge(subject.name(), subject.score(), Integer::sum);
                countBySubject.merge(subject.name(), 1, Integer::sum);
            }
        }
        for (String key : sumBySubject.keySet()) {
            averages.add(new Label(key, sumBySubject.get(key) * 1.0D / countBySubject.get(key)));
        }
        return averages;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        LinkedList<Label> averages = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            averages.add(new Label(pupil.name(), sum * 1.0D));
        }
        averages.sort(Comparator.naturalOrder());
        return averages.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> sumBySubject = new LinkedHashMap<>();
        LinkedList<Label> averages = new LinkedList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumBySubject.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : sumBySubject.keySet()) {
            averages.add(new Label(key, sumBySubject.get(key) * 1.0D));
        }
        averages.sort(Comparator.naturalOrder());
        return averages.getLast();
    }
}
