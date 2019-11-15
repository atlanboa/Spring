package mybatis.product.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.vo.MyProductVO;

/*
 * session.insert()
 * session.selectOne()
 * session.selectList()
 */
public class MyBatisAppTest {

	public static void main(String[] args) throws Exception{
		
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
//		1. Test 클래스
//		--> MyProductAppTest
//		1) 상품등록
//		2) 등록된 모든 상품정보 출력하기
//		3) 세탁기, 세탁...같은 특정한 제품으로 검색하기
//		4) 특정한 상품 삭제하기
//		5) 제품 정보 수정하기
//		로직을 작성한다.
		
		//1. 상품등록
//		System.out.println(":: 1. 상품등록 ");
		MyProductVO vo = new MyProductVO("컴퓨터", "삼성", 2000000);
//		Object obj = session.insert("ProductMapper.addProduct", vo);
//		session.commit();
//		System.out.println(":: 1. addUser(INSERT)  result ? "+obj);
//		System.out.println("\n");
		
		
		//2. 등록된 모든 상품정보 출력하기
		System.out.println(":: 2. 상품 리스트 ");
		List<MyProductVO> list = session.selectList("ProductMapper.getProductList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 상품은 : "+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//3. 세탁기, 세탁.. 같은 특정한 제품 검색
		System.out.println(":: 3. '냉장'  특정 상품 리스트 ");
		vo.setName("냉장");
		list = session.selectList("ProductMapper.findByProductName", vo);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 상품은 : "+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//4. 특정 제품 삭제하기
		System.out.println(":: 4. 특정 제품 삭제");
		vo.setName("컴퓨터");
		int deleteResult = session.delete("ProductMapper.removeProduct", vo);
		session.commit(); //이 부분 반드시 해줘야 한다.
		System.out.println(":: 4. removeProduct(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
		
		//5. 특정 제품 수정하기
		System.out.println(":: 5. 특정 제품 수정");
		
		vo.setName("슈퍼냉장고");
		vo.setId(1);
		int updateResult = session.update("ProductMapper.updateProduct", vo);
		System.out.println(":: 5. updateProduct(UPDATE) result ? "+updateResult);
		System.out.println("\n");

	}
}
