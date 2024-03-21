package com.estsoft.blog.oreumi4_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing     // created_at, updated_at 자동 업데이트
@SpringBootApplication
public class Oreumi4BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oreumi4BlogApplication.class, args);
    }

}
