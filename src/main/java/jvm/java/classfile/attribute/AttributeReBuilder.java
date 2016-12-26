package jvm.java.classfile.attribute;

import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class AttributeReBuilder {
    Filter filter;

    public AttributeReBuilder() {
        filter = new CodeAttributeFilter();
    }

    public AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException {
        AttributeInfo info = filter.filter(attributeInfo);
        if (info != null) {
            return  info;
        }else {
            System.out.println("WARN\tthere is no Attribute Rebuild Filter to rebuild this attributeinfo :" + attributeInfo.attribute_name());
            return  attributeInfo;
        }
    }

     abstract class Filter{
        String attribute_name;
        Filter next = null;
        Filter(String attribute_name){
            this.attribute_name = attribute_name;
        }

        AttributeInfo filter(AttributeInfo attributeInfo) throws IOException {
            if (this.attribute_name.equals(attributeInfo.attribute_name()))
                return this.rebuild(attributeInfo);

            if (next != null)
                return next.filter(attributeInfo);
            else
                return null;
        }

        abstract  AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException;

        Filter link(Filter filter) {
            this.next = filter;
            return  this.next;
        }
    }

     class CodeAttributeFilter extends  Filter{

         CodeAttributeFilter() {
             super("Code");
         }

         AttributeInfo rebuild(AttributeInfo attributeInfo) throws IOException {
             return  new CodeAttribute(attributeInfo);
         }
     }


}
