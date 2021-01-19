import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecretFruits {


    public boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList) {
        if (secretFruitList.size() == 1 && secretFruitList.get(0).size() == 1 && secretFruitList.get(0).get(0).equals("anything"))
            return false;
        int i = 0, j = 0;
        for (int k = 0; k < customerPurchasedList.size(); k++) {
            //when match success
            if (secretFruitList.get(i).get(j).equals(customerPurchasedList.get(k))
                    || secretFruitList.get(i).get(j).equals("anything")) {
                j++;
                if (j == secretFruitList.get(i).size()) {
                    i++;
                    j = 0;
                }
                if (i == secretFruitList.size())
                    return true;
            } else {
                //when match failed, k and j both go back.
                k -= j;
                j = 0;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        SecretFruits o = new SecretFruits();
        System.out.println(o.matchSecretLists(Arrays.asList(new List[]{Arrays.asList("o",  "m"),Arrays.asList("w",  "m")}),
                Arrays.asList("o","m", "s", "w","m")));
    }

}
