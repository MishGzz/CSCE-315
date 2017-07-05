package ParserTree;


import java.util.ArrayList;
import java.util.function.Predicate;

import ParserTree.Name;
import parser.QueryBaseVisitor;
import parser.QueryParser.*;


public class AttributeList extends QueryBaseVisitor<ArrayList<String>> {
	//Visitors that return and ArrayList of strings
	@Override public ArrayList<String> visitAttribute_list(Attribute_listContext ctx){
		// visits the attribute_list node
		ArrayList<String> attributes = new ArrayList<String>();
		for(int i = 0; i < ctx.getChildCount(); i+=2){
			attributes.add(ctx.getChild(i).accept(new Name()));
		}
		return attributes;
	}

	//the conditon, conjunction, and comparison visitors place all of their children into
	// a string array which the database can use to find the tuples we are looking for.

	@Override public ArrayList<String> visitCondition(ConditionContext ctx) {
		//visits the condition node recursively returns an array list
		ArrayList<String> list = new ArrayList<>();
		if(ctx.getChildCount() > 1){
			for(int i = 0; i < ctx.getChildCount(); i++){
				if(i%2 == 0){
					list.add(ctx.getChild(i).getText());
				}
				else{
					list.add(ctx.getChild(i).getText());
				}
			}
			System.out.println(list.get(0));
			return list;
		}
		else{
			return visit(ctx.getChild(0));
		}
	}

	@Override public ArrayList<String> visitConjunction(ConjunctionContext ctx) {
		//visits the condition node recursively returns an array list
		ArrayList<String> list = new ArrayList<>();
		if(ctx.getChildCount() > 1){
			for(int i = 0; i < ctx.getChildCount(); i++){
				if(i%2 == 0){
					list.addAll(visit(ctx.getChild(i)));
				}
				else{
					list.add(ctx.getChild(i).getText());
				}
			}
			return list;
		}
		else{
			return visit(ctx.getChild(0));
		}
	}

	@Override public ArrayList<String> visitComparison(ComparisonContext ctx) {
		//visits the condition node recursively returns an array list

		if(ctx.getChild(0).getText().equals("(")){//condition
			return visit(ctx.getChild(1));
		}
		else{//operand op operand
			ArrayList<String> list = new ArrayList<>();
			list.add(ctx.getChild(0).accept(new Name()));
			list.add(ctx.getChild(1).accept(new Name()));
			list.add(ctx.getChild(2).accept(new Name()));
			return list;
		}
	}
}