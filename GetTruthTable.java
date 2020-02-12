//  TODO: change binary term to binary product in variable name

//  Andy Sokolowski    --     okay, let's see if I can generate a truth table
//  from a given string

import java.util.List;
import java.util.ArrayList;

class GetTruthTable {
  public static void main(String[] args) {
    //  warn user if no arguments are provided
    if (args.length == 0) {
      System.out.println("Must provide an argument in the form of minterms, i" +
          "n canonical form with no\nspaces.\nExample:\njava GetTruthTable");
    } else if (args.length == 1) {
      String arg0 = args[0].toLowerCase();

      //  help screen access
      if (arg0.equals("--help") || arg0.equals("-h")) {
        System.out.println("TODO: make help screen");
      //  fires "main" program
      } else {
        List<Character> terms = new ArrayList<Character>();
        List<String> products = new ArrayList<String>();
        List<String> binaryProducts = new ArrayList<String>();

        int numTerms, numProducts;

        System.out.println(arg0);

        // TODO: Verify that terms can be extracted from string

        // extract terms and store them in an array
        terms = getTerms(arg0);
        numTerms = terms.size();

        // debug: show terms:
        System.out.println();
        for (char term : terms) {
          System.out.println(term);
        }

        //  get products (i.e. separate into each minterm)
        products = getProducts(arg0);
        numProducts = products.size();

        //  debug: show products:
        System.out.println();
        for (String product : products) {
          System.out.println(product);
        }

        // TODO: Verify that form is canonical
        // TODO: Verify God knows what else

        // convert terms to binary form:
        binaryProducts = convert(products, numTerms);

        //  debug: show binaryProducts:
        System.out.println();
        for (String bp : binaryProducts) {
          System.out.println(bp);
        }
      }
    //  warn user if too many arguments
    } else if (args.length > 1) {
      System.out.println("Too many arguments. Use --help or -h to view help s" +
        "creen.");
    }
  }

  private static List<Character> getTerms(String expression) {
    List<Character> terms = new ArrayList<Character>();

    for (char ch : expression.toCharArray()) {
      if (Character.isAlphabetic(ch)) {
        terms.add(ch);
      } else if (ch == '+') {
        break;
      }
    }

    return terms;
  }

  private static List<String> getProducts(String expression) {
    List<String> products = new ArrayList<String>();
    String builder = "";

    for (char ch : expression.toCharArray()) {
      if (ch == '+') {
        products.add(builder);
        builder = "";
      } else {
        builder += ch;
      }
    }

    products.add(builder);
    return products;
  }

/* lol just for comparison...

  getProducts(expression) {
    const products = [];
    let builder = '';

    for (let ch of expression) {
      if (ch === '+') {
        products.push(builder);
        builder = '';
      } else {
        builder += ch;
      }
    }

    products.push(builder);
    return products;
  }
*/

  private static List<String> convert(List<String> decProducts, int numTerms) {
    List<String> binaryProducts = new ArrayList<String>();

    for (String product : decProducts) {
      int index = 0;
      int maxLength = numTerms * 2;
      String currentProduct = "";

      while (index < maxLength) {
        if (index >= product.length()) {
          break;
        }

        // TODO: make this work for when last term is True
        if (product.charAt(index + 1) == '^') {
          currentProduct += "0";
          index += 2;
        } else {
          currentProduct += "1";
          index++;
        }
      }

      binaryProducts.add(currentProduct);
    }

    return binaryProducts;
  }
}
