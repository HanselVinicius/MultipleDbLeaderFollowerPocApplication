package com.vinicius.MutipleDbLeaderFollowerPoc;

import org.springframework.boot.SpringApplication;

public class TestMutipleDbLeaderFollowerPocApplication {

	public static void main(String[] args) {
		SpringApplication.from(MultipleDbLeaderFollowerPocApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
