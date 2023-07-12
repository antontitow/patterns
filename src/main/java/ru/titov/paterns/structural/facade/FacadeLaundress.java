package ru.titov.paterns.structural.facade;

import lombok.extern.slf4j.Slf4j;
import ru.titov.paterns.structural.bridge.AutoLaundress;
import ru.titov.paterns.structural.bridge.ManualLaundress;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 2:10
 **/
@Slf4j
public class FacadeLaundress {
    ManualLaundress manualLaundress;
    AutoLaundress autoLaundress;

    public FacadeLaundress(ManualLaundress manualLaundress, AutoLaundress autoLaundress) {
        this.manualLaundress = manualLaundress;
        this.autoLaundress = autoLaundress;
    }

    public void wash(String liner) {
        log.info("запуск всех стирок");
        manualLaundress.wash(liner);
        manualLaundress.wash(liner);
        autoLaundress.wash(liner);
    }
}
