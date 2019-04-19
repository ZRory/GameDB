package vip.rory.gamedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "vip.rory.gamedb.mapper")
public class GameDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameDbApplication.class, args);
	}
}
