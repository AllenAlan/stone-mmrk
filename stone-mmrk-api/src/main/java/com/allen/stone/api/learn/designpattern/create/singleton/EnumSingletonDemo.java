package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.Recommend;
import com.allen.stone.common.annotation.ThreadSafe;

/** 枚举单例模式
 * @author Allen
 * @version V1.0.0
 * @date 2018/10/23 23:50
 */

@ThreadSafe
@Recommend
public class EnumSingletonDemo {

    private EnumSingletonDemo() {
        System.out.println("this is EnumSingletonDemo");
    }

    public static EnumSingletonDemo getInstance() {
        System.out.println("getInstance before");
        return SingletonEnum.INSTANCE.getInstance();
    }

    public enum SingletonEnum {
        INSTANCE;

        private EnumSingletonDemo instance;
        //jvm 保证 该方法绝对只被调用一次
        SingletonEnum() {
            System.out.println("this is SingletonEnum");
            instance = new EnumSingletonDemo();
        }

        public EnumSingletonDemo getInstance() {
            return instance;
        }

    }

    public static void main(String[] args) {
        System.out.println("first println");
        System.out.println(EnumSingletonDemo.getInstance().hashCode());
        System.out.println("second println");
        System.out.println(SingletonEnum.INSTANCE.getInstance().hashCode());
    }

}
