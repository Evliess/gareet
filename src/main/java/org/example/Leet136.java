package org.example;
//任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
//任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
//异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b


//位运算： 判断奇偶性 isOdd = num & 1
//或运算： [设置特定位] data=0b100 data|00001 = 0b101 [合并权限] rw = read|write
//异或或运算：加解密 data^key^key = data
//

public class Leet136 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
