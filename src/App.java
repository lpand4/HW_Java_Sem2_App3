import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
// (Для преподавателя: если не успели выполнить задание 7, дать наводку из этого задания) Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// В теории можно спарсить и строку из примера не меняя на английский язык(Названия всех переменных и методов меняем на русские и работает)

public class App {
    
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/data.json");
        List<Student> dataList = new ArrayList<>();
        dataList = Arrays.asList(mapper.readValue(file, Student[].class));
        for (Student el : dataList) {
            System.out.println(el);
        }
        
    }
}


class Student{
    private String lastName; 
    private String grade;
    private String lesson;
    public Student(){
        
    }

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}
    public String getLesson() {return lesson;}
    public void setLesson(String lesson) {this.lesson = lesson;}

    
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        if(lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if(grade != null ? !grade.equals(student.grade) : student.grade != null) return false;
        return lesson != null ? lesson.equals(student.lesson) : student.lesson == null;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Студент ")
          .append(lastName)
          .append(" получил ")
          .append(grade)
          .append(" по предмету ")
          .append(lesson)
          .append(".");
        return sb.toString();
    }
}
