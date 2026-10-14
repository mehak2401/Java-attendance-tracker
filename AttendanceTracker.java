import java.util.Arrays;

public class AttendanceTracker {

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("Input: " + Arrays.toString(days1));
        printAttendanceSummary(days1);

        System.out.println();

        int[] days2 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(days2));
        printAttendanceSummary(days2);
    }

    public static int[] attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        // Single pass through the array
        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // Reset streak on absence
            }
        }

        return new int[]{totalPresent, longestStreak};
    }

    public static void printAttendanceSummary(int[] days) {
        int[] summary = attendanceSummary(days);
        System.out.printf("Present: %d, Longest streak: %d%n", summary[0], summary[1]);
    }
}