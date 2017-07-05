import Engine.*;
import IO.RelationReader;
import ParserTree.Program;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.QueryLexer;
import parser.QueryParser;
import parser.QueryVisitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jaredwheeler on 7/3/17.
 */
public class Main {

    static public Database database = new Database();


    static public Relation parser (String commandLine) {

        String[] commmand = commandLine.split(" ");
        return null;
    }







    public static void main(String[] args) {


        ArrayList<Tuple> tuples = new ArrayList<Tuple>();

        Relation relation1 = new Relation(new String("Reddit"),//name
                new Domain<Integer>(Integer.class, "Karma"), //key
                new Domain<Integer>(Integer.class, "Karma"),//attributes
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "PostCount"));
        //
        relation1.set(new Attribute(new Domain<Integer>(Integer.class, "Karma"), 666), //key
                new Attribute(new Domain<Integer>(Integer.class, "Karma"), 666), //attributes
                new Attribute(new Domain<String>(String.class, "UserName"), "deleteSystem32"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 420));

        Attribute key1 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 69);
        tuples.add(new Tuple(key1,
                new Attribute(new Domain<String>(String.class, "UserName"), "Windows7Sux"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 3)));
        relation1.getTuplesInRelation().put(key1, tuples.get(0));



        Relation relation2 = new Relation(new String("FaceBook"),
                new Domain<Integer>(Integer.class, "Likes"),//key
                new Domain<Integer>(Integer.class, "Likes"),
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "Friends"));
        relation2.set(new Attribute(new Domain<Integer>(Integer.class, "Likes"), 1337),
                new Attribute(new Domain<Integer>(Integer.class, "Likes"), 1337),
                new Attribute(new Domain<String>(String.class, "UserName"), "Jonny Dips"),
                new Attribute(new Domain<Integer>(Integer.class, "Friends"), 222));
        Attribute key2 = new Attribute(new Domain<Integer>(Integer.class, "Likes"), 398);
        tuples.add(new Tuple(key1,
                new Attribute(new Domain<String>(String.class, "UserName"), "Connor Ukraine Montana"),
                new Attribute(new Domain<Integer>(Integer.class, "Friends"), 3)));
        relation2.getTuplesInRelation().put(key2, tuples.get(1));

        Relation relation3 = new Relation(new String("GameFAQs"),
                new Domain<Integer>(Integer.class, "Karma"), //key
                new Domain<Integer>(Integer.class, "Karma"),
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "PostCount"));
        relation3.set(new Attribute(new Domain<Integer>(Integer.class, "Karma"), 69),
                new Attribute(new Domain<Integer>(Integer.class, "Karma"), 69),
                new Attribute(new Domain<String>(String.class, "UserName"), "rm-rf--no-preserve-root"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 33));

        Attribute key3 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 9001);
        tuples.add(new Tuple(key3,
                new Attribute(new Domain<String>(String.class, "UserName"), "LinuxIsMessiah"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 13377)));
        relation3.getTuplesInRelation().put(key3, tuples.get(2));

        Attribute key4 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 2);
        tuples.add(new Tuple(key4,
                new Attribute(new Domain<String>(String.class, "UserName"), "n00bWindowsLover"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 0)));
        relation3.getTuplesInRelation().put(key4, tuples.get(3));

        File file = new File("test2.txt");
        if (file.exists())
            file.delete();

        database.mapOfRelations.put("Reddit", relation1);
        database.mapOfRelations.put("FaceBook", relation2);
        database.mapOfRelations.put("GameFAQs", relation3);


        String command1 = "OPEN relation";
        String command2 = "CREATE relation (name VARCHAR(20), kind VARCHAR(10), years INTEGER) PRIMARY KEY (name)";
        String command3 = "dogs <- select (kind == \"dog\") animals";
        String command4 = "INSERT INTO species VALUES FROM RELATION project (kind)\n\"animals;\"";
        String command5 = "\n" +
                "a <- rename (aname, akind) (project (name, kind) animals);\n" +
                "common_names <- project (name) (select (aname == name &&\n" +
                "akind != kind) (a * animals));";
        parser(command3);

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            //str = reader.readLine();
            // create a CharStream that reads from standard input
            // UnbufferedCharStream input = new UnbufferedCharStream(is);
            String userInput = in.nextLine();
            ANTLRInputStream input = new ANTLRInputStream(userInput);

            // create a lexer that feeds off of input CharStream
            QueryLexer lexer = new QueryLexer(input);
            lexer.setTokenFactory(new CommonTokenFactory(true));
            // create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // create a parser that feeds off the tokens buffer
            QueryParser parser = new QueryParser(tokens);

            // begin parsing at rule 'statement' (my root rule)
            ParseTree tree = parser.program();

            tree.accept(new Program(database));
        }


    }
}
