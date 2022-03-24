package site.kpokogujl.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/${device}.properties",
                "classpath:config/credentials.properties"})
public interface MobileConfig extends Config {

    @Key("device.name")
    String deviceName();

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @Key("browserstackUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String browserstackUrl();

    @Key("appUrl")
    @DefaultValue("bs://f4efb73c4ef8c04d8e460e4fbdd272bd44bb2e26")
    String appUrl();

    @Key("device")
    @DefaultValue("emulator")
    String device();

    String browserstackLogin();
    String browserstackPassword();

}
