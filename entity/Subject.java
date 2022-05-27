package entity;

import impl.infoImpl;

import java.util.Scanner;

public class Subject implements infoImpl {
    private static int id = 100;
    private int idSubject;
    private String subjectTitle;
    private int totalLesson;
    private int theoryLesson;
    private double lessonCost;

    public int getIdSubject() {
        return idSubject;
    }


    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public double getLessonCost() {
        return lessonCost;
    }

    public void setLessonCost(double lessonCost) {
        this.lessonCost = lessonCost;
    }

    @Override
    public String toString() {
        return
                "Mã môn học:" + idSubject +
                ", tên môn học:" + subjectTitle + '\'' +
                ", tổng số tiết:" + totalLesson +
                ", số tiết lý thuyết:" + theoryLesson +
                ", mức kinh phí:" + lessonCost +
                '}';
    }

    public void inputInfo() {
        this.idSubject = Subject.id++;
        System.out.println("Mã môn học :" + this.getIdSubject());
        System.out.println("Nhập tên môn học:");
        this.setSubjectTitle(new Scanner(System.in).nextLine());
        System.out.println("Nhập tổng số tiết:");
        int tempTotalLesson = -1;
        do {
            try {
                tempTotalLesson = new Scanner(System.in).nextInt();
                if (tempTotalLesson > 0) {
                    this.totalLesson = tempTotalLesson;
                    break;
                }
                System.out.print("Tổng số tiết phải là số nguyên, vui lòng nhập lại: ");
            } catch (Exception e) {
                System.out.print("Tổng số tiết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);


        System.out.println("Nhập số tiết lý thuyết");
        int tempTheoryLesson = -1;
        do {
            try {
                tempTheoryLesson = new Scanner(System.in).nextInt();
                if (tempTheoryLesson > 0) {
                    this.theoryLesson = tempTheoryLesson;
                    break;
                }
                System.out.print("Tổng số tiết lý thuyết phải là số nguyên, vui lòng nhập lại: ");
            } catch (Exception e) {
                System.out.print("Tổng số tiết lý thuyết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);

        System.out.println("Nhập số kinh phí :");
        double tempLessonCost = -1;
        do {
            try {
                tempLessonCost = new Scanner(System.in).nextDouble();
                if (tempLessonCost > 0) {
                    this.lessonCost = tempLessonCost;
                    break;
                }
                System.out.print("Kinh phí phải là số thực , vui lòng nhập lại: ");
            } catch (Exception e) {
                System.out.print("Kinh phí phải là một số thực, vui lòng nhập lại: ");
            }
        } while (true);

    }
}

