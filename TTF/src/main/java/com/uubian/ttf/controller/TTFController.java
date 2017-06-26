package com.uubian.ttf.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.idst.nls.NlsFuture;
import com.uubian.ttf.logic.TTSDemo;


@RestController()
@RequestMapping("/ttf")
public class TTFController {

	@GetMapping("/test/{filename}")
	public void getAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		OutputStream out = response.getOutputStream();
		//PrintWriter out = response.getWriter();
		TTSDemo tts = new TTSDemo();
		NlsFuture future = tts.startTTS();
        int total_len = 0;
        byte[] data ;
        while((data = future.read()) != null) {
        	out.write(data, 0, data.length);
            total_len += data.length;
            System.out.println("tts length " + data.length);
        }
	}

}
