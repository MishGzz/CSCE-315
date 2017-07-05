package ParserTree;

import parser.QueryBaseVisitor;
import parser.QueryParser.*;

public class Name extends QueryBaseVisitor<String> {
	
	@Override public String visitRelation_name(Relation_nameContext ctx){return ctx.getChild(0).getText();}
	@Override public String visitAttribute_name(Attribute_nameContext ctx){return ctx.getChild(0).getText();}
	@Override public String visitType(TypeContext ctx){
		String type = "";
		for(int i = 0; i < ctx.getChildCount(); i++){
			type += ctx.getChild(i).getText();
		}
		return type;
	}
	@Override public String visitOperand(OperandContext ctx) {
		return ctx.getChild(0).getText();
	}
	@Override public String visitOp(OpContext ctx) {
		return ctx.getChild(0).getText();
	}
}

