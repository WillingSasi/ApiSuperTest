package com.example.ApiSuperTest.dto;

public class TemporaryGlobalParam {
    private TemporaryGlobalParam(){};

    private volatile static String fakeId;
    private volatile static String cuId;

    public static String getFakeId() {
        return fakeId;
    }

    public synchronized static void setFakeId(String fakeId) {
        TemporaryGlobalParam.fakeId = fakeId;
    }

    public static String getCuId() {
        return cuId;
    }

    public synchronized static void setCuId(String cuId) {
        TemporaryGlobalParam.cuId = cuId;
    }
}

