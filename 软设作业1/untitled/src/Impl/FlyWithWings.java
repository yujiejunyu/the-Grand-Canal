package Impl;

import Service.FlyBehavious;

public class FlyWithWings implements FlyBehavious {
    @Override
    public void fly() {
        System.out.println("飞在空中");
    }
}
