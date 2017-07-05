package ParserTree;

import java.util.ArrayList;

import Engine.*;
import Engine.Database;
import parser.QueryBaseVisitor;
import parser.QueryParser.*;

public class Program extends QueryBaseVisitor<Void> {

	Database database = new Database();
	public Program (Database database) {
		this.database = database;
	}

	@Override public Void visitOpen_cmd(Open_cmdContext ctx) {
		String relation =  ctx.getChild(1).accept(new Name());
		try {
			database.open(relation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override public Void visitClose_cmd(Close_cmdContext ctx) {
		String relation =  ctx.getChild(1).accept(new Name());
		database.close(relation);
		return null; 
		}
	@Override public Void visitWrite_cmd(Write_cmdContext ctx) {
		String relation =  ctx.getChild(1).accept(new Name());
		try {
			database.write(relation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

	@Override public Void visitExit_cmd(Exit_cmdContext ctx) {
		try {
			database.exit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override public Void visitShow_cmd(Show_cmdContext ctx) {
		// relation-name or atomic-expr
		String relation = ctx.getChild(1).accept(new Name());
		database.show(database.mapOfRelations.get(relation));
		return null; 
	}
	@Override  public Void visitCreate_cmd(Create_cmdContext ctx) {
		String relationName = ctx.getChild(1).accept(new Name());
		ArrayList<Domain<?>> typedAttrList = ctx.getChild(3).accept(new TypeList());
		ArrayList<String> key = ctx.getChild(7).accept(new AttributeList()); // primary key
		try {
			database.create(relationName, typedAttrList, key.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
	@Override public Void visitUpdate_cmd(Update_cmdContext ctx) {
		//'UPDATE' relation_name 'SET' attribute_name '=' Literal (',' attribute_name '=' Literal)* 'WHERE' condition;
		String relationName = ctx.getChild(1).accept(new Name());
		ArrayList<String> attributeNames = new ArrayList<>();
		ArrayList<String> newLiterals = new ArrayList<>();
		ArrayList<String> condition = new ArrayList<String>(ctx.getChild(ctx.getChildCount() - 1).accept(new AttributeList()));
		for (int i = 0; i < (ctx.getChildCount() - 5); i+=4) {
			attributeNames.add(ctx.getChild(i + 3).accept(new Name()));
			newLiterals.add(ctx.getChild(i + 5).getText());
		}

		try {
			database.update(relationName, attributeNames, newLiterals, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override public Void visitInsert_cmd(Insert_cmdContext ctx){
		String relationName = ctx.getChild(1).accept(new Name());
		if(ctx.getChild(2).getText().equals("VALUES FROM")){
			ArrayList<String> literals = new ArrayList<>();
			for(int i = 4; i < ctx.getChildCount(); i+=2) {
				literals.add(ctx.getChild(i).getText());
			}
			try {
				database.insert(relationName, literals);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// now we have a list of literals
		} else if (ctx.getChild(2).getText().equals("VALUES FROM RELATION")) {
			Relation relation = ctx.getChild(3).accept(new ChangedRelation(database));
			database.insert(relationName, relation);
		} else {
			try {
				throw new Exception("Error: Syntax not valid");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override public Void visitDelete_cmd(Delete_cmdContext ctx) { 
		//'DELETE FROM' relation_name 'WHERE' condition;
		String relationName = ctx.getChild(1).accept(new Name());
		ArrayList<String> condition = ctx.getChild(3).accept(new AttributeList());
		try {
			database.delete(relationName, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override public Void visitQuery(QueryContext ctx) { 
		//relation_name '<-' expr';';
		String relationName = ctx.getChild(0).accept(new Name());
		Relation newRelation = ctx.getChild(2).accept(new ChangedRelation(database)); // New Relation()... r = ...
		//function that prints a view of relation r
		newRelation.resetName(relationName);
		database.mapOfRelations.put(relationName, newRelation);
		return null;
	}
}
