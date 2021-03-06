package controllers;

import entities.CCar;
import entities.CPlane;
import entities.CShip;
import enums.AirDistance;
import enums.Fuel;
import enums.TransmissionVariety;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainСontroller {
    public static void main(String[] args) throws IOException {
        VehicleController dao = new VehicleController();
        dao.save(new CPlane.AirBuilder().price(190000).year(2013).
                speed(130).x(22).y(1).engine(new CPlane.AirEngine(Fuel.A98, AirDistance.HIGH))
                .capacity(300).height(5200).build());
        dao.save(new CPlane.AirBuilder().price(1240000).year(2017).
                speed(340).x(2).y(11).engine(new CPlane.AirEngine(Fuel.A98, AirDistance.VERY_HIGH))
                .capacity(600).height(7700).build());
        dao.save(new CCar.CarBuilder().price(45000).year(2016).
                speed(190).x(22).y(31).engine(new CCar.CarEngine(Fuel.A95, 310)).
                transmission(new CCar.Transmission(TransmissionVariety.AUTOMATIC))
                .build());
        dao.save(new CCar.CarBuilder().price(135000).year(2015).
                speed(300).x(23).y(41).engine(new CCar.CarEngine(Fuel.ELECTRIC, 600)).
                transmission(new CCar.Transmission(TransmissionVariety.VARIATOR))
                .build());
        dao.save(new CCar.CarBuilder().price(15000).year(2007).
                speed(90).x(22).y(31).engine(new CCar.CarEngine(Fuel.DIESEL, 310)).
                transmission(new CCar.Transmission(TransmissionVariety.AUTOMATIC))
                .build());
        dao.save(new CShip.ShipBuilder().price(300000).year(2008).speed(70).x(3).y(13).
                engine(new CShip.ShipEngine(Fuel.DIESEL, 20000))
                .capacity(300).portOfRegistration("Odessa").build());
        dao.save(new CShip.ShipBuilder().price(2200000).year(2017).speed(210).x(11).y(7).
                engine(new CShip.ShipEngine(Fuel.A98, 40000))
                .capacity(400).portOfRegistration("Florida").build());
        dao.save(new CShip.ShipBuilder().price(10000).year(2003).speed(210).x(2).y(1).
                engine(new CShip.ShipEngine(Fuel.A95, 2000))
                .capacity(20).portOfRegistration("Dallas").build());
        dao.save(new CShip.ShipBuilder().price(1300000).year(2016).speed(190).x(9).y(2).
                engine(new CShip.ShipEngine(Fuel.A98, 42000))
                .capacity(450).portOfRegistration("Cuba").build());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MenuController menuController = new MenuController(dao);
        int decision;
        menuController.showMenu();
        while (true) {
            decision = Integer.parseInt(reader.readLine());
            switch (decision) {
                case 1:
                    menuController.task1();
                    break;
                case 2:
                    menuController.task2();
                    break;
                case 3:
                    menuController.task3();
                    break;
                case 4:
                    menuController.task4();
                    break;
                case 5:
                    menuController.quit();
                    break;
                default:
                    System.out.println("Please enter 1 - 5");
            }
        }

    }
}
