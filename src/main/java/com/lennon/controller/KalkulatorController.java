package com.lennon.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lennon.model.Kalkulator;
import com.lennon.service.KalkulatorService;

@Controller
public class KalkulatorController {
	
	@Autowired
	private KalkulatorService kalkulatorService;
	
	@ResponseBody
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String helloService(){
		return "Hello";
	}
	
	@RequestMapping(value="/pdf", produces="application/pdf")
	public void pdfMethod(HttpServletRequest request, HttpServletResponse response){
	    response.setContentType("application/pdf");
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    try{
	        inputStream = getInputStreamFromYourPdfFile();
	        outputStream = response.getOutputStream();
	        IOUtils.copy(inputStream, outputStream);
	    }catch(IOException ioException){
	        //Do something or propagate up..
	    }finally{
	        IOUtils.closeQuietly(inputStream);
	        IOUtils.closeQuietly(outputStream);
	    }
	}
	
	@ResponseBody
	@RequestMapping(value="/calc", method=RequestMethod.GET)
	public Integer count(){
		kalkulatorService.count(new Kalkulator(), "");
		return null;
	}
	
	private InputStream getInputStreamFromYourPdfFile() throws FileNotFoundException {
		return new FileInputStream("H:\\postgres-single-A4.pdf");
	}
	
}
