package main;

import entity.LessonManagement;
import entity.Subject;
import entity.Teacher;
import logic.LogicTeacher;

public class Main {
    public static Teacher[] TEACHER = new Teacher[100];
    public static Subject[] SUBJECT = new Subject[100];
    public static LessonManagement[] LESSONMANAGEMENT = new LessonManagement[100];
    public static void main(String[] args) {

        MainLogic.menu();

    }
}