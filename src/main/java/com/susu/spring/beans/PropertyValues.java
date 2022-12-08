package com.susu.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: Bean 的属性列表</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class PropertyValues {

    /**
     * Bean 的属性列表
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加一个属性
     */
    public void addPropertyValue(PropertyValue pv) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentPv = this.propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())) {
                this.propertyValueList.set(i, pv);
                return;
            }
        }
        this.propertyValueList.add(pv);
    }

    /**
     * 获取所有属性
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * <p>Description: 根据属性名称获取属性</p>
     *
     * @param propertyName  属性名称
     * @return 属性值
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue property : this.propertyValueList) {
            if (property.getName().equals(propertyName)) {
                return property;
            }
        }
        return null;
    }
}
