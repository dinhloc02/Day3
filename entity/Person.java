package entity;

import impl.infoImpl;

import java.util.Scanner;

public class Person implements infoImpl {
    private String FullName;
    private String Adress;
    private String PhoneNumber;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void inputInfo() {
        System.out.println("Nhập họ tên giảng viên:");
        this.setFullName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ của giảng viên ");
        this.setAdress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại giảng viên");
        this.setPhoneNumber(new Scanner(System.in).nextLine());

    }

    @Override
    public String toString() {
        return "Họ tên:" + FullName + '\'' + ", địa chỉ:" + Adress + '\'' + ", số điện thoại:" + PhoneNumber + '\'';
    }
}

