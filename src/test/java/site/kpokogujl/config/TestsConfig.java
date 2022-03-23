package site.kpokogujl.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface TestsConfig extends Config {

    String browserstackLogin();
    String browserstackPassword();


    String browsesrstackUrl();
    String appUrl();

}
