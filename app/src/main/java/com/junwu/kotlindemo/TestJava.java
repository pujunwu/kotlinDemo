package com.junwu.kotlindemo;

import com.junwu.kotlindemo.abstractkot.AbstractImp;
import com.junwu.kotlindemo.getsetkot.GetSetKot;
import com.junwu.kotlindemo.interfacekot.InterfaceImp;
import com.junwu.kotlindemo.multiplekt.MultipleKot;
import com.junwu.kotlindemo.rangeskt.RangesKot;
import com.junwu.kotlindemo.singletonkt.SingletonKot;
import com.junwu.kotlindemo.singletonkt.SingletonParKot;
import com.junwu.kotlindemo.typekt.TypeKot;

/**
 * ===============================
 * 描    述：测试类
 * 作    者：pjw
 * 创建日期：2017/9/22 17:02
 * ===============================
 */
public class TestJava {

    public static void main(String[] args) {
        InterfaceImp interfaceImp = new InterfaceImp();
        AbstractImp abstractImp = new AbstractImp(15);
        GetSetKot getSetKot = new GetSetKot(5);
        SingletonParKot singletonParKot = SingletonParKot.Companion.getInstance("初始化传入的参数");

        showMessage("当前打印的是：" + interfaceImp.getStr());
        showMessage("测试循环打印，看控制台");
        interfaceImp.funA(new int[]{1, 2, 3, 4, 5});

        showMessage("当前打印的是：" + abstractImp.getAddress());
        showMessage("测试循环打印，看控制台");
        abstractImp.funExample1();
        showMessage("break 和 continue，看控制台");
        abstractImp.funContinue();
        abstractImp.funBreak();
        getSetKot.setAddress("3223423e");
        showMessage("备用字段" + getSetKot.getAddress());

        getSetKot.setAddress(null);
        showMessage("备用字段为空打印结果:" + getSetKot.getAddress());

        showMessage("单例改变前的值：" + SingletonKot.Companion.getINSTANCE().getB());
        SingletonKot.Companion.getINSTANCE().setB("改变后的值");
        showMessage("单例改变后的值：" + SingletonKot.Companion.getINSTANCE().getB());
        showMessage("初始化传入的参数：" + singletonParKot.getParamStr());
        singletonParKot.setParamStr("重新传入的参数");
        showMessage("参数2：" + singletonParKot.getParamStr());

        showMessage("多重声明，查看控制台：");
        new MultipleKot().testMultiple();

        showMessage("Ranges表达式测试，查看控制台：");
        new RangesKot().rangesTest();

        showMessage("类型检查和转换，查看控制台：");
        new TypeKot().typeTest();
    }

    private static void showMessage(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        System.out.println(msg);
    }

}
