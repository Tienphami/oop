package advance.dev;

class Student {
    String name;
    int age;
    String address;
    String phone;
    double gpa;
    public Student(String name,int age, String address,String phone,double gpa){
        this.name=name;
        this.age=age;
        this.address=address;
        this.phone=phone;
        this.gpa=gpa;
    }
    public String toString(){
        return "name: " + name +"\n age: "+ age +"\n address: "+address +"\n phone: "+ phone +"\n GPA: "+gpa;
    }


}
