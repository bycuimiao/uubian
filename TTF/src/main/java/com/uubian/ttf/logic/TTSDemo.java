package com.uubian.ttf.logic;
import com.alibaba.idst.nls.protocol.NlsResponse;
import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.NlsFuture;
import com.alibaba.idst.nls.event.NlsEvent;
import com.alibaba.idst.nls.event.NlsListener;
import com.alibaba.idst.nls.protocol.NlsRequest;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
public class TTSDemo implements NlsListener {
    public NlsClient client = new NlsClient();
    public String tts_text = "薄雾浓云愁永昼。瑞脑消金兽。佳节又重阳，玉枕纱厨，半夜凉初透。东篱把酒黄昏后。有暗香盈袖。莫道不消魂，帘卷西风，人比黄花瘦。";


    public TTSDemo() {
        System.out.println("init Nls client...");
		// 初始化NlsClient
        client.init();
    }

    public void shutDown() {
        System.out.println("close NLS client");
		// 关闭客户端并释放资源
        client.close();
        System.out.println("demo done");
    }


    public NlsFuture startTTS() {
        File file = new File("D:\\tts.wav");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        NlsRequest req = new NlsRequest();
        String appkey = "nls-service";
        req.setAppKey(appkey); // 设置语音文件格式
        req.setTtsRequest(tts_text); //传入测试文本，返回语音结果
        req.setTtsEncodeType("wav");//返回语音数据格式，支持pcm,wav.alaw
        req.setTtsVolume(30);       //音量大小默认50，阈值0-100
        req.setTtsSpeechRate(0);    //语速，阈值-500~500
        req.setTtsBackgroundMusic(1,0);//背景音乐编号,偏移量
        req.authorize("LTAIAgPByuMOudEq", "TJs9EeKfGl3rzQgU0MdNbzIQeZhK6X"); // 请替换为用户申请到的Access Key ID和Access Key Secret
        try {
            NlsFuture future = client.createNlsFuture(req, this); // 实例化请求,传入请求和监听器
            int total_len = 0;
            
            System.out.println("tts audio file size is :" + total_len);
            future.await(10000); // 设置服务端结果返回的超时时间
            return future;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onMessageReceived(NlsEvent e) {
       
    }

    @Override
    public void onOperationFailed(NlsEvent e) {
    	
    }

    @Override
    public void onChannelClosed(NlsEvent e) {
    	
    }


}