package com.example.web.model;

public class BaseRequest<T>
{
    private T data;
    private String token;

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

}
