package logic;

import entity.LessonManagement;
import entity.Subject;
import entity.SubjectTeacher;
import entity.Teacher;
import main.Main;

import java.util.Locale;
import java.util.Scanner;

public class LogicLessonManagement {
    public static void saveLessonManagement(LessonManagement lessonManagement) {
        for (int i = 0; i < Main.LESSONMANAGEMENT.length; ++i) {
            if (Main.LESSONMANAGEMENT[i] == null) {
                Main.LESSONMANAGEMENT[i] = lessonManagement;
                break;
            }
        }
    }

    public static void showLessonManagement() {
        for (int i = 0; i < Main.LESSONMANAGEMENT.length; ++i) {
            if (Main.LESSONMANAGEMENT[i] == null) {
                continue;
            }
            System.out.println(Main.LESSONMANAGEMENT[i]);
        }

    }

    public static Teacher inputTeaching(int n) {
        System.out.println("Nhập mã giảng viên thứ " + ++n + "dạy học: ");
        Teacher teacher = null;
        do {
            int idTeaching = new Scanner(System.in).nextInt();
            for (int i = 0; i < Main.TEACHER.length; ++i) {
                if  ( Main.TEACHER[i] != null && Main.TEACHER[i].getidGV()==idTeaching) {
                    teacher = Main.TEACHER[i];
                    break;
                }
            }

            if (teacher != null) {
                break;
            }
            System.out.println("Không có mã giảng viên nhập lại");
        } while (true);
        return teacher;
    }

    public static SubjectTeacher[] inputClassSubject() {
        Subject subjects;
        System.out.println("Nhập số môn học cần dạy :");
        int quantitySubject = new Scanner(System.in).nextInt();
        SubjectTeacher[] subjectTeachers = new SubjectTeacher[quantitySubject];
        int sum = 0;

        for (int j = 0; j < quantitySubject; ++j) {
            System.out.println("Nhập mã môn học thứ " + ++j + "cần dạy thêm : ");
            Subject subject = null;


            do {
                int id = new Scanner(System.in).nextInt();
                for (int i = 0; i < Main.SUBJECT.length; ++i) {
                    if (Main.SUBJECT[i] != null && Main.SUBJECT[i].getIdSubject() == id) {
                        subject = Main.SUBJECT[i];
                        break;
                    }
                }
                if (subject != null) {
                    break;
                }
                System.out.println("Không có mã môn học nhập lại:");
            } while (true);

            System.out.println("Nhập số lớp cần dạy môn học đó");
            int quantity = 0;
            do {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0 && quantity < 4) {

                    break;
                }
                System.out.println(" Số lớp dạy không được lớn hơn 3 nhập lại và số tiết dạy không được lớn hơn 200:");
            } while (true);

            SubjectTeacher subjectTeacher = new SubjectTeacher(subject, quantity);
            for (int k = 0; k < subjectTeachers.length; ++k) {
                if (subjectTeachers[k] == null) {
                    subjectTeachers[k] = subjectTeacher;
                    break;
                }
            }

        }
        return subjectTeachers;
    }

    public static void inputLessonManagement() {
        if (LogicTeacher.isEmptyTeacher() || LogicSubject.isEmptySubject()) {
            System.out.println("Nhập giảng viên và môn học trước ");
            return;
        }
        System.out.println("Nhập số giảng viên cần phân công");
        int quantity = new Scanner(System.in).nextInt();
        for (int i = 0; i < quantity; ++i) {

            Teacher teacher = inputTeaching(i);
            SubjectTeacher[] subjectTeacher = inputClassSubject();
            LessonManagement lessonManagement = new LessonManagement(teacher, subjectTeacher);

            if (lessonManagement != null && quantityLesson(lessonManagement) > 200) {
                System.out.println("Số lượng phân công không được lớn hơn 200");
                continue;
            }
            saveLessonManagement(lessonManagement);

        }
    }

    public static int quantityLesson(LessonManagement lessonManagement) {
        int sum = 0;
        for (int i = 0; i < lessonManagement.getSubjectTeacher().length; ++i) {
            int subject = lessonManagement.getSubjectTeacher()[i].getSubject().getTotalLesson();
            int quantity = lessonManagement.getSubjectTeacher()[i].getQuantity();
            sum += subject * quantity;

        }
        return sum;
    }

    public static void sortLessonName() {
        for (int i = 0; i < Main.LESSONMANAGEMENT.length; ++i) {
            if (Main.LESSONMANAGEMENT[i] == null) {
                continue;
            }
            for (int j = i + 1; j < Main.LESSONMANAGEMENT.length; ++j) {
                if (Main.LESSONMANAGEMENT[j] == null) {
                    continue;
                }
                if (Main.LESSONMANAGEMENT[i].getTeacher().getFullName().toLowerCase().compareTo(Main.LESSONMANAGEMENT[j].getTeacher().getFullName().toLowerCase()) > 0) {
                    LessonManagement temp = Main.LESSONMANAGEMENT[i];
                    Main.LESSONMANAGEMENT[i]=Main.LESSONMANAGEMENT[j];
                    Main.LESSONMANAGEMENT[j]=temp;
                }
            }
        }
        showLessonManagement();
    }
    public static void sortLessonQuantity() {
        for (int i = 0; i < Main.LESSONMANAGEMENT.length; ++i) {
            if (Main.LESSONMANAGEMENT[i] == null) {
                continue;
            }
            for (int j = i + 1; j < Main.LESSONMANAGEMENT.length; ++j) {
                if (Main.LESSONMANAGEMENT[j] == null) {
                    continue;
                }
                if(Main.LESSONMANAGEMENT[i].getCurrentTotalLesson()<Main.LESSONMANAGEMENT[j].getCurrentTotalLesson()){
                    LessonManagement temp = Main.LESSONMANAGEMENT[i];
                    Main.LESSONMANAGEMENT[i]=Main.LESSONMANAGEMENT[j];
                    Main.LESSONMANAGEMENT[j]=temp;
                }
            }
        }
        showLessonManagement();
    }
    public static void payroll(){
        double money=0;

        for(int i=0;i<Main.LESSONMANAGEMENT.length;++i){
            if(Main.LESSONMANAGEMENT[i]!=null) {
                Subject lM = Main.LESSONMANAGEMENT[i].getSubjectTeacher()[i].getSubject();
                money +=( double) lM.getTheoryLesson() * lM.getLessonCost() + (lM.getTotalLesson() - lM.getTheoryLesson()) * lM.getLessonCost()*0.7;


                System.out.println("Tiền công của giảng viên thứ " + ++i + "là:" + money);
            }
        }
    }


    }


