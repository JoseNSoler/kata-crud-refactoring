package co.com.sofka.crud;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CrudConfiguration {

    // Custom Validator for classes and classesObject
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
