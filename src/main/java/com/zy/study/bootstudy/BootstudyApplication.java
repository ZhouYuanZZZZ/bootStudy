package com.zy.study.bootstudy;

import com.sun.deploy.net.HttpResponse;
import com.zy.study.bootstudy.entity.City;
import com.zy.study.bootstudy.entity.CityExample;
import com.zy.study.bootstudy.mapper.CityMapper;
import com.zy.study.bootstudy.properties.PropertiesTest;
import com.zy.study.bootstudy.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootstudyApplication {

	private static final Logger logger = LoggerFactory.getLogger(BootstudyApplication.class);

	@Resource
	private PropertiesTest propertiesTest;

	@Resource
	private CityMapper cityMapper;

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private CityService cityService;

	public static void main(String[] args) {
		SpringApplication.run(BootstudyApplication.class, args);
	}

	@RequestMapping("testUpdate")
	public String testUpdate() {

		//cityService.modifyCity();
		throw new RuntimeException();
		//return "ok";
	}

	@RequestMapping("testFileDownload")
	public String helloWorld(HttpServletResponse response) throws IOException {

		byte[] data = new byte[]{0b00000001};
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=test.txt");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream;charset=UTF-8");
		OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		outputStream.write(data);
		outputStream.flush();
		outputStream.close();

		return "sucess";
	}

	@RequestMapping("freeMaker")
	public String freeMaker(Map<String,Object> map) throws IOException {
		List<String> list = new ArrayList<>();
		for (int i = 0; i <3 ; i++) {
			list.add(i+"");
		}

		map.put("user","zzzz");
		map.put("listName",list);

		return "a";
	}

	@RequestMapping(value = "city",produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<City> queryCity(){

		List<City> cities = cityMapper.selectByExample(null);
		City city = cities.get(0);
		city.setId(null);

		List<City> cities1 = cities.subList(0, 9);
		return cities1;
	}
}
