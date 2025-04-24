package advance.dev;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Student[] st = new Student[10];
        input(st);
        print(st);


    }
    public static void input(Student[] st){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Nhập thông tin học sinh:");
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Tuổi: ");
            int age= sc.nextInt();
            sc.nextLine();
            System.out.print("Địa chỉ: ");
            String address = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String phone = sc.nextLine();
            System.out.print("Điểm trung bình: ");
            double gpa = sc.nextDouble();
            sc.nextLine();
            st[i] = new Student(name,age,address,phone,gpa);

        }
    }
    public static void print(Student[] st){
        for(int i=0;i<10;i++){
            System.out.println("Studen "+(i+1)+ ": " + st[i].toString());
        }

    }

}
