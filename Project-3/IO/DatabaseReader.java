package IO;

import Engine.Attribute;
import Engine.Domain;
import Engine.Relation;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class DatabaseReader{

    private String path;
    private int RC_MAX = 195;
    private String[] readRelation;
    private int linesInFile = 0;
    private Relation relationExtracted = null;


    public DatabaseReader(String file_path) throws IOException {
        path = file_path;
        linesInFile = readLines();
        readRelation = OpenFile();
        construct();
    }

    private int readLines() throws IOException{

        FileReader sched_file = new FileReader(path);
        BufferedReader schedr = new BufferedReader(sched_file);

        String line;
        int numOfLines = 0;

        while((line = schedr.readLine()) != null){
            numOfLines++;
        }
        schedr.close();

        return numOfLines;
    }

    private String[] OpenFile() throws IOException{

        FileReader filer = new FileReader(path);
        BufferedReader textr = new BufferedReader(filer);

        String[] classData = new String[linesInFile];



        for(int i = 0; i < linesInFile; i++){
            classData[i] = textr.readLine();
        }

        textr.close();
        return classData;
    }

    private void construct() throws IOException {
        try {
            //string that reads in the file
            String flines[] = OpenFile();

            //name of the relation, passed to by the function
            String relName = "";

            //temp values
            Relation r = null;

            String tempCRN = "";
            String tempSubj = "";
            String tempCourse = "";
            String tempSect = "";
            String tempCmp = "";
            String tempCred = "";
            String tempTitle = "";
            String tempDay = "";
            String tempTime = "";
            String tempCap = "";
            String tempAct = "";
            String tempRem = "";
            String tempProf = "";
            String tempDate = "";
            String tempLoc = "";

            //SETS DOMAIN NAMES
            String domCRN = "";
            String domSubj = "";
            String domCourse = "";
            String domSect = "";
            String domCmp = "";
            String domCred = "";
            String domTitle = "";
            String domDay = "";
            String domTime = "";
            String domCap = "";
            String domAct = "";
            String domRem = "";
            String domProf = "";
            String domDate = "";
            String domLoc = "";

            //use this to get the entire file: flines.length
            for (int i = 0; i < flines.length; i++) {
                int relationCounter = 0;
                //IF THE LINE IS NOT BLANK
                if (!flines[i].isEmpty()){

                    //if a start of a new relation
                    if (flines[i].charAt(5) == '-') {
                        System.out.println("THIS IS THE START OF A NEW RELATION");

                        relationCounter++;
                        System.out.println(relationCounter);

                        relName = flines[i];
                        i++;

                        String[] nLine = (flines[i].split(","));
                        tempCRN = nLine[0];
                        tempSubj = nLine[1];
                        tempCourse = nLine[2];
                        tempSect = nLine[3];
                        tempCmp = nLine[4];
                        tempCred = nLine[5];
                        tempTitle = nLine[6];
                        tempDay = nLine[7];
                        tempTime = nLine[8];
                        tempCap = nLine[9];
                        tempAct = nLine[10];
                        tempRem = nLine[11];
                        tempProf = nLine[12];
                        tempDate = nLine[13];
                        tempLoc = nLine[14];

                        r = new Relation(new String(relName),//name
                                new Domain<Integer>(Integer.class, domCRN), //key
                                new Domain<String>(String.class, domSubj),//attributes
                                new Domain<Integer>(Integer.class, domCourse),
                                new Domain<Integer>(Integer.class, domSect),
                                new Domain<String>(String.class, domCmp),//attributes
                                new Domain<String>(String.class, domCred),
                                new Domain<String>(String.class, domTitle),//attributes
                                new Domain<String>(String.class, domDay),
                                new Domain<String>(String.class, domTime), //TIME IS A STRING AND NOT AN INT
                                new Domain<Integer>(Integer.class, domCap),
                                new Domain<Integer>(Integer.class, domAct),
                                new Domain<Integer>(Integer.class, domRem), //key
                                new Domain<String>(String.class, domProf),//attributes
                                new Domain<String>(String.class, domDate),
                                new Domain<String>(String.class, domLoc));
                    } else if (flines[i].charAt(0) != ',') {
                        //if start of a new CRN
                        System.out.println("THIS IS A NEW CRN LINE");

                        //set the TEMP VARIABLES
                        String[] nLine = (flines[i].split(","));
                        tempCRN = nLine[0];
                        tempSubj = nLine[1];
                        tempCourse = nLine[2];
                        tempSect = nLine[3];
                        tempCmp = nLine[4];
                        tempCred = nLine[5];
                        tempTitle = nLine[6];
                        tempDay = nLine[7];
                        tempTime = nLine[8];
                        tempCap = nLine[9];
                        tempAct = nLine[10];
                        tempRem = nLine[11];
                        tempProf = nLine[12];
                        tempDate = nLine[13];
                        tempLoc = nLine[14];

                        r.set(new Attribute(new Domain<Integer>(Integer.class, domCRN), tempCRN),
                                new Attribute(new Domain<String>(String.class, domSubj), tempSubj),
                                new Attribute(new Domain<Integer>(Integer.class, domCourse), tempCourse),
                                new Attribute(new Domain<Integer>(Integer.class, domSect), tempSect),
                                new Attribute(new Domain<String>(String.class, domCmp), tempCmp),
                                new Attribute(new Domain<String>(String.class, domCred), tempCred),
                                new Attribute(new Domain<String>(String.class, domTitle), tempTitle),
                                new Attribute(new Domain<String>(String.class, domDay), tempDay),
                                new Attribute(new Domain<String>(String.class, domTime), tempTime),
                                new Attribute(new Domain<Integer>(Integer.class, domCap), tempCap),
                                new Attribute(new Domain<Integer>(Integer.class, domAct), tempAct),
                                new Attribute(new Domain<Integer>(Integer.class, domRem), tempRem),
                                new Attribute(new Domain<String>(String.class, domProf), tempProf),
                                new Attribute(new Domain<String>(String.class, domDate), tempDate),
                                new Attribute(new Domain<String>(String.class, domLoc), tempLoc));


                        System.out.println( "This is what the function Parsed : " + tempCRN + " " + tempSubj + " " + tempCourse + " " + tempSect + " " + tempCmp + " " + tempCred + " " + tempTitle + " " + tempDay + " " + tempTime + " " + tempCap + " " + tempAct + " " + tempRem + " " + tempProf + " " + tempDate + " " + tempLoc);
                    } else {
                        System.out.println("SAME CRN BUT DIFF CLASS TIEM");

                        //set the TEMP VARIABLES
                        String[] nLine = (flines[i].split(","));
                        tempDay = nLine[7];
                        tempTime = nLine[8];
                        tempProf = nLine[9];
                        tempDate = nLine[10];
                        tempLoc = nLine[11];

                        //since only some of the temps change, the rest of them should be the same
                        r.set(new Attribute(new Domain<Integer>(Integer.class, domCRN), tempCRN),
                                new Attribute(new Domain<String>(String.class, domSubj), tempSubj),
                                new Attribute(new Domain<Integer>(Integer.class, domCourse), tempCourse),
                                new Attribute(new Domain<Integer>(Integer.class, domSect), tempSect),
                                new Attribute(new Domain<String>(String.class, domCmp), tempCmp),
                                new Attribute(new Domain<String>(String.class, domCred), tempCred),
                                new Attribute(new Domain<String>(String.class, domTitle), tempTitle),
                                new Attribute(new Domain<String>(String.class, domDay), tempDay),
                                new Attribute(new Domain<String>(String.class, domTime), tempTime),
                                new Attribute(new Domain<Integer>(Integer.class, domCap), tempCap),
                                new Attribute(new Domain<Integer>(Integer.class, domAct), tempAct),
                                new Attribute(new Domain<Integer>(Integer.class, domRem), tempRem),
                                new Attribute(new Domain<String>(String.class, domProf), tempProf),
                                new Attribute(new Domain<String>(String.class, domDate), tempDate),
                                new Attribute(new Domain<String>(String.class, domLoc), tempLoc));

                        System.out.println("This is what the function Parsed : " + tempDay + " " + tempTime + " " + tempProf + " " + tempDay + " " + tempDate + " " + tempLoc);
                        System.out.println( "This is what All OF THE TEMP variables are : " + tempCRN + " " + tempSubj + " " + tempCourse + " " + tempSect + " " + tempCmp + " " + tempCred + " " + tempTitle + " " + tempDay + " " + tempTime + " " + tempCap + " " + tempAct + " " + tempRem + " " + tempProf + " " + tempDate + " " + tempLoc);


                    }
                    System.out.println("This is the current line : " + flines[i] + "\n\n\n");
                }
            }
            relationExtracted = r;
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Relation get() {
        return relationExtracted;
    }

    void put() throws IOException{
        //open relationname.txt
        //for every row in the database
        //write in a line from all of the attributes
        //should be able to write every line. If line wasn't changed, it shouldn't matter
    }

    //is faulty, has errors...do n0t use
    /*
    void getDB() throws IOException{
        try {
            int currline = 0;
            String flines[] = OpenFile();

            //temp values

            String tempCRN = "";
            String tempSubj = "";
            String tempCourse = "";
            String tempSect = "";
            String tempCmp = "";
            String tempCred = "";
            String tempTitle = "";
            String tempDay = "";
            String tempTime = "";
            String tempCap = "";
            String tempAct = "";
            String tempRem = "";
            String tempProf = "";
            String tempDate = "";
            String tempLoc = "";
            String[] nLine;



            //use this to get the entire file: flines.length
            for (int relCount = 0; relCount < RC_MAX;) {

                //IF THE LINE IS NOT BLANK
                if (!flines[currline].isEmpty()){
                    //if a start of a new relation
                    if (flines[currline].charAt(5) == '-') {
                        System.out.println("THIS IS THE START OF A NEW RELATION");
                        relation_txt = flines[currline];
                        //CREATE NEW FILE
                        //OPEN NEW FILE
                        currline ++;
                        System.out.println(currline);
                        if(!flines[currline].isEmpty()) {

                            //need to fix this logic check to not include blank lines

                            while (!(flines[currline].charAt(5) == '-')) {
                                //WRITE RELATION TO FILE
                                currline++;
                                System.out.println(currline);
                                if(!flines[currline].isEmpty()){
                                    currline++;
                                    System.out.println(currline);
                                }
                            }
                        }
                        else{currline++;}
                        relCount++;
                        System.out.println("New Relation Reached!!!");
                    }
                    else{
                        currline++;
                    }


                }
            }

        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void getRelNum() throws IOException {

        try {
            System.out.println("Welcome to the Counting function");
            int counter = 0;
            String flines[] = OpenFile();

            for (int i = 0; i < flines.length; i++) {
                //System.out.println(i);
                //IF THE LINE IS NOT BLANK
                if(!flines[i].isEmpty()){
                    //IF THE LINE IS A NEW RELATION
                    if (flines[i].charAt(5) == '-') {
                        counter++;
                        System.out.println(counter);
                    }

                }
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    */
}