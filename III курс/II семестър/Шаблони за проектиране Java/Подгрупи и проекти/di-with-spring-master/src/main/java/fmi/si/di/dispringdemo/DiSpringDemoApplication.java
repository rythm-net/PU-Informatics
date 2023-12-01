package fmi.si.di.dispringdemo;

import fmi.si.di.dispringdemo.processors.MessageProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DiSpringDemoApplication implements CommandLineRunner {
    private final MessageProcessor messageProcessor;

    public static void main(String[] args) {
        SpringApplication.run(DiSpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        messageProcessor.processMessage("Hello World", "ivan.ivanov@uni-plovdiv.bg");
    }
}
