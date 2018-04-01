package yincheng.androidinterviwepoint.module.designpattern.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 20:57
 * Github : yincheng.luo
 */

public enum Armor {

    CLOTHES("clothes"), LEATHER("leather"), CHAIN_MAIL("chain_mail"), PLATE_MAIL("plate_mail");

    private String title;

    Armor(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
