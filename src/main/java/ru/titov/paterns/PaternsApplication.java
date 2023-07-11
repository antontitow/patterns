package ru.titov.paterns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.titov.paterns.creation.builder.DemoB;
import ru.titov.paterns.creation.prototype.DemoPrototype;
import ru.titov.paterns.creation.singleton.DemoSingleton;
import ru.titov.paterns.creation.factory.Bulb;
import ru.titov.paterns.creation.factory.DemoFactory;
import ru.titov.paterns.creation.factory.DemoType;

@SpringBootApplication
@Slf4j
public class PaternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaternsApplication.class, args);

        DemoSingleton demoSingleton = DemoSingleton.getInstance();
        DemoSingleton demoSingleton2 = DemoSingleton.getInstance();
        log.info(String.valueOf(demoSingleton == demoSingleton2));

        DemoFactory demoFactory = new DemoFactory();
        Bulb bulb = demoFactory.getBuld(DemoType.DIODE);
        bulb.shine();

        DemoB demoB = new DemoB.DemoBBuilder().setName("Tony").setSurname("Titov").build();
        log.info(demoB.getName());

        DemoPrototype demoPrototype1 = new DemoPrototype();
        DemoPrototype demoPrototype2 = (DemoPrototype) demoPrototype1.copy();
        demoPrototype1.setAuthor("Cesar");
        DemoPrototype demoPrototype3 = (DemoPrototype) demoPrototype2.copy();
        demoPrototype3.setAddress("New York");
        log.info(demoPrototype3.toString());

    }

}
