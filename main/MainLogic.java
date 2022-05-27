package main;

import entity.LessonManagement;
import logic.LogicLessonManagement;
import logic.LogicSubject;
import logic.LogicTeacher;

import java.util.Scanner;

public class MainLogic {
    public static void menu() {
        System.out.println("--------------QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG--------------");
        System.out.println("1. Nhập danh sách môn học mới trong trường");
        System.out.println("2. In ra danh sách môn học trong trường");
        System.out.println("3. Nhập danh sách giảng viên mới trong trường");
        System.out.println("4. In ra danh sách giảng viên trong trường");
        System.out.println("5. Phân công giảng dạy cho giảng viên và in ra danh sách giảng dạy");
        System.out.println("6. Sắp xếp danh sách giảng dạy theo tên");
        System.out.println("7. Sắp xếp danh sách giảng dạy theo số lượng tiết");
        System.out.println("8 Tính toán và lập bảng lương");
        System.out.println("9. Thoát");
        System.out.println("----------------------------------------------");

        boolean check = true;
        int choice = 0;
        do {
            System.out.print("Chọn chức năng: ");
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice >= 1 && choice <= 9) {
                        break;
                    }
                    System.out.print("Chức năng khả dụng là một số nguyên từ 1 tới 9, vui lòng chọn lại: ");
                } catch (Exception e) {
                    System.out.print("Chức năng chọn phải là một số nguyên, vui lòng nhập lại: ");
                }
            } while (true);

            switch (choice) {
                case 1:
                    LogicSubject.inputNewInfo();
                    break;
                case 2:
                    LogicSubject.showInfo();
                    break;
                case 3:
                    LogicTeacher.inputNewInfo();
                    break;
                case 4:
                    LogicTeacher.showInfo();
                    break;
                case 5:
                    LogicLessonManagement.inputLessonManagement();
                    LogicLessonManagement.showLessonManagement();
                    break;
                case 6:
                    LogicLessonManagement.sortLessonName();
                    break;
                case 7:
                    LogicLessonManagement.sortLessonQuantity();
                    break;
                case 8:
                    LogicLessonManagement.payroll();
                    break;
                case 9:
                    check = false;
                    break;
            }
        } while (check);

    }
}

