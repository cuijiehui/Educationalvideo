package com.example.educationalvideo.network.gson

import android.util.MalformedJsonException
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.TypeAdapter
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Converter
import java.lang.RuntimeException

/**
 * @author cui
 * @data 2020/4/22
 * Description:
 * 自定义的类型解析器
 * <p>用来对付不安常理出牌的后台数据格式</p>
 */
class CustomResponseConverter<T>(gson :Gson,adapter: TypeAdapter<T>) : Converter<ResponseBody,T>{
   lateinit var adapter:TypeAdapter<T>
    lateinit var gson: Gson
    val TAG = "CustomResponseConverter"

    override fun convert(value: ResponseBody): T? {
        try {
            var body = value.string()
            var jsonObject = JSONObject(body)
            return adapter.fromJson(body)
        }catch (e : JsonSyntaxException ){
            e.printStackTrace()
            throw RuntimeException("数据解析错误")
        }catch (e : MalformedJsonException){
            e.printStackTrace()
            throw RuntimeException("数据解析错误")
        }catch (e : JSONException ){
            e.printStackTrace()
            throw RuntimeException("数据解析错误")
        }finally {
            value.close()
        }
    }
}