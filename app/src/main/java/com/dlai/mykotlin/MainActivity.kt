package com.dlai.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//1，AppCompatActivity后面的括号其实相当于java中的无参构造器
class MainActivity : AppCompatActivity() {
    //2，属性为什么要求初始化呢？因为 Kotlin 的变量是没有默认值的
     lateinit var view : View

    //3，kotlin 有空安全的设计 也就是相当于说在代码层面就能杜绝大部分空指针 直接报错了比如
    var str : String? = null
    /**
     * 再类型后面加？ 就可以让当前的变量初始值为空， 也就是告诉编译器  你这个值可以为空
     * 也就是相当于java变量了， 当你传递这个可空对象的时候 接收端也要是可空的 比如函数参数
     *也就是当这个null为有意义的时候 就可以 使用这个可空对象
     * 相当于java的 if（null!=x）{ x.invoke}
     * 等价于kotlin的 x?.invoke
     * 并且这个操作是线程安全的
     */
    //4.类型推断 也就是你定义的类型

    //5，只读变量val 类似java中final int
    val cc : Int =1





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

//6，java函数 public int invokeFun(String name){ return 1}
   fun invoke(name:String):Int{ return 1 }

    //7， getter setter

    //kotlin默认支持get set， 但是如果有特殊的需求 比如修改get返回的结果则需要重写get（）如下

    inner class  User(){


        var name : String = "Mike"

        get(){
            return field+"and me"
        }

        set(str){
            field= "me and $str"
        }
        var age :Int = 3
            get(){
                return field+1
            }

            set(i){
                field= i+10
            }


    }
    




}
