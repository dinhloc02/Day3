package logic;

import entity.Teacher;
import main.Main;

import java.util.Scanner;

public class LogicTeacher {
    public static void inputNewInfo() {
        System.out.println("Nhập số giảng viên cần thêm");
        int quantity = new Scanner(System.in).nextInt();
        for (int j = 0; j < quantity; ++j) {
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            saveInfo(teacher);
            showInfo();
        }
    }

    public static void saveInfo(Teacher teacher) {
        for (int i = 0; i < Main.TEACHER.length; ++i) {
            if (Main.TEACHER[i] == null) {
                Main.TEACHER[i] = teacher;
                break;
            }
        }
    }

    public static void showInfo() {
        for (int i = 0; i < Main.TEACHER.length; ++i) {
            if (Main.TEACHER[i] == null) {
                continue;
            }
            System.out.println(Main.TEACHER[i]);
        }
    }

    public static boolean isEmptyTeacher() {
        for (int i = 0; i < Main.TEACHER.length; ++i) {
            if (Main.TEACHER[i] != null) {
                return false;
            }
        }
        return true;
    }
}

