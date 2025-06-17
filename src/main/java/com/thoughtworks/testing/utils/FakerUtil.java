package com.thoughtworks.testing.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerUtil {

    public String getFakeName(){
        return Faker.instance(Locale.ENGLISH).name().firstName();
    }

    public String getFakeJobTitle(){
        return Faker.instance(Locale.ENGLISH).job().title();
    }
}
