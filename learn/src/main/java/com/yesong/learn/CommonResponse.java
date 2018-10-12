package com.yesong.learn;

import java.util.List;

public class CommonResponse<T> {
    private List<T> listResponse;
    private T infoResponse;

    public CommonResponse() {
    }

    public List<T> getListResponse() {
        return listResponse;
    }

    public void setListResponse(List<T> listResponse) {
        this.listResponse = listResponse;
    }

    public T getInfoResponse() {
        return infoResponse;
    }

    public void setInfoResponse(T infoResponse) {
        this.infoResponse = infoResponse;
    }
}
