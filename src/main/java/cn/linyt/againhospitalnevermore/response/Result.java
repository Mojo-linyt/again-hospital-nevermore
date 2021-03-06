package cn.linyt.againhospitalnevermore.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @ClassName Result
 * @Description TODO    统一响应结果集
 * @Author Mojo
 * @Date 2020/4/14 5:09
 * @Version 1.0
 **/
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {

    //操作代码
    int code;

    //提示信息
    String message;

    //结果数据
    T data;

    public Result(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result(String message){
        this.message = message;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result SUCCESS(T data){
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }

    public static Result FAIL(String message){
        return new Result(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
