package com.example.educationalvideo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method


/**
 * @author cui
 * @data 2020/5/18
 * Description: sp 工具类
 */
class SPUtil(context: Context) {
    private var context :Context =context.applicationContext
    private var mPrefFileName ="com.cui.educational.video"
    init {

    }

    companion object{
        private var INSTANCE : SPUtil ?= null

        fun init(context: Context):SPUtil?{
            if (INSTANCE==null) {
                synchronized(SPUtil::class.java){
                    if (INSTANCE==null) {
                        INSTANCE = SPUtil(context)
                    }
                }
            }
            return INSTANCE
        }

        fun getInstance():SPUtil?{
            if (INSTANCE==null) {
                throw NullPointerException("you show invoke SPUtil.init() before you use it")
            }
            return INSTANCE
        }
    }

    fun getSharePreferences():SharedPreferences{
        return context.getSharedPreferences(mPrefFileName,Context.MODE_PRIVATE)
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param key String
     * @param any Any
     */
    @SuppressLint("CommitPrefEdits")
    fun put(key:String, any: Any ){
        var sp = getSharePreferences()
        var edit = sp.edit()
        if (any is String) {
            edit.putString(key,any)
        }else if (any is Int){
            edit.putInt(key,any)
        }else if (any is Boolean){
            edit.putBoolean(key,any)
        }else if (any is Float){
            edit.putFloat(key,any)
        }else if (any is Long){
            edit.putLong(key,any)
        }else{
            edit.putString(key,any.toString())
        }
        SharedPreferencesCompat.apply(edit)
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param key String
     * @param any Any
     * @return Any?
     */
    fun get(key: String,any: Any):Any?{
        var sp = getSharePreferences()
        if (any is String) {
            return sp.getString(key,any)
        }else if (any is Int){
            return sp.getInt(key,any)
        }else if (any is Boolean){
            return sp.getBoolean(key,any)
        }else if (any is Float){
            return sp.getFloat(key,any)
        }else if (any is Long){
            return sp.getLong(key,any)
        }
        return null
    }

    /**
     * 移除某个key值对应的值
     * @param key String
     */
    fun remove(key:String){
        val sp = getSharePreferences()
        val edit = sp.edit()
        edit.remove(key)
        SharedPreferencesCompat.apply(edit)
    }

    /**
     * 清除所有数据
     */
    fun clear(){
        val sp = getSharePreferences()
        val edit = sp.edit()
        edit.clear()
        SharedPreferencesCompat.apply(edit)
    }

    /**
     * 查询某个key是否存在
     * @param key String
     * @return Boolean
     */
    fun contains(key: String):Boolean{
        val sp = getSharePreferences()
        return sp.contains(key)
    }

    /**
     * 获取所有的键值对
     * @return Map<String,*>
     */
    fun getAll():Map<String,*>{
        val sp = getSharePreferences()
        return sp.all
    }

    class SharedPreferencesCompat{
        companion object{
            final var sApplyMethod = findApplyMethod()
            fun findApplyMethod():Method?{
                try {
                    var clazz = SharedPreferences.Editor::class.java
                    return clazz.getMethod("apply")
                }catch (e:NoSuchMethodException){
                    e.printStackTrace()
                }
                return null
            }

            fun apply(editor: SharedPreferences.Editor){
                try {
                    sApplyMethod!!.invoke(editor)
                }catch (e :IllegalArgumentException ){
                    e.printStackTrace()
                }catch (e:IllegalAccessException ){
                    e.printStackTrace()
                }catch (e:InvocationTargetException ){
                    e.printStackTrace()
                }
                    editor.commit()
            }

        }
    }
}