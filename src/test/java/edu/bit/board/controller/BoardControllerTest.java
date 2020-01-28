package edu.bit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.bit.board.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
		
	@Test
	public void test() throws Exception{
		this.mockMvc.perform(get("/"))
		.andDo(print())                              // .andDO : �슂泥��뿉 ���븳 泥섎━, print()媛� �씪諛섏쟻
		.andExpect(status().isOk())                 //.andExpect : �삁�긽媛믪쓣 寃�利앺븳�떎.
		.andExpect(model().attributeExists("serverTime"))
		.andReturn();                                //.andReturn : �뀒�뒪�듃 �겢�옒�뒪�뿉�꽌 �옉�꽦�� �븞�뻽吏�留� �뀒�뒪�듃 �븳 寃곌낵 媛앹껜瑜� 諛쏆쓣 �븣 �궗�슜

	}

/*	@Test
	public void helloTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/"))
	         .andExpect(MockMvcResultMatchers.status().isOk());
	}*/
	


}
