package sp02_MyBatis;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.mybatis.vo.MySawonVO;

public class MyBatisClientAppTest{

	public static void main(String[] args) throws Exception {
		//폼에서 값 입력받는거라.. 생각
		
		Scanner sc = new Scanner(System.in);
		MySawonVO vo = new MySawonVO();
		
		System.out.println("아이디 : ");
		vo.setId(sc.next());
		System.out.println("패스워드 : ");
		vo.setPwd(sc.next());
		System.out.println("이름: ");
		vo.setName(sc.next());
		System.out.println("나이: ");
		vo.setAge(sc.nextInt());
		
		//MyBatis 프레임워크가 사용된다.
		//1.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2.
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3.
		
		SqlSession session = factory.openSession();
		
		//4.
		session.insert("insertSawon", vo);//디비에 데이터 입력
		session.commit();
		
		System.out.println("입력 성공!!!");
		
	}

}
