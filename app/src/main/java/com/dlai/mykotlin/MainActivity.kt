package com.dlai.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

/**
 * kotlin的空安全以及一些常用变量基础
 */

//1，AppCompatActivity后面的括号其实相当于java中的无参构造器
class MainActivity : AppCompatActivity() {
    //2，属性为什么要求初始化呢？因为 Kotlin 的变量是没有默认值的
    //这个 lateinit 的意思是：告诉编译器我没法第一时间就初始化，但我肯定会在使用它之前完成初始化的。
    //它的作用就是让 IDE 不要对这个变量检查初始化和报错。换句话说，加了这个 lateinit 关键字，这个变量的初始化就全靠你自己了，编译器不帮你检查了。
    //也就是可以再Oncreate里初始化了
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
    //判断类型 和 强制转换 判断类型用 is  强转用as
    /**java
     *   void Test(){
        if ( TextView instanceof view) {
        ((TextView) view).setText("");
        }
        }
     kotlin 判断类型
     */
    fun Test(view :View){
        if (view is TextView){
            view.text = "11"
        }
    }
    //也可以跟java一样强转
    fun Test1(view :View){
        (view as TextView).text = "11"
    }


    /**
     *  view as? TextView
        view as TextView?
        view as? TextView?
     */

    //以上三种分别在什么情况下适用 !!代表开发者认为一定不是空 让编译器不用检查   暂时没有看出来什么意思

    fun Test2(view :View?){
        (view as? TextView)!!.text = "11"
        (view as TextView?)!!.text = "11"
        (view as? TextView?)!!.text = "11"
    }





    




}
