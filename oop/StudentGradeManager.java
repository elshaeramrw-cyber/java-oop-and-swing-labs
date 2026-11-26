import java.util.ArrayList;
import java.util.Arrays;

class student {
    String name;
    double grade;
    public student(String name,double grade){
        this.name=name;
        this.grade=grade;
    }
    void displayInfo(){
        System.out.println("student name is " +name +" " +"grade is "+grade ); 
    }
    static void calculateAverage (ArrayList <student> list){
        double addition=0;
        for (int i=0; i<list.size();i++){
           addition+=list.get(i).grade;
        } 
        double avg=addition/list.size();
        System.out.println("Average grade: " + avg);
    }
    
}
void main(){
    student[] objects=new student[3];
    objects[0]=new student("whad", 88.8);
    objects[1]=new student("thnain", 58.11);
    objects[2]=new student("thalath", 68.57);
    for(int i=0;i<objects.length;i++){
        objects[i].displayInfo();
    }
    ArrayList <student> studentList= new ArrayList<>(Arrays.asList(objects));
    studentList.add(new student("arbaaa", 91.18));
    for(int i=0;i<studentList.size();i++){
        studentList.get(i).displayInfo();
    }
    studentList.remove(0);
    for(int i=0;i<studentList.size();i++){
        studentList.get(i).displayInfo();
    }
    student.calculateAverage(studentList);
}