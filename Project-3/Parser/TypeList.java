package ParserTree;

import java.util.ArrayList;

import Engine.Attribute;
import Engine.Domain;
import parser.QueryBaseVisitor;
import parser.QueryParser.*;


public class TypeList extends QueryBaseVisitor<ArrayList<Domain<?>>> {
	@Override public ArrayList<Domain<?>> visitTyped_attribute_list(Typed_attribute_listContext ctx){
		ArrayList<Domain<?>> relationDomains = new ArrayList<>();
		//check all children in the list
		for (int i = 0; i < ctx.getChildCount(); i+=3) {
			//first child is the attribute name
			String name = ctx.getChild(i).accept(new Name());
			//second child is the type
			String type = ctx.getChild(i + 1).accept(new Name());
			//if type string contains text INTEGER, then create Integer Domain
			if (type.contains("INTEGER")) {
				Domain<Integer> integerDomain = new Domain<Integer>(Integer.class, name);
				relationDomains.add(integerDomain);
			} else if (type.contains("VARCHAR")) {
				//if type string contains text VARCHAR, then create String Domain
				//Split the type extracted into two,
				//gives temp [VARCHAR, 20)]
				String[] temp = type.split("\\(");
				//Domain is type String, VARCHAR, then it takes off the parens at the end by
				//temp[1].substring(temp[1].length() - 1
				//which leaves 20 not 20)
				Domain<String> stringDomain = new Domain<String>(String.class, name, Integer.valueOf(temp[1].substring(0, temp[1].length() - 1)));
				relationDomains.add(stringDomain);
			}
		}
		return relationDomains;
	}
}