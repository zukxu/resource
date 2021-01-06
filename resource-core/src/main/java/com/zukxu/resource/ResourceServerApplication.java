package com.zukxu.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zukxu
 */
@SpringBootApplication
public class ResourceServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
		System.out.println("" +
				"______  _   _   _   _   __    __  _   _  \n" +
				"|___  / | | | | | | / /  \\ \\  / / | | | | \n" +
				"   / /  | | | | | |/ /    \\ \\/ /  | | | | \n" +
				"  / /   | | | | | |\\ \\     }  {   | | | | \n" +
				" / /__  | |_| | | | \\ \\   / /\\ \\  | |_| | \n" +
				"/_____| \\_____/ |_|  \\_\\ /_/  \\_\\ \\_____/ ");

	}
}
