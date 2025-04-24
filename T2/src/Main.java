import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CanBo{
    String name;
    String sex;
    String address;
    int age;
    public CanBo(String name, String sex, String address, int age){
        this.name= name;
        this.sex=sex;
        this.address= address;
        this.age = age;
    }
    public void xuat(){
        System.out.println("Ho ten: "+ name);
        System.out.println("Tuoi: "+ age);
        System.out.println("Địa chỉ: "+ address);
        System.out.println("giới tính: "+ sex);
    }


}
class CongNhan extends CanBo{
    int bac;
    public CongNhan(String name, String sex, String address, int age,int bac){
        super(name,sex,address,age);
        this.bac= bac;
    }
    public void xuat(){
        super.xuat();
        System.out.println("Cấp Bậc: "+ bac);
    }
}

class KySu extends CanBo{
    String major;
    public KySu(String name, String sex, String address, int age,String major){
        super(name,address,sex,age);
    }
    public void xuat(){
        super.xuat();
        System.out.println("Ngành đào tạo: "+ major);
    }
}
class NhanVien extends CanBo{
    String work;
    public NhanVien(String name, String sex, String address, int age, String work){
        super(name,sex,address,age);
        this.work = work;
    }
    public void xuat(){
        super.xuat();
        System.out.println("Công Việc: ");
    }

}
class QLCB{
    List<CanBo>ql;
    public QLCB(){
        this.ql=new ArrayList<>();
    }
    public void add(CanBo cb){

        ql.add(cb);
    }
    public void search(String name){
        boolean A =false;
        for(CanBo cb : ql){
            if(cb.name.equalsIgnoreCase(name)) {
                cb.xuat();
                A=true;

            }
        }
        if(!A){
            System.out.println("khong tim thay");
        }
    }
    public void out(){
        if(ql.isEmpty()){
            System.out.println("DS rỗng");
            return;
        }
        System.out.println("DS Can Bo");
        for(CanBo cb : ql){
            cb.xuat();
            System.out.println("------");
        }



    }

}
public class Main{
    public static void main(String[] args){
        QLCB qlcb= new QLCB();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Quản lý cán bộ");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Thoát");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Chọn loại cán bộ ( 1-công nhân, 2 kỹ sư, 3 nhân viên):");
                    int type= sc.nextInt();
                    System.out.print("Họ tên:");
                    String name = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = sc.nextInt();
                    System.out.print("giới tính: ");
                    String sex = sc.nextLine();
                    System.out.print("Địa chỉ: ");
                    String address = sc.nextLine();
                    switch(type){
                        case 1:
                            System.out.print("Nhập bậc (1-10)");
                            int bac =sc.nextInt();
                            qlcb.add(new CongNhan(name,sex,address,age,bac));
                            break;

                        case 2:
                            System.out.print("Nhập ngành đào tạo:");
                            String major = sc.nextLine();
                            qlcb.add(new KySu(name,sex,address,age,major))

                    }
            }
        }

    }
}