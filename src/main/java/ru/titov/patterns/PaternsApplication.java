package ru.titov.patterns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.titov.patterns.creation.builder.DemoB;
import ru.titov.patterns.creation.factory.Bulb;
import ru.titov.patterns.creation.factory.DemoFactory;
import ru.titov.patterns.creation.factory.DemoType;
import ru.titov.patterns.creation.prototype.DemoPrototype;
import ru.titov.patterns.creation.singleton.DemoSingleton;
import ru.titov.patterns.structural.adapter.Postman;
import ru.titov.patterns.structural.adapter.PostmanAdapter;
import ru.titov.patterns.structural.bridge.AutoIron;
import ru.titov.patterns.structural.bridge.AutoLaundress;
import ru.titov.patterns.structural.bridge.ManualIron;
import ru.titov.patterns.structural.bridge.ManualLaundress;
import ru.titov.patterns.structural.decorator.Delivery;
import ru.titov.patterns.structural.decorator.Order;
import ru.titov.patterns.structural.facade.FacadeLaundress;
import ru.titov.patterns.structural.proxy.BonusProxy;
import ru.titov.patterns.test.TestFibonachi;
import ru.titov.patterns.test.finality.FinalityTest;
import ru.titov.patterns.test.pecs.Child;
import ru.titov.patterns.test.pecs.Grandson;
import ru.titov.patterns.test.pecs.Parent;
import ru.titov.patterns.test.pecs.Top;

import java.util.Arrays;
import java.util.List;
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
        //facade
        new FacadeLaundress(new ManualLaundress(new ManualIron()), new AutoLaundress(new ManualIron())).wash("Пиджак");

        new TestFibonachi().getList(10);
        log.info(String.valueOf(new TestFibonachi().getResult(false, false)));

        /// pecs
        Top top = new Top();
        Parent parent = new Parent();
        Child child = new Child();
        Grandson grandson = new Grandson();

        List<Top> tops = Arrays.asList(top);
        List<Parent> parents = Arrays.asList(parent);
        List<Child> childs = Arrays.asList(child);
        List<Grandson> grandsons = Arrays.asList(grandson);


//        parent.takeAll(tops);
//        parent.takeAll(parents);
//        parent.takeAll(childs);
        parent.takeAll(grandsons);


//        child.takeMany(tops);
        child.takeMany(parents);
        child.takeMany(childs);
//        child.takeMany(grandsons);
        Parent parent1 = new Child();
//        Parent parent2 = (Parent) new Top();

        //Exception finally
        try {
            FinalityTest.test();
        } catch (Throwable e) {
            log.info("supressed errors message");
            Throwable[] throwables = e.getSuppressed();
            Arrays.stream(throwables).forEach(throwable -> log.info("---->{}", throwable.getMessage()));
            log.info("main error");
            log.info(e.getMessage());
        }
    }


}
