package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static final Map<String, Set<String>> studentsInfo = new HashMap<String, Set<String>>();
    private static final Set<String> DUPLICATED_STUDENTS = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> info : forms) {
            saveStudentsInfo(info);
        }
        findDuplicatedStudents();
        List<String> answer = List.of("answer");
        return answer; // 임시
    }

    private static void saveStudentsInfo(List<String> info) {
        String email = info.get(0);
        String name = info.get(1);

        for (int i = 0; i < name.length() - 1; i++) {
            String partOfName = name.substring(i, i + 2);
            if (!studentsInfo.containsKey(partOfName)) {
                Set<String> studentEmails = new HashSet<String>();
                studentEmails.add(email);
                studentsInfo.put(partOfName, studentEmails);
                continue;
            }
            studentsInfo.get(partOfName).add(email);
        }
    }

    private static void findDuplicatedStudents() {
        for (Set<String> studentEmails : studentsInfo.values()) {
            if (studentEmails.size() >= 2) {
                DUPLICATED_STUDENTS.addAll(studentEmails);
            }
        }
    }
}
