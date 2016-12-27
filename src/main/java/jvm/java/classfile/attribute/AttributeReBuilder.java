package jvm.java.classfile.attribute;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by admin on 2016/12/27.
 */
public class AttributeReBuilder {

    static AttributeReBuilder attributeReBuilder = new AttributeReBuilder();

    public static AttributeInfo build(AttributeInfo attributeInfo) throws IOException {

        try {
            return attributeReBuilder.rebuild(attributeInfo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return attributeInfo;
    }

    Filter filter;

    public AttributeReBuilder() {
        filter=new Filter(AttributeInfo.ATTR_Code, CodeAttribute.class);
        filter.link(new Filter(AttributeInfo.ATTR_ConstantValue, ConstantValueAttribute.class ));
        filter.link(new Filter(AttributeInfo.ATTR_Deprecated, DeprecatedAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_Exceptions, ExceptionsAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_InnerClasses, InnerClassAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_LineNumberTable, LineNumberTableAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_LocalVariableTable, LocalVariableTableAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_Signature, SignatureAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_SourceFile, SourceFileAttribute.class));
        filter.link(new Filter(AttributeInfo.ATTR_Synthetic, SyntheticAttribute.class));
    }

    public AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        AttributeInfo info = filter.filter(attributeInfo);
        if (info != null) {
            return info;
        } else {
            System.out.println("WARN\tthere is no Attribute Rebuild Filter to rebuild this attributeinfo :" + attributeInfo.attribute_name());
            return attributeInfo;
        }
    }

    class Filter {
        String attribute_name;
        Filter next = null;
        Class<?> clazz = null;
        Constructor<?> constructor = null;

        Filter(String attribute_name, Class<?> clazz) {
            this.attribute_name = attribute_name;
            this.clazz = clazz;
        }

        AttributeInfo filter(AttributeInfo attributeInfo) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            if (this.attribute_name.equals(attributeInfo.attribute_name()))
                return this.rebuild(attributeInfo);
            if (next != null)
                return next.filter(attributeInfo);
            else
                return null;
        }

        AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            if (constructor == null) {
                constructor = clazz.getConstructor(AttributeInfo.class);
            }
            return (AttributeInfo) constructor.newInstance(attributeInfo);
        }

        Filter link(Filter filter) {
            if (this.next != null) {
                this.next.link(filter);
            } else
                this.next = filter;
            return this;
        }
    }

//    class CodeAttributeFilter extends Filter {
//
//        CodeAttributeFilter() {
//            super("Code");
//        }
//
//        AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException {
//            return new CodeAttribute(attributeInfo);
//        }
//    }
//
//    class SourceFileAttributeFilter extends Filter {
//
//        SourceFileAttributeFilter() {
//            super("SourceFile");
//        }
//
//        @Override
//        AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException {
//            return new SourceFileAttribute(attributeInfo);
//        }
//    }
//
//    class ConstantValueAttributeFilter extends Filter{
//
//        ConstantValueAttributeFilter() {
//            super("Cons");
//        }
//
//        @Override
//        AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException {
//            return null;
//        }
//    }

}
