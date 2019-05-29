package lyh.SIMS.database;

import java.util.Vector;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentData sd = new StudentData();
		Vector x = sd.getByName("李一宏");
		Vector y=(Vector)x.get(0);
		Vector y2=(Vector)x.get(0);
		Vector z = sd.getByID(10001);
		for(int i = 0;i<6;i++)
			System.out.println(y.get(i));
		for(int i = 0;i<6;i++)
			System.out.println(y2.get(i));
		for(int i = 0;i<6;i++)
			System.out.println(z.get(i));
	}

}
