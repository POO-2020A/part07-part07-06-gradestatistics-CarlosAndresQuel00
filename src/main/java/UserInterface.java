
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        int points, count1 = 0, sum1 = 0, count2 = 0, sum2 = 0;
        int count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0;
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            points = Integer.valueOf(this.scanner.nextLine());
            if (points == -1) {
                break;
            }
            if (points >= 0 && points <= 100) {
                count1++;
                sum1 += points;
                if (points >= 50 && points <= 100) {
                    count2++;
                    sum2 += points;
                }
            }
            if (points >= 90 && points <= 100) {
                count3++;
            } else if (points >= 80 && points < 90) {
                count4++;
            } else if (points >= 70 && points < 80) {
                count5++;
            } else if (points >= 60 && points < 70) {
                count6++;
            } else if (points >= 50 && points < 60) {
                count7++;
            } else if (points >= 0 && points < 50) {
                count8++;
            }
        }
        System.out.println("Point average (all): " + average(sum1, count1));
        if (count2 != 0) {
            System.out.println("Point average (passing): " + average(sum2, count2));
            System.out.println("Pass percentage: " + percentagePoints(count2, count1));
        } else {
            System.out.println("Point average (passing): -");
            System.out.println("Pass percentage: 0.0");
        }
        System.out.println("Grade distribution:");
        for (int i = 5; i >= 0; i--) {
            System.out.print(i + ": ");
            if (i == 5) {
                stars(count3);
            } else if (i == 4) {
                stars(count4);
            } else if (i == 3) {
                stars(count5);
            } else if (i == 2) {
                stars(count6);
            } else if (i == 1) {
                stars(count7);
            } else if (i == 0) {
                stars(count8);
            }
            System.out.println("");
        }
    }

    public static double average(int total, int numbers) {
        return (double) total / numbers;
    }

    public static double percentagePoints(int numbers, int total) {
        return 100.0 * numbers / total;
    }

    public static void stars(int numberStars) {
        for (int i = 0; i < numberStars; i++) {
            System.out.print("*");
        }
    }
}
