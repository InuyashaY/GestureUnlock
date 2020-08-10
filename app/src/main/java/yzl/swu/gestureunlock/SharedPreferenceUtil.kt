package yzl.swu.gestureunlock

import android.content.Context

class SharedPreferenceUtil private constructor(){
    private val FILE_NAME = "password"
    private val KEY = "passwordKey"

    companion object{
        private var instance: SharedPreferenceUtil? = null
        private var mContext: Context? = null

        fun getInstance(context: Context): SharedPreferenceUtil{
            mContext = context
            if (instance == null){
                synchronized(this){
                    instance = SharedPreferenceUtil()
                }
            }
            return instance!!
        }
    }

    fun savePassword(pwd: String){
        //获取preference对象
        val sharedPreferences = mContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        //获取edit对象 -> 写数据
        val edit = sharedPreferences?.edit()
        //写入数据
        edit?.putString(KEY,pwd)
        //提交
        edit?.apply()
    }

    fun getPassword(): String?{
        //获取preference对象
        val sharedPreferences = mContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(KEY,null)
    }
}