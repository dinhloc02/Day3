package entity;

import java.util.Arrays;

public class LessonManagement {
    private Teacher teacher;
    private SubjectTeacher[] subjectTeacher;

    public LessonManagement(Teacher teacher, SubjectTeacher[] subjectTeacher) {
        this.teacher = teacher;
        this.subjectTeacher = subjectTeacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SubjectTeacher[] getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(SubjectTeacher[] subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public int getCurrentTotalLesson() {
        if (LessonManagement.isNullOrEmptyArray(subjectTeacher)) {
            return 0;
        }
        int currentTotalLesson = 0;
        for (int i = 0; i < subjectTeacher.length; ++i) {
            int subject = subjectTeacher[i].getSubject().getTotalLesson();
            int quantity = subjectTeacher[i].getQuantity();
            currentTotalLesson += quantity * subject;
        }
        return currentTotalLesson;

    }


    @Override
    public String toString() {
        return  teacher +  Arrays.toString(subjectTeacher) ;
    }

    public static boolean isNullOrEmptyArray(Object[] obj) {
        return obj == null && obj.length == 0;
    }
}
