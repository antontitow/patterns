package ru.titov.paterns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.titov.paterns.creation.builder.DemoB;
import ru.titov.paterns.creation.factory.Bulb;
import ru.titov.paterns.creation.factory.DemoFactory;
import ru.titov.paterns.creation.factory.DemoType;
import ru.titov.paterns.creation.prototype.DemoPrototype;
import ru.titov.paterns.creation.singleton.DemoSingleton;
import ru.titov.paterns.structural.adapter.Postman;
import ru.titov.paterns.structural.adapter.PostmanAdapter;
import ru.titov.paterns.structural.bridge.AutoIron;
import ru.titov.paterns.structural.bridge.AutoLaundress;
import ru.titov.paterns.structural.bridge.ManualIron;
import ru.titov.paterns.structural.bridge.ManualLaundress;
import ru.titov.paterns.structural.decorator.Delivery;
import ru.titov.paterns.structural.decorator.Order;
import ru.titov.paterns.structural.proxy.BonusProxy;

import java.util.Map;

@SpringBootApplication
@Slf4j
public class PaternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaternsApplication.class, args);

        /////creation
        //singleton
        DemoSingleton demoSingleton = DemoSingleton.getInstance();
        DemoSingleton demoSingleton2 = DemoSingleton.getInstance();
        log.info(String.valueOf(demoSingleton == demoSingleton2));
        //factory
        DemoFactory demoFactory = new DemoFactory();
        Bulb bulb = demoFactory.getBuld(DemoType.DIODE);
        bulb.shine();
        //builder
        DemoB demoB = new DemoB.DemoBBuilder().setName("Tony").setSurname("Titov").build();
        log.info(demoB.getName());
        //prototype
        DemoPrototype demoPrototype1 = new DemoPrototype();
        DemoPrototype demoPrototype2 = (DemoPrototype) demoPrototype1.copy();
        demoPrototype1.setAuthor("Cesar");
        DemoPrototype demoPrototype3 = (DemoPrototype) demoPrototype2.copy();
        demoPrototype3.setAddress("New York");
        log.info(demoPrototype3.toString());

        /////////structural
        //proxy
        log.info(new BonusProxy().proccessBonus(123.45).toString());
        //adapter
        new PostmanAdapter(Postman.builder().name("Oleg").build()).send("Moscow");
        //decorator
        Order orderCar = new Order(1000.00, Map.of("DashCam", 2.0, "Conditioner", 500.00));
        log.info(orderCar.sum().toString());
        Delivery delivery = new Delivery(orderCar);
        log.info(delivery.sum().toString());
        //bridge
        new AutoLaundress(new ManualIron()).wash("Одеяло");
        new AutoLaundress(new AutoIron()).wash("Полотенце");
        new ManualLaundress(new ManualIron()).wash("Рубашка");

    }

}
