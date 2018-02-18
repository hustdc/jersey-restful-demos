package caiweiwei.com.cn.json;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyJaxbBean {
	 public String name;
	 public int age;
	 
	 public MyJaxbBean() {}
	 
	 public MyJaxbBean(String name, int age) {
	     this.name = name;
	     this.age = age;
	 }
	 
     public String getName() {
    	 return name;
     }
     public void setName(String name) {
    	 this.name = name;
     }
     
     public int getAge() {
    	 return age;
     }
     
     public void setAge(int age) {
    	 this.age = age;
     }
}
