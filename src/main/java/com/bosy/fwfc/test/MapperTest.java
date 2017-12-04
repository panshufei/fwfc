package com.bosy.fwfc.test;
import com.bosy.fwfc.dao.DealerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {

  @Autowired
  DealerMapper dealerMapper;
  @Test
  public void test(){

}

//	@Test
//	public void test(){
//		//批量插入的方法
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for (int i = 0; i < 1000; i++) {
//			mapper.insertSelective(new Employee(null,"1","1","2",4));
//		}
//		System.out.println("11");
//
//	}

}
