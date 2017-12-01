package com.zy.study.bootstudy;

import com.sun.deploy.net.HttpResponse;
import com.zy.study.bootstudy.properties.PropertiesTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	public static void main(String[] args) {
		SpringApplication.run(BootstudyApplication.class, args);
	}


	@RequestMapping("helloWorld")
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
		for (int i = 0; i <10 ; i++) {
			list.add(i+"");
		}

		map.put("user","zzzz");
		map.put("listName",list);

		return "a";
	}
}
