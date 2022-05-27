package logic;

import entity.Subject;
import main.Main;

import java.util.Scanner;

public class LogicSubject {
    public static void inputNewInfo() {
        System.out.println("Nhập số lượng môn học cần thêm");
        int quantity = new Scanner(System.in).nextInt();
        for (int i = 0; i < quantity; ++i) {
            Subject subject = new Subject();
            subject.inputInfo();
            saveInfo(subject);
            showInfo();
        }
    }

    public static void saveInfo(Subject subject) {
        for (int i = 0; i < Main.SUBJECT.length; ++i) {
            if (Main.SUBJECT[i] == null) {
                Main.SUBJECT[i] = subject;
                break;
            }

        }
    }

    public static void showInfo() {
        for (int i = 0; i < Main.SUBJECT.length; ++i) {
            if (Main.SUBJECT[i] == null) {
                continue;
            }
            System.out.println(Main.SUBJECT[i]);
        }
    }

    public static boolean isEmptySubject() {
        for (int i = 0; i < Main.SUBJECT.length; ++i) {
            if (Main.SUBJECT[i] != null) {
                return false;
            }
        }
        return true;
    }

}
