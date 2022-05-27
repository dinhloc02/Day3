package entity;

public class SubjectTeacher {
    private Subject subject;
    private int quantity;

    public SubjectTeacher(Subject subject, int quantity) {
        this.subject = subject;
        this.quantity = quantity;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return subject + ", số lớp dạy:" + quantity ;
    }
}
