package com.withsafe;

import com.withsafe.global.util.Aes256;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화
public class DemoApplication {
	public static void main(String[] args) {
//        byte[] arr = new byte[8];
//        new Random().nextBytes(arr);
//        StringBuilder result = new StringBuilder();
//        for (byte temp : arr) {
//            result.append(String.format("%02x", temp));
//        }
//        System.out.println("Bytes to Hex: " + result);
//		SecureRandom secureRandom = new SecureRandom();
//		byte[] keyBytes = new byte[64];
//		secureRandom.nextBytes(keyBytes);
//
//		String secretKey = Base64.getEncoder().encodeToString(keyBytes);
//		System.out.println("Generated 64-byte JWT Secret Key: " + secretKey);
//
//		String wkbHexString = "0101000020E610000000000000008050400000000000004340";
//		byte[] wkb = WKBReader.hexToBytes(wkbHexString);
//		GeometryFactory geometryFactory = new GeometryFactory();
//		WKBReader reader = new WKBReader(geometryFactory);
//
//		try {
//			Point point = (Point) reader.read(wkb);
//			System.out.println("Point: " + point);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Aes256 aes256 = new Aes256();
//		String id = "youngchan";
//		String pwd = "1234";
//		System.out.println("id = " + id);
//		System.out.println("pwdO = " + pwd);
//        try {
//			id = aes256.encrypt(id);
//            pwd = aes256.encrypt(pwd);
//			System.out.println("id = " + id);
//			System.out.println("pwdE = "+ pwd);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        try {
//			id = aes256.decrypt(id);
//            pwd = aes256.decrypt(pwd);
//			System.out.println("id = " + id);
//            System.out.println("pwdD = " + pwd);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        SpringApplication.run(DemoApplication.class, args);
	}

}
