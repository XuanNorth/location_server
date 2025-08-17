package com.example.locationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.sql.Time;
import java.time.Instant;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Repository repository;

    @Autowired
    private DataRepository dataRepository;

    Double longitudeHome =  106.237962;
    Double latitudeHome = 20.181558;

    Double longitudeSchool =  106.291123;
    Double latitudeSchool = 20.199595;

    double range = 5.6;


    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("phxbac909@gmail.com"); // Email người gửi
        mailSender.send(message);
    }

    public void checkLocation( double latitude, double longitude) {

        dataRepository.save(Data.builder().latitude(latitude).longitude(longitude).timestamp(Instant.now()).build());

        double distanceToHome = repository.calculateDistance(latitude, longitude, latitudeHome, longitudeHome);
        double distanceToSchool = repository.calculateDistance(latitude, longitude, latitudeSchool, longitudeSchool);

        double totalDistance = distanceToHome + distanceToSchool;

        System.out.println("distanceToHome: " + distanceToHome);
        System.out.println("distanceToSchool: " + distanceToSchool);

        if (totalDistance < 2 * range) {
            sendSimpleEmail("phamnamthang1978@gmail.com","Nằm ngoài vùng phủ sóng","Vị trí hiện tại : https://www.google.com/maps?q="+latitude+","+longitude);
            sendSimpleEmail("fileinput.txt@gmail.com","Nằm ngoài vùng phủ sóng","Vị trí hiện tại : https://www.google.com/maps?q="+latitude+","+longitude);
            System.out.println("Send to user successfully !");
        }
    }

}
