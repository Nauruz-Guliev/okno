package ru.kpfu.itis.gnt.okno.services.notification;//package ru.itis.okno.backend.services.notification;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailSender {
//
//    @Autowired
//    private JavaMailSender sender;
//
//    @Value("${spring.mail.username}")
//    private String username;
//
//    public void sendNotification(String emailTo, String subject, String message){
//        SimpleMailMessage notification = new SimpleMailMessage();
//
//        notification.setFrom(username);
//        notification.setTo(emailTo);
//        notification.setSubject(subject);
//        notification.setText(message);
//
//        sender.send(notification);
//    }
//}
