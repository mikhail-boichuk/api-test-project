package com.megogo.api.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "scheduleIds", parallel = true)
    public static Object[] scheduleIds() {
        return new Object[] {
                "1639111",
                "1585681",
                "1639231"
        };
    }
}
