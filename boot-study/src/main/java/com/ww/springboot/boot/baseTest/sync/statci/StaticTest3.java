package com.ww.springboot.boot.baseTest.sync.statci;

/**
 * @author wanwei
 * @TODO   执行顺序：父类优先，静态方法优先，其次才是构造函数
 * @date: 2018年9月27日 下午2:16:03 
 */
public class StaticTest3 extends Base{
	 
    static{
        System.out.println("test static");
    }
     
    public StaticTest3(){
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new StaticTest3();
    }
}
 
class Base{
     
    static{
        System.out.println("base static");
    }
     
    public Base(){
        System.out.println("base constructor");
    }
}
