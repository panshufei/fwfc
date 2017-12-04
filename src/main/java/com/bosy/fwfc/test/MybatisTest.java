package com.bosy.fwfc.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


import com.bosy.fwfc.util.Md5;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Test
	public void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(Md5.md5("123"));
	}

}
