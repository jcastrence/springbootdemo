package com.example.demo.address;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AddressConfig {

    @Bean
    CommandLineRunner commandLineRunner(AddressRepository repository) {
        return args -> {
            Address addr1 = new Address(
                    "34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo",
                    "Alice"
            );
            Address addr2 = new Address(
                    "bc1qgdjqv0av3q56jvd82tkdjpy7gdp9ut8tlqmgrpmv24sq90ecnvqqjwvw97",
                    "Bob"
            );
            Address addr3 = new Address(
                    "bc1ql49ydapnjafl5t2cp9zqpjwe6pdgmxy98859v2",
                    "Charlie"
            );
            repository.saveAll(List.of(addr1, addr2, addr3));
        };
    }

}
