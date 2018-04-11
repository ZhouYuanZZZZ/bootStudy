package com.zy.study.bootstudy;

import com.zy.study.bootstudy.aspect.AspectService;
import com.zy.study.bootstudy.entity.City;
import com.zy.study.bootstudy.mapper.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootstudyApplicationTests {

	@Resource
	private CityMapper cityMapper;

	@Resource
	private AspectService aspectService;

	@Test
	public void contextLoads() {
		List<City> cities = cityMapper.selectByExample(null);
		System.out.println(cities.size() );
	}

	@Test
	public void testAop01(){
		aspectService.testAop01();
	}

	@Test
	public void testAop02(){
		aspectService.testAop02();
	}

	@Test
	public void testAop03(){
		aspectService.testAop03();
	}

	@Test
	public void testAop04(){
		aspectService.testAop04("zzz");
	}

}
