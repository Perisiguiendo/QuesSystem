package com.winter.controller;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author persiguiendo
 */
@Controller
@RequestMapping("/sendmail")
public class SendMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * @param queid
     * @return string
     *
     */
    @RequestMapping("/controll")
    public String showSendPage(Integer queid, Model model) {
        System.out.println("id为" + queid);
        model.addAttribute("id", queid);
        return "send";
    }

    /**
     * @param persons,title,text
     * @return String
     * @throws MessagingException
     *             String
     */
    @RequestMapping("/test")
    public String sendSimpleMail(String persons, String title, String text, Model model) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(title);
        System.out.println(text);
        String[] str = persons.split("@");
        for(int i=0;i<str.length;i++){
            str[i] += "@qq.com";
            try {
                message.setFrom("1987391831@qq.com");
                message.setTo(str[i]);
                message.setSubject(title);
                message.setText(text);
                System.out.println(message);
                javaMailSender.send(message);
                System.out.println("send ok");
                String msg = "发送成功！";
                model.addAttribute("msg", msg);
            } catch (Exception e) {
                String msg = "发送失败！";
                model.addAttribute("msg", msg);
            }
        }
        return "send";
    }
}
