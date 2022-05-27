package entity;

import java.util.Scanner;

public class Teacher extends Person  {
    private static int id = 100;
    public static final String GS_TS = "Giáo sư - Tiến sĩ";
    public static final String PGS_TS = "Phó giáo sư - Tiến sĩ";
    public static final String TS = "Thạc sĩ";
    public static final String GVC = " Giảng viên chính";
    private int idGV;
    private String teacherLV;


    public int getidGV() {
        return idGV;
    }


    public String getTeacherLV() {
        return teacherLV;
    }

    public void setTeacherLV(String teacherLV) {
        this.teacherLV = teacherLV;
    }


    @Override
    public String toString() {
        return super.toString() + "Mã giảng viên:" + idGV + "Trình độ" + teacherLV + '\'';
    }

    public void inputInfo() {
        this.idGV = Teacher.id++;
        System.out.println("Mã giảng viên:" + this.getidGV());
        super.inputInfo();
        System.out.println("Nhập trình độ giảng viên :");
        System.out.println("1:Giáo sư - Tiến sĩ");
        System.out.println("2:Phó giáo sư -Tiến sĩ");
        System.out.println("3:Thạc sĩ");
        System.out.println("4:Giảng viên chính");
        boolean check = true;
        int level = 0;
        do {
            try {
                level = new Scanner(System.in).nextInt();
                check = false;
                if (level < 1 || level > 4) {
                    System.out.println("Không có kiểu dữ liệu nhập lại:");
                }
            } catch (Exception e) {
                System.out.println("Không có kiểu dữ liệu nhập lại:");
                new Scanner(System.in).next();
            }

        } while (check || level > 4 || level < 1);
        switch (level) {
            case 1:
                this.teacherLV = Teacher.GS_TS;
                break;
            case 2:
                this.teacherLV = Teacher.PGS_TS;
                break;
            case 3:
                this.teacherLV = Teacher.TS;
                break;
            case 4:
                this.teacherLV = Teacher.GVC;
                break;
        }

    }
}
