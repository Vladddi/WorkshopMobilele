package bg.softuni.mobilele.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class MobileleConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){

       return new AbstractPasswordEncoder() {
           @Override
           protected byte[] encode(CharSequence rawPassword, byte[] salt) {
               return new byte[0];
           }
       };
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
