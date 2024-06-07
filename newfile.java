import java.util.*;
import java.io.*;
import java.util.stream.*;
import javax.swing.*;

import org.apache.commons.io.FileUtils;

public class newfile {
	void t1(){
		ArrayList<String> al=new ArrayList<>(List.of("1","2","kok3","pip"));
		for(var s:al){
			System.out.println(s);
		}
		//Object[]am = al.toArray();  //ok1
		//String[]am = al.toArray(new String[0]); //ok2
		//String[]am = al.toArray(String[]::new); //ok3
		String[]am = al.stream().toArray(String[]::new);
		for(int n=0;n<am.length;n++) System.out.println(am[n]);		System.out.println("arr size=="+am.length);
		String[]an=Arrays.copyOfRange(am,1,2);
		System.out.println(Arrays.toString(an));
		System.out.println(al.subList(0,2));
		//
		HashMap<String,String> m=new HashMap<>();
		m.put("1","s1");
		m.put("2","s2");
		System.out.println(m.get("2"));
		for(var e:m.entrySet()){
			System.out.println(e.getKey()+" "+e.getValue());
		}
		StringTokenizer st=new StringTokenizer("koko, text 'abc def' ");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		String[]s="koko, pipi".split(" ");
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
		List<String>l=Arrays.asList(s);
		for(var t:l) System.out.println(t);
		//StreamTokenizer stk;
		//Collections;
	}
	void t2(){
		JFrame f=new JFrame("example");
		f.setVisible(true);
	}
	void t3() throws Exception{
		
		FileOutputStream fo = new FileOutputStream("kok.dat");
		DataOutputStream ds = new DataOutputStream(fo);
		ds.writeUTF("тестовая строка");
		ds.writeByte('\n');
		//ds.writeInt(542752);
		ds.writeUTF("строка 2");
		fo.close();
	}
	void t4() throws Exception{
		FileInputStream fi=new FileInputStream("kok.dat");
		Scanner s=new Scanner(fi,"utf-8");
		while(s.hasNextLine()){
			System.out.println(s.nextLine());
		}
		fi.close();
	}
	void t5() throws Exception{
		Stream<String> s=new Scanner(new FileInputStream("kok.dat"),"utf-8").tokens();
		List<String> l=s.collect(Collectors.toList());
		for(var i:l) System.out.println(i);
	}
	void t6(){
		Scanner sc=new Scanner(System.in);
		String v;
		while(!(v=sc.nextLine()).equals("")){
			System.out.println("value:"+v);
		}
	}
	void t7(){
		System.out.println(String.join(",",List.of("v1","v2","v3")));
		System.out.println(String.join(",",new String[]{"m1","m2"}));
	}
	void t8(){
		List<String>l=List.of("s1","s2","s3","p");
		var st=l.stream().filter(s->s.length()>1).map(s->"-"+s);
		//1
		var x=st.collect(Collectors.toList());
		System.out.println(x);//вывод с помощью toString() списка
		
		//2
		//st.forEach(System.out::println);
	
		//3
		//st.peek(System.out::println).collect(Collectors.toList());//без collect не выводит
	}
	void t81(){
		var st=Arrays.stream(new Integer[]{1,2,3,2,1})
		//.map(i->new Integer(i))
		;
		var m=
		st.collect(Collectors.toSet());
		System.out.println(m);
	}
	void t9() throws Exception{//
		/*Properties p=System.getProperties();
		String pv=p.getProperty("java.class.path"),
		       ps=p.getProperty("path.separator");
		System.out.println(pv+"  "+ps);
		System.setProperty("java.class.path",pv+ps+"/storage/9016-4EF8/java/ApacheCommons");*/
		System.out.println(new File(".").getAbsolutePath());
		try{
	    	String s=
	    	FileUtils.readFileToString(new File("/data/user/0/ru.iiec.jvdroid/app_HOME/New folder1/kok.dat"));
	    	System.out.println("File:<"+s+">");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		newfile m=new newfile();
		/*m.t1();
		m.t3();
		m.t4();
		m.t5();
		m.t6();
		m.t7();*/
		m.t8();
		m.t81();
		m.t9();
	}
}