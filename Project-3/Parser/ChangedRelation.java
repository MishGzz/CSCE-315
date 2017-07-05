package ParserTree;

import java.util.ArrayList;
import java.util.function.Predicate;

import Engine.Attribute;
import Engine.Database;
import Engine.Relation;
import com.sun.org.apache.xerces.internal.xs.StringList;
import parser.QueryBaseVisitor;
import parser.QueryParser.*;


public class ChangedRelation extends QueryBaseVisitor<Relation> {

	Database database = new Database();

	ChangedRelation (Database database) {
		this.database = database;
	}


	@Override public Relation visitExpr(ExprContext ctx) { return visit(ctx.getChild(0)); }
	@Override public Relation visitAtomic_expr(Atomic_exprContext ctx) {
		if(ctx.getChildCount() > 1){
			return visit(ctx.getChild(1));
		}
		else{
			return visit(ctx.getChild(0)); 
		}
	}
	@Override public Relation visitSelection(SelectionContext ctx) { 
		//get ctx.getChild(2) tuples from relation ctx.getChild(4);
		//'select' '('condition')' atomic_expr;
		Relation atomicExpr = visit(ctx.getChild(4));
		ArrayList<String> condition = ctx.getChild(2).accept(new AttributeList());
		Relation newRelation = database.selection(condition, atomicExpr);
		return newRelation;
	}
	@Override public Relation visitProjection(ProjectionContext ctx)  {
		// 'project' ( attribute-list ) atomic-expr
		// select subset of attributes from relation
		Relation relation = visit(ctx.getChild(4));
		ArrayList<String> attributeList = ctx.getChild(2).accept(new AttributeList());
		Relation newRelation = null;
		try {
			newRelation = database.projection(relation, attributeList.toArray(new String[attributeList.size()]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newRelation;
	}
	@Override public Relation visitRenaming(RenamingContext ctx) {
		 // 'rename' ( attribute-list ) atomic-expr
		//rename the attributes in a relation
		Relation relation = visit(ctx.getChild(4));
		//Relation newRelation = new Relation();
		ArrayList<String> list = ctx.getChild(2).accept(new AttributeList());
		Relation newRelation = null;
		try {
			newRelation = database.renaming(relation, list.get(0), list.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newRelation;
	}
	@Override public Relation visitUnion(UnionContext ctx) {
		//atomic-expr + atomic-expr
		//compute the union of two relations; the relations must be union-compatible
		Relation r1 = visit(ctx.getChild(0));
		Relation r2 = visit(ctx.getChild(2));
		Relation newRelation = null;
		try {
			newRelation = database.unions(r1, r2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//do union and return new relation
		return newRelation;
	}
	@Override public Relation visitDifference(DifferenceContext ctx) {
		//atomic-expr - atomic-expr
		// compute the set difference of two relations; the relations must be union-compatible.
		Relation r1 = visit(ctx.getChild(0));
		Relation r2 = visit(ctx.getChild(2));
		//do difference and return new relation
		Relation newRelation = null;
		try {
			newRelation = database.difference(r1, r2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newRelation;
	}
	@Override public Relation visitProduct(ProductContext ctx) { 
		// atomic-expr * atomic-expr
		Relation r1 = visit(ctx.getChild(0));
		Relation r2 = visit(ctx.getChild(2));
		//do Product and return new relation
		Relation newRelation = null;
		try {
			newRelation = database.product(r1, r2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newRelation;
	}
	@Override public Relation visitNatural_join(Natural_joinContext ctx) { 
		//atomic-expr & atomic-expr
		//compute the combination of all tuples in two relations, say, R & S, which are equal on their common attribute names. The common attributes only appear once in the result
		Relation r1 = visit(ctx.getChild(0));
		Relation r2 = visit(ctx.getChild(2));
		//do nat_join and return new relation
		Relation newRelation = null;
		try {
			newRelation = database.naturalJoin(r1, r2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newRelation;
	}
	@Override public Relation visitRelation_name(Relation_nameContext ctx){
		Relation relation = database.mapOfRelations.get(ctx.getChild(0).getText());
		return relation;
	}



}
