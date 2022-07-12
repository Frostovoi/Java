package Patterns.SmartParking;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class MemoryLoader implements TariffLoader {

    @Override
    public ArrayList<Tariff> load() {
        Tariff tariff1 = new Tariff(15,new BigDecimal(0));
        Tariff tariff2 = new Tariff(60,new BigDecimal(50));
        Tariff tariff3 = new Tariff(120,new BigDecimal(100));
        Tariff tariff4 = new Tariff(180,new BigDecimal(140));
        Tariff tariff5 = new Tariff(240,new BigDecimal(180));
        Tariff tariff6 = new Tariff(Integer.MAX_VALUE,new BigDecimal(350));
        return new ArrayList<>(Arrays.asList(tariff1,tariff2,tariff3,tariff4,tariff5,tariff6));
    }
}
