/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;

import java.util.*;
import org.json.*;
//import org.apache.commons.cli.*;

/**
 *
 * @author fsalaman
 */
public class PayclipCCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Handle args, custom for specific reqs
        int cargs = args.length;
        switch(cargs) {
            case 1:
                ShowTransaction.tshow(args[0]);
                break;
            case 2:
                switch(args[1]) {
                    case "list":
                        ListTransactions.tlist(args[0]);
                        break;
                    case "sum":
                        SumTransactions.tsum(args[0]);
                        break;
                    default:
                        usoError();
                        System.exit(1);
                        break;
                }
                break;
            case 3:
                switch(args[1]) {
                    case "add":
                        AddTransaction.tadd(args[0],args[2]);
                        break;
                    default:
                        usoError();
                        System.exit(1);
                        break;
                }
                break;
            default:
                usoError();
                System.exit(1);
                break;
        }
        if(args.length<1) {
            usoError();
            System.exit(1);
        }
    }
    
    private static void usoError() {
        System.err.println("\nUsage: ");
        System.err.println("./application <userid> add <transaction-json>");
        System.err.println("./application <userid> list");
        System.err.println("./application <userid> sum");
        System.err.println("./application <transaction-id>\n");
    }
    
}
