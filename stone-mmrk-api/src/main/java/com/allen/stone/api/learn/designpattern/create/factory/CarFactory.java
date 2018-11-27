package com.allen.stone.api.learn.designpattern.create.factory;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/2 19:28
 **/
public class CarFactory {

    public static CarFactory getInstance() {
        return FactoryEnum.INSTANCE.getInstance();
    }

    private enum FactoryEnum {
        INSTANCE;
        private CarFactory instance;

        FactoryEnum() {
            instance = new CarFactory();
        }

        private CarFactory getInstance() {
            return instance;
        }
    }


    public Car getCar(String className) {
        if ("Train".equals(className)) {
            return new Train();
        } else if ("Taxt".equals(className)) {
            return new Taxt();
        } else if ("Bus".equals(className)) {
            return new Bus();
        } else {
            return null;
        }
    }


    public static void main(String[] args) {

        Car car = CarFactory.getInstance().getCar("Taxt");
        System.out.println(car.getClass().getName());
    }

}
