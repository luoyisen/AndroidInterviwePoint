package yincheng.androidinterviwepoint.module.designpattern.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:09
 * Github : yincheng.luo
 */

public enum Weapon {

    DAGGER, SWORD, AXE, WARHAMMER, BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
