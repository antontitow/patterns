package ru.titov.patterns.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 23:42
 **/
@Slf4j
public class BonusProxy implements Computer {
    {
        log.info("BonusProxy create");
    }

    private Bonus bonusInstance;

    @Override
    public Integer proccessBonus(Double sum) {
        log.info("invoke BonusProxy.proccessBonus()");
        if (bonusInstance == null) {
            bonusInstance = new Bonus();
        }

        return bonusInstance.proccessBonus(sum);
    }
}
