package co.edu.eci.arep.collatz;

import java.util.ArrayList;

import java.util.ArrayList;

import static spark.Spark.*;

public class Collatz {

    private static ArrayList<Integer> myList = new ArrayList<Integer>();

    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());

        get("collatzsequence", (req,res) -> {
            String value = req.queryParams("value");
            res.type("application/json");
            return "{\n" +
                    "\n" +
                    " \"operation\": \"collatzsequence\",\n" +
                    "\n" +
                    " \"input\":  "+ value +",\n" +
                    "\n" +
                    " \"output\": \"" + collatzSequence(value) +
                    "\"\n" +
                    "}";
        });

    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String collatzSequence(String number) {
        myList = new ArrayList<Integer>();
        int num = Integer.parseInt(number);

        if (num == 0) {
            return "0";
        }

        myList.add(num);
        buildListSequence(num);
        String answer = buildStringSequence();

        return answer;

    }


    private static ArrayList<Integer> buildListSequence(int num) {
        if (num == 1) {
            return myList;
        }
        else if (num % 2 == 0) {
            num = num /2;
        } else {
            num = 3 * num + 1;
        }

        myList.add(num);
        return buildListSequence(num);

    }

    private static String buildStringSequence() {
        String answer = "";
        for(int i = 0; i < myList.size()-1; i++) {
            answer += myList.get(i) + " -> ";
        }
        answer += myList.get( myList.size()-1 );
        return answer;
    }


}






















