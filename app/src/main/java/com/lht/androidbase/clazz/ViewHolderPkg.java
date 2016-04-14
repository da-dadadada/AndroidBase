package com.lht.androidbase.clazz;

/**
 * @package com.lht.androidbase.clazz
 * @project AndroidBase
 * @classname ViewHolderPkg
 * @description: TODO
 * Created by leobert on 2016/4/6.
 */
public class ViewHolderPkg<T extends ABSViewHolder> {
    private T container;

    public ViewHolderPkg() {
    }

    public ViewHolderPkg(T container) {
        setContainer(container);
    }

    public T getContainer() {
        return container;
    }

    public void setContainer(T container) {
        this.container = container;
    }
}
